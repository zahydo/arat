package arat.business.implementations;

import arat.business.interfaces.Reflection;
import arat.business.rationale.Information;
import arat.business.rationale.Rationale;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

/**
 *
 * @author sahydo
 */
public class Reflection_Impl_JAR implements Reflection {

    private Reflections reflections;

    /**
     *
     * @return Set of methods annotated with Rationale
     */
    @Override
    public Set<Method> getMethodsAnnotatedWithRationale() {
        return reflections.getMethodsAnnotatedWith(Rationale.class);
    }

    /**
     *
     * @return Set of classes annotated with Rationale
     */
    @Override
    public Set<Class<?>> getClasesAnnotatedWhitRationale() {
        return reflections.getTypesAnnotatedWith(Rationale.class);
    }

    /**
     *
     * @return HashMap of annotations @Rationale with its Information for each
     */
    @Override
    public HashMap<Information, Rationale> getRationaleInformation() {
        Set<Class<?>> annotatedClasses = getClasesAnnotatedWhitRationale();
        Set<Method> annotatedMethods = getMethodsAnnotatedWithRationale();
        HashMap<Information, Rationale> data = new HashMap<>();
        annotatedMethods.forEach((annotatedMethod) -> {
            String aux[] = annotatedMethod.toString().split(" ");
            String path = aux[aux.length - 1];
            String name = annotatedMethod.getName();
            String type = annotatedMethod.getClass().getSimpleName();
            Information info = new Information(path, name, type);
            for (Rationale rationale : annotatedMethod.getAnnotationsByType(Rationale.class)) {
                data.put(info, rationale);
            }
        });
        annotatedClasses.forEach((annotatedClass) -> {
            String path = annotatedClass.getCanonicalName();
            String name = annotatedClass.getSimpleName();
            String type = annotatedClass.getClass().getSimpleName();
            Information info;
            if (name.equals("package-info")) {
                info = new Information(path, name, "Package");
            } else {
                info = new Information(path, name, type);
            }
            for (Rationale rationale : annotatedClass.getAnnotationsByType(Rationale.class)) {
                data.put(info, rationale);
            }
        });
        return data;
    }
    /**
     *
     * @param modelPackage specify the package to scan with reflection
     */
    @Override
    public void configureReflection(String modelPackage){
        //Se debe especificar el tipo de scanners que se quieren ejecutar (Type y Method)
        //Se debe especificar la url del paquete que se quiere inspeccionar
        //se debe agregar un filtro para realizar las busquedas en el paquete
        reflections = new Reflections(
                new ConfigurationBuilder()
                        .setUrls(ClasspathHelper.forPackage(modelPackage))
                        .setScanners(
                                new TypeAnnotationsScanner(),
                                new MethodAnnotationsScanner()
                        )
                        .filterInputsBy(new FilterBuilder().includePackage(modelPackage))
        );
    }
}

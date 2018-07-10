package com.unicauca.arat.business.model.reporter;

import com.unicauca.arat.business.model.interfaces.Reflection;
import com.unicauca.arat.business.model.rationale.Rationale;
import java.lang.reflect.Method;
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
public class ReflectionJAR_Impl implements Reflection {

    private final Reflections reflections;

    /**
     *
     * @param modelPackage specify the package to scan with reflection
     */
    public ReflectionJAR_Impl(String modelPackage) {
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

}

package com.unicauca.arat.business.tools.reporter;

//import java.lang.annotation.Annotation;
import com.unicauca.arat.business.model.Rationale;
import java.lang.reflect.Method;
//import java.util.ArrayList;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
//import org.unicauca.annotations.model.Component;


public class AnnotationsReflection {
    private Reflections reflections;
    
    public AnnotationsReflection(String modelPackage){
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
    public Set<Method> getMethodsAnnotatedWithRationale(){
        return reflections.getMethodsAnnotatedWith(Rationale.class);
    }
    public Set<Class<?>> getClasesAnnotatedWhitRationale(){
        return reflections.getTypesAnnotatedWith(Rationale.class);
    }
    
}

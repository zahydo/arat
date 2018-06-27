/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.arat.business.model;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 *
 * @author sahydo
 */
//Para que aparezcan los componentes marcados con esta anotación en el documento generado por javadoc
@Documented
//Retención del archivo de clases en tiempo de ejecución para acceder por Reflección
@Retention(RUNTIME)
//Objetivo de anotación: métodos, clases y clases pagacke-info que representan los paquetes
@Target({METHOD,PACKAGE,TYPE})
public @interface Rationale {
    enum AtributoDeCalidad {ADECUACION_FUNCIONAL, EFICIENCIA_DESEMPENIO, COMPATIBILIDAD, USABILIDAD,
                    FIABILIDAD, SEGURIDAD, MANTENIBILIDAD, PORTABILIDAD}
    String id() default "";
    boolean hiden() default false;
    AtributoDeCalidad[] atributos_de_calidad(); //1
    String[] causas();//2
    String[] tacticas() default {};//3
    String[] patrones() default {};//4
    String[] alternativas() default {}; //5
    String[] registro_de_decisiones();//6
    String[] razones();//7
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arat.business.rationale;

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
@Target({METHOD, PACKAGE, TYPE})
public @interface Rationale {

    // Atributos de calidad del producto software basados en la norma ISO 25010 http://iso25000.com/index.php/normas-iso-25000/iso-25010
    enum QualityAtribute {
        FUNCTIONAL_ADECUATION, PERFORMANCE, COMPATIBILITY, USABILITY,
        RELIABILITY, SECURITY, MAINTENANCE, PORTABILITY
    }

    // Atributos miembro de configuración
    String id() default ""; // 0: Es recomendable establecer un identificador que sirva para controlar una jerarquía al estilo de un arbol de información

    boolean hiden() default false; // Permite ocultar esta anotación al generar el reporte
    
    String[] links() default {};

    // Atributos miembro del Rationale
    QualityAtribute[] quality_attributes(); // 1: Establecer el(los) atributo(s) de calidad que se quieren documentar

    String[] causes(); //2: Establecer las causas de la necesidad de cumplimiento de el(los) atributo(s) de calidad

    String[] tactics() default {};//3: Se documentan las tácticas si se aplican

    String[] patterns() default {};//4: En caso de que existan tácticas estas frecuentemente relacionan patrones (las cuales dan forma a estrategias de arquitectura)

    String[] alternatives() default {}; //5: Se describen las posibles estrategias para abordar las mismas necesidades de calidad

    String[] decisions_record();//6: Se registran las decisiones tomadas para abordar con los atributos de calidad, las causas, las posibles estrategias y las razones de estas

    String[] reasons();//7: Se especifican las razones del porqué se toma una determinada decisión
}

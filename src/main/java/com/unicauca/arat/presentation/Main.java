/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.arat.presentation;

import com.unicauca.arat.business.model.rationale.Rationale;

/**
 *
 * @author sahydo
 */
@Rationale(
        id = "1",
        hiden = true,
        quality_attributes = Rationale.QualityAtribute.PERFORMANCE,
        causes = {"El sistema es un aplicativo web de comercio electrónico muy concurrido "
                + "en el cual se registran más de 1000 peticiones por minuto.",
                  "Cada petición al servidor representa una posible compra, es por esto que "
                + "el sistema debe responder de la manera adecuada y permitir al usuario "
                + "terminar con su transacción de manera satisfactoria y en el menor tiempo posible"},
        alternatives = {"Poner un servidor espejo el cual me responda a las peticiones en caso de "
                        + "que el servidor principal colapse por la cantidad de solicitudes de usuarios.",
                        "Sacar los componentes que se ven más afectados por el volumen de petición de "
                        + "los usuarios y definirlos en un servicio aparte",
                        "Introducir métodos que permitan la concurrencia a través de balanceo de carga.",
                        "Aumentar la capacidad de recursos físicos"},
        patterns = {"Ptrón arquitectural Multinivel"},
        tactics = {"Separación de responsabilidades","abstracción de servicios comunes"},
        decisions_record = {"Se realizan las consideraciones teniendo en cuenta las ventajas y "
                        + "desventajas de cada alternativa, a lo cual se llega que es mejor separar "
                        + "los componentes más afectados en un componente aparte."},
        reasons = {"Poner un servidor espejo no sería de utilidad ya que en caso de que el servidor "
                + "espejo falle se perderían las peticiones del usuario al sistema.",
                    "Respecto a los métodos de balanceo de carga y aumento de los recursos físicos "
                + "no son posibles debido a que no se cuenta con más recursos físicos disponibles."}
)
public class Main {

    /**
     * @param args the command line arguments
     */
    @Rationale(
            id = "1.1",
            hiden = false,
            quality_attributes = Rationale.QualityAtribute.PERFORMANCE,
            causes = {"Causas que describen la necesidad de calidad"},
            alternatives = {"Alternativas que se consideran para tomar"
                    + "una decisión"},
            tactics = {"Definición de tácticas(opcional)"},
            patterns = {"Definición de patrones relacionados a las tácticas"},
            decisions_record = {"Registro de decisiones que se "
                    + "toman sobre el tiempo"},
            reasons = {"Razones por las cuales se toman "
                    + "las anteriores decisiones"}
    )
    public static void main(String[] args) {
        // Para generar el reporte de todas las anotaciones 
        // en un solo archivo .pdf
        RationaleFacade.generateReportByAll("com");
        // Para generar el reporte .pdf por cada una de
        // las anotaciones.
        RationaleFacade.generateReportsByOne("com");
    }

}

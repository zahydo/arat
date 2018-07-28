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
        causes = {"causa número 1", "otra causa"},
        quality_attributes = Rationale.QualityAtribute.FUNCTIONAL_ADECUATION,
        decisions_record = {"Esta es la primera decisión que se tomó"},
        reasons = {"Por estas razones"},
        alternatives = {"Tuvimos en cuenta estas alternativas"},
        patterns = {"La cual considera los siguientes patrones"},
        tactics = {"De las siguientes tácticas"},
        hiden = false
)
public class Main {

    /**
     * @param args the command line arguments
     */
    @Rationale(
            id = "1",
            causes = {"causa número 1", "otra causa"},
            quality_attributes = Rationale.QualityAtribute.FUNCTIONAL_ADECUATION,
            decisions_record = {"Esta es la primera decisión que se tomó"},
            reasons = {"Por estas razones"},
            alternatives = {"Tuvimos en cuenta estas alternativas"},
            patterns = {"La cual considera los siguientes patrones"},
            tactics = {"De las siguientes tácticas"},
            hiden = false
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

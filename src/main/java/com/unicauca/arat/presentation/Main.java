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
        causes = {"causa número 1","otra causa"},
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
    public static void main(String[] args) {
        // TODO code application logic here
        RationaleFacade.generateReportByAll("com");
    }
    
}

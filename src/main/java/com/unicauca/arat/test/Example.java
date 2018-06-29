/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.arat.test;

import com.unicauca.arat.business.model.Rationale;

/**
 *
 * @author sahydo
 */
@Rationale(
        id = "1",
        quality_attributes = {Rationale.QualityAtribute.MAINTENANCE, Rationale.QualityAtribute.PERFORMANCE},
        causes = {"Es necesario que el sistema se pueda modificar a futuro"},
        decisions_record = {"Se toma esta decisión"},
        alternatives = {"Se tienen las siguientes alternativas"},
        tactics = {"Se realiza la siguiente táctica"},
        patterns = {"Se realizan los siguientes patrones"},
        reasons = {"Se hizo lo anterior debido a que..."}
)
public class Example {

}

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
        atributos_de_calidad = {Rationale.AtributoDeCalidad.MANTENIBILIDAD, Rationale.AtributoDeCalidad.EFICIENCIA_DESEMPENIO},
        causas = {"Es necesario que el sistema se pueda modificar a futuro"},
        registro_de_decisiones = {"Se toma esta decisión"},
        alternativas = {"Se tienen las siguientes alternativas"},
        tacticas = {"Se realiza la siguiente táctica"},
        patrones = {"Se realizan los siguientes patrones"},
        razones = {"Se hizo lo anterior debido a que..."}
        
)
public class Example {
    
}

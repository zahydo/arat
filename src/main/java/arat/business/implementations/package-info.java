/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@Rationale(id = "1.3",
        hiden = true,
        quality_attributes = Rationale.QualityAtribute.PORTABILITY,
        causes = "Las implementaciones de las interfaces deben ser sencillas y no requerir ningún "
                + "otro tipo de configuración adicional",
        decisions_record = {"Se selecciona Itext como librería para generar reportes",
                            "Se selecciona org.reflections para analizar los métodos anotados"},
        reasons = {"com.itextpdf permite facilidad en generación de reportes y no requiere ninguna configuración adicional",
                    "org.reflections permite realizar análisis de metadatos de manera muy dinámica"},
        links = {"https://mvnrepository.com/artifact/com.itextpdf/itextpdf"
                ,"https://mvnrepository.com/artifact/org.reflections/reflections/0.9.10"} 
)
package arat.business.implementations;

import arat.business.rationale.Rationale;


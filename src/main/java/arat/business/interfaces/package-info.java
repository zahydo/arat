/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@Rationale(id = "1.1",
        hiden = true,
        quality_attributes = Rationale.QualityAtribute.MAINTENANCE,
        causes = "Agregar funcionalidad sin modificar el código fuente ya escrito",
        tactics = "Definición de servicios comunes",
        patterns = "Estrategia",
        decisions_record = "Se separa la lógica de la implementación",
        reasons = "No modificar las clases existentes"
)
package arat.business.interfaces;

import arat.business.rationale.Rationale;


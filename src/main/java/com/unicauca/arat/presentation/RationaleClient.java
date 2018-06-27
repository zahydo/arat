/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.arat.presentation;

import com.unicauca.arat.business.tools.reporter.ReportStrategy;
import com.unicauca.arat.business.tools.reporter.Reporter;
import com.unicauca.arat.business.tools.reporter.reportStrategy.ItextReport;

/**
 *
 * @author sahydo
 */
public class RationaleClient extends Thread{
    
    
    public static void openGraphicWindow(){
        GraphicMain main = new GraphicMain();
        main.setVisible(true);
    }
    public static void generateReport(String packageName){
        ReportStrategy report = new ItextReport();
        Reporter reporter = new Reporter(report,packageName);
        if (reporter.createRationaleReportByAll("ArchitecturalRationaleReport")) {
            System.out.println("Reporte de Rationale creado satistactoriamente.");
        }else{
            System.out.println("No se puede crear el reporte, intenta cerrar el archivo si está abierto.");
        }
    }
    public static void generateReportsByOne(String packageName){
        ReportStrategy report = new ItextReport();
        Reporter reporter = new Reporter(report,packageName);
        if (reporter.createRationaleReports()) {
            System.out.println("Reporte de Rationale creado satistactoriamente.");
        }else{
            System.out.println("No se puede crear el reporte, intenta cerrar el archivo si está abierto.");
        }
    }

    
}

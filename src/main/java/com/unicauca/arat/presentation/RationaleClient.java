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
public class RationaleClient {

    private static final String SUCCESS_MESSAGE = "Reporte de Rationale creado satistactoriamente.";
    private static final String FAILURE_MESSAGE = "No se puede crear el reporte, intenta de nuevo cerrando el archivo.";
    private static final String WARNING_MESSAGE = "";

    private static final String DEFAULT_REPORT_NAME = "Architectural Rationale Report";

    public static void openGraphicWindow() {
        GraphicMain main = new GraphicMain();
        main.setVisible(true);
    }

    public static void generateReport(String packageName) {
        ReportStrategy reportStrategy = new ItextReport();
        Reporter reporter = new Reporter(reportStrategy, packageName);
        if (reporter.createRationaleReportByAll(DEFAULT_REPORT_NAME)) {
            System.out.println(SUCCESS_MESSAGE);
        } else {
            System.out.println(FAILURE_MESSAGE);
        }
    }

    public static void generateReportsByOne(String packageName) {
        ReportStrategy reportStrategy = new ItextReport();
        Reporter reporter = new Reporter(reportStrategy, packageName);
        if (reporter.createRationaleReports()) {
            System.out.println(SUCCESS_MESSAGE);
        } else {
            System.out.println(FAILURE_MESSAGE);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.arat.presentation;

import com.unicauca.arat.business.model.interfaces.ReportStrategy;
import com.unicauca.arat.business.model.reporter.ReportStrategyItext_Impl;
import com.unicauca.arat.business.model.reporter.Reporter;
import java.util.logging.Logger;

/**
 *
 * @author sahydo
 */
public class RationaleFacade {

    private static final String SUCCESS_MESSAGE = "Reporte de Rationale creado satistactoriamente.";
    private static final String FAILURE_MESSAGE = "No se puede crear el reporte, intenta de nuevo cerrando el archivo.";
    private static final String WARNING_MESSAGE = "";
    private static final String DEFAULT_REPORT_NAME = "Architectural Rationale Report";
    private static final Logger LOG = Logger.getLogger(Class.class.getName());

    public static void openGraphicWindow() {
        GraphicMain main = new GraphicMain();
        main.setVisible(true);
    }

    public static void generateReport(String packageName) {
        ReportStrategy reportStrategy = new ReportStrategyItext_Impl();
        Reporter reporter = new Reporter(reportStrategy, packageName);
        if (reporter.createRationaleReportByAll(DEFAULT_REPORT_NAME)) {
            LOG.info(SUCCESS_MESSAGE);
        } else {
            LOG.severe(FAILURE_MESSAGE);
        }
    }

    public static void generateReportsByOne(String packageName) {
        ReportStrategy reportStrategy = new ReportStrategyItext_Impl();
        Reporter reporter = new Reporter(reportStrategy, packageName);
        if (reporter.createRationaleReports()) {
            LOG.info(SUCCESS_MESSAGE);
        } else {
            LOG.severe(FAILURE_MESSAGE);
        }
    }

}

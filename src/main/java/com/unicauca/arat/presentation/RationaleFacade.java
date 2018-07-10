/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.arat.presentation;

import com.unicauca.arat.business.model.interfaces.ReportStrategy;
import com.unicauca.arat.business.model.reporter.ReportStrategyItext_Impl;
import com.unicauca.arat.business.model.reporter.Reporter;
import com.unicauca.arat.business.model.util.JavaUtil;

/**
 *
 * @author sahydo
 */
public class RationaleFacade {

    private static ReportStrategy reportStrategy = new ReportStrategyItext_Impl();
    private static Reporter reporter = null;

    public static enum Strategy {
        ITEXT, IREPORT
    };

    public static void openGraphicWindow() {
        GraphicMain main = new GraphicMain();
        main.setVisible(true);
    }

    /**
     *
     * @param strategy Estrategia con la que se realiza el reporte
     */
    public static void setReportStrategy(Strategy strategy) {
        switch (strategy) {
            case ITEXT:
                reportStrategy = new ReportStrategyItext_Impl();
                break;
            case IREPORT:
                //reportStrategy = new ReportStrategyIReport_Impl();
                break;
            default:
                reportStrategy = new ReportStrategyItext_Impl();
                break;
        }
    }

    /**
     *
     * @param packageName Package where is generated the file with annotations
     * @return ResponseCode is the response code in the report generation
     */
    public static JavaUtil.ResponseCode generateReportByAll(String packageName) {
        reporter = new Reporter(reportStrategy, packageName);
        JavaUtil.ResponseCode response = reporter.createRationaleReportByAll(JavaUtil.DEFAULT_REPORT_NAME);
        switch (response) {
            case SUCCESS:
                JavaUtil.showLogSuccessMessage();
                break;
            case WARNING:
                JavaUtil.showLogWarningMessage();
                break;
            case FAILURE:
                JavaUtil.showLogFailureMessage();
                break;
        }
        return response;
    }

    /**
     *
     * @param packageName Package where is generated the file with annotations
     * @return ResponseCode is the response code in the report generation
     */
    public static JavaUtil.ResponseCode generateReportsByOne(String packageName) {
        reporter = new Reporter(reportStrategy, packageName);
        JavaUtil.ResponseCode response = reporter.createRationaleReports();
        switch (response) {
            case SUCCESS:
                JavaUtil.showLogSuccessMessage();
                break;
            case WARNING:
                JavaUtil.showLogWarningMessage();
                break;
            case FAILURE:
                JavaUtil.showLogFailureMessage();
                break;
        }
        return response;
    }

}

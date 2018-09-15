/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arat.presentation;

import arat.business.model.reporter.Reporter;
import arat.utilities.DefaultValues;
import arat.utilities.JavaUtil;

/**
 *
 * @author sahydo
 */
public class RationaleFacade {

    private static Reporter reporter = null;

    public static void openGraphicWindow() {
        GraphicMain main = new GraphicMain();
        main.setVisible(true);
    }

    /**
     *
     * @param packageName Package where is generated the file with annotations
     * @return ResponseCode is the response code in the report generation
     */
    public static JavaUtil.ResponseCode generateReportByAll(String packageName) {
        reporter = new Reporter(packageName);
        JavaUtil.ResponseCode response = reporter.createRationaleReportByAll(DefaultValues.CURRENT_DATE+DefaultValues.DEFAULT_REPORT_NAME);
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
        reporter = new Reporter(packageName);
        JavaUtil.ResponseCode response = reporter.createRationaleReportByOne();
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

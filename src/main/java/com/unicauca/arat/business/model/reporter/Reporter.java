package com.unicauca.arat.business.model.reporter;

import com.unicauca.arat.business.model.interfaces.Reflection;
import com.unicauca.arat.business.model.interfaces.Report;
import com.unicauca.arat.business.model.rationale.Information;
import com.unicauca.arat.business.model.rationale.Rationale;
import java.util.HashMap;
import com.unicauca.arat.utilities.DefaultValues;
import com.unicauca.arat.utilities.JavaUtil;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sahydo
 */
public class Reporter {

    private Report reportStrategy;
    private Reflection reflection;
    private HashMap<Information, Rationale> rationaleInformation;

    public Reporter(String packageName) {
        try {
            reportStrategy = (Report)Class.forName(DefaultValues.DEFAULT_REPORT).newInstance();
            reflection = (Reflection)Class.forName(DefaultValues.DEFAULT_REFLECTION).newInstance();
            reflection.configureReflection(packageName);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Reporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        rationaleInformation = reflection.getRationaleInformation();
    }


    public JavaUtil.ResponseCode createRationaleReportByAll(String nameFile) {
        JavaUtil.ResponseCode response;
        response = reportStrategy.generateReportByAll(rationaleInformation, JavaUtil.setNameFile(nameFile));
        return response;
    }

    public JavaUtil.ResponseCode createRationaleReportByOne() {
        JavaUtil.ResponseCode response;
        response = reportStrategy.generateReportByOne(rationaleInformation);
        return response;
    }

    public Report getReportStrategy() {
        return reportStrategy;
    }

    public void setReportStrategy(Report reportStrategy) {
        this.reportStrategy = reportStrategy;
    }

    public Reflection getReflection() {
        return reflection;
    }

    public void setReflection(Reflection reflection) {
        this.reflection = reflection;
    }

    public HashMap<Information, Rationale> getRationaleInformation() {
        return rationaleInformation;
    }

    public void setRationaleInformation(HashMap<Information, Rationale> rationaleInformation) {
        this.rationaleInformation = rationaleInformation;
    }

}

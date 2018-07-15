package com.unicauca.arat.business.model.reporter;

import com.unicauca.arat.business.model.implementations.Report_Impl_Itext;
import com.unicauca.arat.business.model.implementations.Reflection_Impl_JAR;
import com.unicauca.arat.business.model.interfaces.Reflection;
import com.unicauca.arat.business.util.JavaUtil;
import com.unicauca.arat.business.model.rationale.Information;
import com.unicauca.arat.business.model.rationale.Rationale;
import java.util.HashMap;
import com.unicauca.arat.business.model.interfaces.Report;
import com.unicauca.arat.business.util.DefaultValues;

/**
 *
 * @author sahydo
 */
public class Reporter {

    private Report reportStrategy;
    private Reflection reflection;
    private HashMap<Information, Rationale> rationaleInformation;

    public Reporter(String packageName) {
        switch (DefaultValues.DEFAULT_REPORT) {
            case "Report_Impl_Itext":
                reportStrategy = new Report_Impl_Itext();
                break;
            default:
                reportStrategy = new Report_Impl_Itext();
                break;
        }
        switch (DefaultValues.DEFAULT_REFLECTION) {
            case "Reflection_Impl_JAR":
                reflection = new Reflection_Impl_JAR(packageName);
                break;
            default:
                reflection = new Reflection_Impl_JAR(packageName);
                break;
        }
        this.rationaleInformation = this.reflection.getRationaleInformation();
    }


    public JavaUtil.ResponseCode createRationaleReportByAll(String nameFile) {
        JavaUtil.ResponseCode response;
        response = reportStrategy.generateReportByAll(rationaleInformation, JavaUtil.setNameFile(nameFile));
        return response;
    }

    public JavaUtil.ResponseCode createRationaleReports() {
        JavaUtil.ResponseCode response;
        response = reportStrategy.generateReport(rationaleInformation);
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

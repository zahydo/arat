package com.unicauca.arat.business.model.reporter;

import com.unicauca.arat.business.model.interfaces.Reflection;
import com.unicauca.arat.business.model.util.JavaUtil;
import com.unicauca.arat.business.model.interfaces.ReportStrategy;
import com.unicauca.arat.business.model.rationale.Information;
import com.unicauca.arat.business.model.rationale.Rationale;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author sahydo
 */
public class Reporter {

    private ReportStrategy reportStrategy;
    private final Reflection reflection;

    public Reporter(ReportStrategy reportStrategy, String packageName) {
        this.reportStrategy = reportStrategy;
        this.reflection = new ReflectionJAR_Impl(packageName);
    }

    public HashMap<Information, Rationale> getRationaleInformation() {
        Set<Class<?>> annotatedClasses = reflection.getClasesAnnotatedWhitRationale();
        Set<Method> annotatedMethods = reflection.getMethodsAnnotatedWithRationale();
        HashMap<Information, Rationale> data = new HashMap<>();
        annotatedMethods.forEach((annotatedMethod) -> {
            String aux[] = annotatedMethod.toString().split(" ");
            String path = aux[aux.length - 1];
            String name = annotatedMethod.getName();
            String type = annotatedMethod.getClass().getSimpleName();
            Information info = new Information(path, name, type);
            for (Rationale rationale : annotatedMethod.getAnnotationsByType(Rationale.class)) {
                data.put(info, rationale);
            }
        });
        annotatedClasses.forEach((annotatedClass) -> {
            String path = annotatedClass.getCanonicalName();
            String name = annotatedClass.getSimpleName();
            String type = annotatedClass.getClass().getSimpleName();
            Information info;
            if (name.equals("package-info")) {
                info = new Information(path, name, "Package");
            } else {
                info = new Information(path, name, type);
            }
            for (Rationale rationale : annotatedClass.getAnnotationsByType(Rationale.class)) {
                data.put(info, rationale);
            }
        });
        return data;
    }

    public JavaUtil.ResponseCode createRationaleReportByAll(String nameFile) {
        JavaUtil.ResponseCode response;
        HashMap<Information, Rationale> rationaleInformation = getRationaleInformation();
        response = reportStrategy.generateReportByAll(rationaleInformation, JavaUtil.setNameFile(nameFile));
        return response;
    }

    public JavaUtil.ResponseCode createRationaleReports() {
        JavaUtil.ResponseCode response;
        HashMap<Information, Rationale> rationaleInformation = getRationaleInformation();
        response = reportStrategy.generateReport(rationaleInformation);
        return response;
    }

    public void setStrategy(ReportStrategy strategy) {
        this.reportStrategy = strategy;
    }

}

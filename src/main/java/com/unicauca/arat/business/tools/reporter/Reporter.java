package com.unicauca.arat.business.tools.reporter;

import com.unicauca.arat.business.model.Information;
import com.unicauca.arat.business.model.Rationale;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author sahydo
 */
public class Reporter {

    private ReportStrategy reportStrategy;
    private final AnnotationsReflection reflection;

    public Reporter(ReportStrategy reportStrategy, String packageName) {
        this.reportStrategy = reportStrategy;
        this.reflection = new AnnotationsReflection(packageName);
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

    public boolean createRationaleReportByAll(String nameFile) {
        boolean flag = false;
        HashMap<Information, Rationale> rationaleInformation = getRationaleInformation();
        flag = reportStrategy.generateReportByAll(rationaleInformation, JavaUtil.setNameFile(nameFile));
        return flag;
    }

    public boolean createRationaleReports() {
        boolean flag = false;
        HashMap<Information, Rationale> rationaleInformation = getRationaleInformation();
        if (rationaleInformation != null) {
            flag = reportStrategy.generateReport(rationaleInformation);
        }
        return flag;
    }

    public void setStrategy(ReportStrategy strategy) {
        this.reportStrategy = strategy;
    }

}

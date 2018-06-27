package com.unicauca.arat.business.tools.reporter;

import com.unicauca.arat.business.model.Information;
import com.unicauca.arat.business.model.Rationale;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

public class Reporter {
    private ReportStrategy reportStrategy;
    private AnnotationsReflection reflection;
    
    public Reporter(ReportStrategy reportStrategy, String packageName) {
        this.reportStrategy = reportStrategy;
        this.reflection = new AnnotationsReflection(packageName);
    }
        
    public HashMap<Information,Rationale> getRationaleInformation(){
        Set<Class<?>> annotatedClasses = reflection.getClasesAnnotatedWhitRationale();
        Set<Method> annotatedMethods = reflection.getMethodsAnnotatedWithRationale();
        HashMap<Information,Rationale> data = new HashMap<>();
        annotatedMethods.forEach((annotatedMethod) -> {
            String aux[] = annotatedMethod.toString().split(" "); 
            String path = aux[aux.length-1];
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
            }else{
                info = new Information(path, name, type);           
            }
            for (Rationale rationale : annotatedClass.getAnnotationsByType(Rationale.class)) {
                data.put(info, rationale);
            }
        });
        return data;
    }
    
    public boolean createRationaleReportByAll(String nameFile) {
        return reportStrategy.generateReportByAll(getRationaleInformation(),JavaUtil.setNameFile(nameFile));
    }
    public boolean createRationaleReports(){
        boolean flag = false;
        
        getRationaleInformation().keySet().forEach((information) -> {
            //Información del Rationale
            Rationale rationale = getRationaleInformation().get(information);
            reportStrategy.generateReport(information, rationale);
        });
        return flag;
    }
    
    public void setStrategy(ReportStrategy strategy) {
        this.reportStrategy = strategy;
    }
    
    
    
    
}

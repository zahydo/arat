package com.unicauca.arat.business.tools.reporter;

import com.unicauca.arat.business.model.Information;
import com.unicauca.arat.business.model.Rationale;
import java.util.HashMap;

public interface ReportStrategy {

    public abstract boolean generateReportByAll(HashMap<Information, Rationale> rationaleInformation, String dest);

    public abstract boolean generateReport(HashMap<Information, Rationale> rationaleInformation);
}

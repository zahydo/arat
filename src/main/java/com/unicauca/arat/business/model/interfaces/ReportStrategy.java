package com.unicauca.arat.business.model.interfaces;

import com.unicauca.arat.business.model.rationale.Information;
import com.unicauca.arat.business.model.rationale.Rationale;
import java.util.HashMap;

/**
 *
 * @author sahydo
 */
public interface ReportStrategy {

    public abstract boolean generateReportByAll(HashMap<Information, Rationale> rationaleInformation, String dest);

    public abstract boolean generateReport(HashMap<Information, Rationale> rationaleInformation);
}

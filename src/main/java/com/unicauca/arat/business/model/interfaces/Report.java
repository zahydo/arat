package com.unicauca.arat.business.model.interfaces;

import com.unicauca.arat.business.model.rationale.Information;
import com.unicauca.arat.business.model.rationale.Rationale;
import com.unicauca.arat.business.util.JavaUtil;
import java.util.HashMap;

/**
 *
 * @author sahydo
 */
public interface Report {

    public abstract JavaUtil.ResponseCode generateReportByAll(HashMap<Information, Rationale> rationaleInformation, String dest);

    public abstract JavaUtil.ResponseCode generateReport(HashMap<Information, Rationale> rationaleInformation);
}

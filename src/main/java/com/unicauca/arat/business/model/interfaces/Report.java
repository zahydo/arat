package com.unicauca.arat.business.model.interfaces;

import com.unicauca.arat.business.model.rationale.Information;
import com.unicauca.arat.business.model.rationale.Rationale;
import com.unicauca.arat.utilities.JavaUtil;
import java.util.HashMap;

/**
 *
 * @author sahydo
 */
public interface Report {

    public abstract JavaUtil.ResponseCode generateReportByAll(HashMap<Information, Rationale> rationaleInformation, String dest);

    public abstract JavaUtil.ResponseCode generateReportByOne(HashMap<Information, Rationale> rationaleInformation);
}

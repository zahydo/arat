package arat.business.interfaces;

import arat.business.rationale.Information;
import arat.business.rationale.Rationale;
import arat.utilities.JavaUtil;
import java.util.HashMap;

/**
 *
 * @author sahydo
 */
public interface Report {

    public abstract JavaUtil.ResponseCode generateReportByAll(HashMap<Information, Rationale> rationaleInformation, String dest);

    public abstract JavaUtil.ResponseCode generateReportByOne(HashMap<Information, Rationale> rationaleInformation);
}

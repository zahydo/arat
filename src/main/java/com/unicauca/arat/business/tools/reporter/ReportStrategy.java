package com.unicauca.arat.business.tools.reporter;

import com.itextpdf.text.Document;
import com.unicauca.arat.business.model.Information;
import com.unicauca.arat.business.model.Rationale;
import java.util.HashMap;

public interface ReportStrategy {
    //
    public abstract void createTemplate(HashMap<Information,Rationale> rationaleInformation, Document document);
    public abstract void createRationaleInfo(Document document, Rationale rationale);
    public abstract boolean generateReport(HashMap<Information,Rationale> rationaleInformation,String dest);
}

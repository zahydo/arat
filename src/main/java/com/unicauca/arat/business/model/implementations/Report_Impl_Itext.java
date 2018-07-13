/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.arat.business.model.implementations;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.unicauca.arat.business.model.rationale.Information;
import com.unicauca.arat.business.model.rationale.Rationale;
import com.unicauca.arat.business.util.JavaUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.util.Map;
import com.unicauca.arat.business.model.interfaces.Report;

/**
 *
 * @author sahydo
 */
public class Report_Impl_Itext implements Report {

    public void createInformation(HashMap<Information, Rationale> rationaleHash, Document document) {
        int cont = 1;
        for (Information information : rationaleHash.keySet()) {
            try {
                //Información del Rationale
                Rationale rationale = rationaleHash.get(information);
                if (!rationale.hiden()) {
                    document.add(new Paragraph("Rationale: " + cont, new Font(Font.FontFamily.COURIER, 15)));
                    document.add(new Paragraph("id: " + rationale.id(), new Font(Font.FontFamily.HELVETICA, 12)));
                    document.add(new Paragraph("Type: " + information.getType(), new Font(Font.FontFamily.HELVETICA, 12)));
                    document.add(new Paragraph("Path: " + information.getPath(), new Font(Font.FontFamily.HELVETICA, 12)));
                    document.add(new Paragraph("Name: " + information.getName(), new Font(Font.FontFamily.HELVETICA, 12)));
                    createRationaleInfo(document, rationale);
                    cont++;
                }
            } catch (DocumentException ex) {
                Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void createRationaleInfo(Document document, Rationale rationale) {
        List quality_attributes = new List(List.UNORDERED);
        List causes = new List(List.UNORDERED);
        List tactics = new List(List.UNORDERED);
        List paterns = new List(List.UNORDERED);
        List alternatives = new List(List.UNORDERED);
        List decisions = new List(List.UNORDERED);
        List reasons = new List(List.UNORDERED);
        try {
            //Atributos de calidad
            document.add(new Paragraph("Quality attributes: ", new Font(Font.FontFamily.HELVETICA, 14)));
            for (Rationale.QualityAtribute attribute : rationale.quality_attributes()) {
                quality_attributes.add(attribute.toString());
            }
            document.add(quality_attributes);
            //Causas
            document.add(new Paragraph("Causes: ", new Font(Font.FontFamily.HELVETICA, 14)));
            for (String causa : rationale.causes()) {
                causes.add(causa);
            }
            document.add(causes);
            //Tácticas
            document.add(new Paragraph("Tactics: ", new Font(Font.FontFamily.HELVETICA, 14)));
            for (String tactica : rationale.tactics()) {
                tactics.add(tactica);
            }
            document.add(tactics);
            //Patrones
            document.add(new Paragraph("Patterns: ", new Font(Font.FontFamily.HELVETICA, 14)));
            for (String patron : rationale.patterns()) {
                paterns.add(patron);
            }
            document.add(paterns);
            //Alternativas
            document.add(new Paragraph("Alternatives: ", new Font(Font.FontFamily.HELVETICA, 14)));
            for (String alternativa : rationale.alternatives()) {
                alternatives.add(alternativa);
            }
            document.add(alternatives);
            //Decisiones
            document.add(new Paragraph("Decisions: ", new Font(Font.FontFamily.HELVETICA, 14)));
            for (String decision : rationale.decisions_record()) {
                decisions.add(decision);
            }
            document.add(decisions);
            //Razones
            document.add(new Paragraph("Reasons: ", new Font(Font.FontFamily.HELVETICA, 14)));
            for (String reason : rationale.reasons()) {
                reasons.add(reason);
            }
            document.add(reasons);
        } catch (DocumentException ex) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createHeader(Document document) {
        try {
            PdfPTable table = new PdfPTable(3);
            table.setWidths(new int[]{1, 1, 4});
            PdfPCell cell;
            cell = new PdfPCell(new Paragraph("Architectural Rationale Annotations Tool", new Font(Font.FontFamily.HELVETICA, 15)));
            cell.setColspan(3);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(Image.getInstance("resources/unicauca.png"), true);
            cell.setRowspan(10);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setPadding(2);
            table.addCell(cell);
            table.addCell("Organization:");
            table.addCell("Universidad del Cauca");
            table.addCell("Description:");
            table.addCell(".jar library to manage the Architectural Rationale through Java Source Code Annotations");
            table.addCell("Version:");
            table.addCell("1.0");
            table.addCell("Author:");
            table.addCell("Santiago Hyun Dorado");
            table.addCell("Release date:");
            table.addCell("July 2018");
            table.setWidthPercentage(100);
            document.add(table);
        } catch (BadElementException ex) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public JavaUtil.ResponseCode generateReportByAll(HashMap<Information, Rationale> rationaleInformation, String dest) {
        try {
            JavaUtil.LOG.info("Initializing generation of Rationale Report by all annotations");
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();
            createHeader(document);
            createInformation(rationaleInformation, document);
            document.close();
            JavaUtil.LOG.info("Closing generation of Rationale Report by all annotations");
            if (rationaleInformation.isEmpty()) {
                return JavaUtil.ResponseCode.WARNING;
            } else {
                return JavaUtil.ResponseCode.SUCCESS;
            }
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
            return JavaUtil.ResponseCode.FAILURE;
        }
    }

    @Override
    public JavaUtil.ResponseCode generateReport(HashMap<Information, Rationale> rationaleInformation) {
        try {
            JavaUtil.LOG.info("Initializing generation of Rationale Report by annotation");
            for (Map.Entry<Information, Rationale> entry : rationaleInformation.entrySet()) {
                Information information = entry.getKey();
                Rationale rationale = entry.getValue();
                JavaUtil.LOG.info("Add rationale information to report");
                addInformationAndRationaleToReport(information, rationale);
            }
            JavaUtil.LOG.info("Close generation of Rationale Report by annotation");
            if (rationaleInformation.isEmpty()) {
                return JavaUtil.ResponseCode.WARNING;
            } else {
                return JavaUtil.ResponseCode.SUCCESS;
            }
        } catch (Exception e) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, e);
            return JavaUtil.ResponseCode.FAILURE;
        }

    }

    private void addInformationAndRationaleToReport(Information information, Rationale rat) {
        Document currentDocument = new Document(PageSize.A4, 50, 50, 50, 50);
        Rationale rationale = rat;
        try {
            PdfWriter.getInstance(currentDocument, new FileOutputStream(JavaUtil.setNameFile(rationale.id() + "-" + information.getType() + "-" + information.getName())));
            currentDocument.open();
            createHeader(currentDocument);
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //Información del Rationale
            if (!rationale.hiden()) {
                currentDocument.add(new Paragraph("id: " + rationale.id(), new Font(Font.FontFamily.HELVETICA, 12)));
                currentDocument.add(new Paragraph("Type: " + information.getType(), new Font(Font.FontFamily.HELVETICA, 12)));
                currentDocument.add(new Paragraph("Path: " + information.getPath(), new Font(Font.FontFamily.HELVETICA, 12)));
                currentDocument.add(new Paragraph("Name: " + information.getName(), new Font(Font.FontFamily.HELVETICA, 12)));

                List quality_attributes = new List(List.UNORDERED);
                List causes = new List(List.UNORDERED);
                List tactics = new List(List.UNORDERED);
                List paterns = new List(List.UNORDERED);
                List alternatives = new List(List.UNORDERED);
                List decisions = new List(List.UNORDERED);
                List reasons = new List(List.UNORDERED);
                try {
                    //Atributos de calidad
                    currentDocument.add(new Paragraph("Quality Atributes: ", new Font(Font.FontFamily.HELVETICA, 14)));
                    for (Rationale.QualityAtribute attribute : rationale.quality_attributes()) {
                        quality_attributes.add(attribute.toString());
                    }
                    currentDocument.add(quality_attributes);
                    //Causas
                    currentDocument.add(new Paragraph("Causes: ", new Font(Font.FontFamily.HELVETICA, 14)));
                    for (String causa : rationale.causes()) {
                        causes.add(causa);
                    }
                    currentDocument.add(causes);
                    //Tácticas
                    currentDocument.add(new Paragraph("Tactics: ", new Font(Font.FontFamily.HELVETICA, 14)));
                    for (String tactica : rationale.tactics()) {
                        tactics.add(tactica);
                    }
                    currentDocument.add(tactics);
                    //Patrones
                    currentDocument.add(new Paragraph("Patterns: ", new Font(Font.FontFamily.HELVETICA, 14)));
                    for (String patron : rationale.patterns()) {
                        paterns.add(patron);
                    }
                    currentDocument.add(paterns);
                    //Alternativas
                    currentDocument.add(new Paragraph("Alternatives: ", new Font(Font.FontFamily.HELVETICA, 14)));
                    for (String alternativa : rationale.alternatives()) {
                        alternatives.add(alternativa);
                    }
                    currentDocument.add(alternatives);
                    //Decisiones
                    currentDocument.add(new Paragraph("Decisions: ", new Font(Font.FontFamily.HELVETICA, 14)));
                    for (String decision : rationale.decisions_record()) {
                        decisions.add(decision);
                    }
                    currentDocument.add(decisions);
                    //Razones
                    currentDocument.add(new Paragraph("Reasons: ", new Font(Font.FontFamily.HELVETICA, 14)));
                    for (String reason : rationale.reasons()) {
                        reasons.add(reason);
                    }
                    currentDocument.add(reasons);
                } catch (DocumentException ex) {
                    Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (DocumentException ex) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
        }
        currentDocument.close();

    }
}

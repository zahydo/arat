/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arat.business.implementations;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import arat.business.rationale.Information;
import arat.business.rationale.Rationale;
import arat.utilities.JavaUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.util.Map;
import arat.business.interfaces.Report;
import arat.utilities.DefaultValues;
import java.util.Date;

/**
 * @author sahydo
 */
public class Report_Impl_Itext implements Report {

    private final FontFamily DEFAULT_FONT_FAMILY = Font.FontFamily.COURIER;
    private final int DEFAULT_FONT_SIZE = 14;

    /**
     * @param vector is an array to Objects for convert to Strings
     * @return String[] converted vector from Object to String
     */
    private String[] toStringVector(Object[] vector) {
        String[] vectorString = new String[vector.length];
        for (int i = 0; i < vector.length; i++) {
            vectorString[i] = vector[i].toString();
        }
        return vectorString;
    }

    /**
     * @param label is the labe of the @Rationale attribute
     * @param values is the values vector from @Rationale annotation
     * @param table is the reference to the table of the report
     */
    private void addValueToTable(String label, String[] values, PdfPTable table) {
        addLabelToTable(label, table);
        for (String value : values) {
            table.addCell("-" + value);
        }
    }

    /**
     * @param label is the attribute label to show
     * @param table is the table for add a cell with attribute label
     */
    private void addLabelToTable(String label, PdfPTable table) {
        Paragraph paragraph = new Paragraph(label, new Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE));
        PdfPCell cell = new PdfPCell(paragraph);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }

    /**
     * @param document is the Itext Document to generate
     * @param information is the Information about a @Rationale
     * @param ratinale is the vale of the @Rationale annotation
     * @param cont is the number of @Rationale in the loop
     */
    private void addInformation(Document document, Information information, Rationale rationale, int cont) {
        try {
            document.add(new Paragraph("\n"));
            PdfPTable table = new PdfPTable(4);
            table.setWidths(new int[]{1, 1, 1, 1});
            table.addCell(new Paragraph(DefaultValues.LABEL_RATIONALE, new Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE)));
            table.addCell("" + cont);
            table.addCell(new Paragraph(DefaultValues.LABEL_IDENTIFIER, new Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE)));
            table.addCell(rationale.id());
            table.addCell(new Paragraph(DefaultValues.LABEL_TYPE, new Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE)));
            table.addCell(information.getType());
            table.addCell(new Paragraph(DefaultValues.LABEL_NAME, new Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE)));
            table.addCell(information.getName());
            PdfPCell cell;
            cell = new PdfPCell(new Paragraph(DefaultValues.LABEL_PATH, new Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE)));
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph(information.getPath()));
            cell.setColspan(3);
            table.addCell(cell);
            table.setWidthPercentage(100);
            document.add(table);
        } catch (DocumentException ex) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param document is the Itext Document to generate
     * @param rationale is the value of the @Rationale annotation
     */
    private void addRationale(Document document, Rationale rationale) {
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        if (rationale.quality_attributes().length > 0) {
            addValueToTable(DefaultValues.LABEL_QUALITY_ATTRIBUTES, toStringVector(rationale.quality_attributes()), table);
        }
        if (rationale.causes().length > 0) {
            addValueToTable(DefaultValues.LABEL_CAUSES, rationale.causes(), table);
        }
        if (rationale.tactics().length > 0) {
            addValueToTable(DefaultValues.LABEL_TACTICS, rationale.tactics(), table);
        }
        if (rationale.patterns().length > 0) {
            addValueToTable(DefaultValues.LABEL_PATTERNS, rationale.patterns(), table);
        }
        if (rationale.alternatives().length > 0) {
            addValueToTable(DefaultValues.LABEL_ALTERNATIVES, rationale.alternatives(), table);
        }
        if (rationale.decisions_record().length > 0) {
            addValueToTable(DefaultValues.LABEL_DECISIONS, rationale.decisions_record(), table);
        }
        if (rationale.reasons().length > 0) {
            addValueToTable(DefaultValues.LABEL_REASONS, rationale.reasons(), table);
        }
        if (rationale.links().length > 0) {
            addValueToTable(DefaultValues.LABEL_LINKS, rationale.links(), table);
        }
        try {
            document.add(table);
        } catch (DocumentException ex) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param document is the Itext Document to generate
     */
    private void addHeader(Document document) {
        try {
            PdfPTable table = new PdfPTable(3);
            table.setWidths(new int[]{1, 2, 3});
            PdfPCell cell;
            cell = new PdfPCell(new Paragraph(DefaultValues.TITLE, new Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE)));
            cell.setColspan(3);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(Image.getInstance(DefaultValues.RATIONALE_REPORT_IMAGE), true);
            cell.setRowspan(10);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setPadding(2);
            table.addCell(cell);
            table.addCell(new Paragraph(DefaultValues.LABEL_ORGANIZATION, new Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE)));
            table.addCell(DefaultValues.ORGANIZATION);
            table.addCell(new Paragraph(DefaultValues.LABEL_DESCRIPTION, new Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE)));
            table.addCell(DefaultValues.DESCRIPTION);
            table.addCell(new Paragraph(DefaultValues.LABEL_VERSION, new Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE)));
            table.addCell(DefaultValues.VERSION);
            table.addCell(new Paragraph(DefaultValues.LABEL_AUTHOR, new Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE)));
            table.addCell(DefaultValues.AUTHOR);
            table.addCell(new Paragraph(DefaultValues.LABEL_CURRENT_DATE, new Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE)));
            table.addCell(DefaultValues.CURRENT_DATE);
            table.setWidthPercentage(100);
            document.add(table);
        } catch (BadElementException ex) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param information is the Information about a @Rationale
     * @param rat is the vale of the @Rationale annotation
     * @param cont is the number of @Rationale in the loop
     */
    private void addInformationAndRationaleToReport(Information information, Rationale rat, int cont) {
        try {
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter.getInstance(document, new FileOutputStream(JavaUtil.setNameFile(DefaultValues.CURRENT_DATE+"/"+rat.id() + "-" + information.getType() + "-" + information.getName())));
            document.open();
            addHeader(document);
            addInformation(document, information, rat, cont);
            addRationale(document, rat);
            document.close();
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public JavaUtil.ResponseCode generateReportByAll(HashMap<Information, Rationale> rationaleInformation, String dest) {
        try {
            if (rationaleInformation.isEmpty()) {
                return JavaUtil.ResponseCode.WARNING;
            } else {
                JavaUtil.LOG.info("Initializing generation of Rationale Report by all annotations");
                int cont = 1;
                Document document = new Document(PageSize.A4, 50, 50, 50, 50);
                PdfWriter.getInstance(document, new FileOutputStream(dest));
                document.open();
                addHeader(document);
                for (Information information : rationaleInformation.keySet()) {
                    Rationale rationale = rationaleInformation.get(information);
                    if (!rationale.hiden()) {
                        addInformation(document, information, rationale, cont);
                        addRationale(document, rationale);
                        cont++;
                    }
                }
                document.close();
                JavaUtil.LOG.info("Closing generation of Rationale Report by all annotations");
                return JavaUtil.ResponseCode.SUCCESS;
            }
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, ex);
            return JavaUtil.ResponseCode.FAILURE;
        }
    }

    @Override
    public JavaUtil.ResponseCode generateReportByOne(HashMap<Information, Rationale> rationaleInformation) {
        try {
            if (rationaleInformation.isEmpty()) {
                return JavaUtil.ResponseCode.WARNING;
            } else {
                JavaUtil.LOG.info("Initializing generation of Rationale Report by annotation");
                int cont = 1;
                for (Map.Entry<Information, Rationale> entry : rationaleInformation.entrySet()) {
                    JavaUtil.LOG.info("Add rationale information to report");
                    Information information = entry.getKey();
                    Rationale rationale = entry.getValue();
                    if (!rationale.hiden()) {
                        addInformationAndRationaleToReport(information, rationale, cont);
                    }
                    cont++;
                }
                JavaUtil.LOG.info("Close generation of Rationale Report by annotation");
                return JavaUtil.ResponseCode.SUCCESS;
            }
        } catch (Exception e) {
            Logger.getLogger(Report_Impl_Itext.class.getName()).log(Level.SEVERE, null, e);
            return JavaUtil.ResponseCode.FAILURE;
        }
    }
}

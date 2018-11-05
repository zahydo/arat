/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arat.utilities;

import arat.business.implementations.Reflection_Impl_JAR;
import arat.business.implementations.Report_Impl_Itext;
import java.util.Date;

/**
 *
 * @author sahydo
 */
public class DefaultValues {
    public static final String DEFAULT_REPORT_NAME = "Architectural Rationale Report";
    public static String CURRENT_DATE = currentDate();
    public static final String RATIONALE_REPORT_IMAGE = "resources/unicauca.png";
    public static final String DEFAULT_REPORT = Report_Impl_Itext.class.getName();
    public static final String DEFAULT_REFLECTION = Reflection_Impl_JAR.class.getName();
    
    public static final String LABEL_ORGANIZATION = "ORGANIZATION:";
    public static final String LABEL_DESCRIPTION = "DESCRIPTION:";
    public static final String LABEL_VERSION = "VERSION:";
    public static final String LABEL_AUTHOR = "AUTHOR:";
    public static final String LABEL_CURRENT_DATE = "CURRENT DATE:";
    public static final String LABEL_RATIONALE = "RATIONALE:";
    public static final String LABEL_IDENTIFIER = "ID:";
    public static final String LABEL_TYPE = "TYPE:";
    public static final String LABEL_PATH = "PATH:";
    public static final String LABEL_NAME = "NAME:";
    public static final String LABEL_QUALITY_ATTRIBUTES = "QUALITY ATTRIBUTES:";
    public static final String LABEL_REASONS = "REASONS:";
    public static final String LABEL_ALTERNATIVES = "ALTERNATIVES:";
    public static final String LABEL_DECISIONS = "DECISIONS:";
    public static final String LABEL_CAUSES = "CAUSES:";
    public static final String LABEL_TACTICS = "TACTICS:";
    public static final String LABEL_PATTERNS = "PATTERNS:";
    public static final String LABEL_LINKS = "LINKS:";
    public static final String ORGANIZATION = "Universidad del Cauca";
    public static final String DESCRIPTION = ".jar library to manage the Architectural Rationale through Java Source Code Annotations";
    public static final String VERSION = "1.0";
    public static final String AUTHOR = "Santiago Hyun Dorado";
    public static final String TITLE = "ARCHITECTURAL RATIONALE ANNOTATIONS TOOL";
    
    private static String currentDate(){
        Date date = new Date();
        return date.toGMTString().replace(":", "-").replace("GTM", "-");
    }
}

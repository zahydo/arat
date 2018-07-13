/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.arat.business.util;

import com.unicauca.arat.business.model.implementations.Reflection_Impl_JAR;
import com.unicauca.arat.business.model.implementations.Report_Impl_Itext;

/**
 *
 * @author sahydo
 */
public class DefaultValues {
    public static final String DEFAULT_REPORT_NAME = "Architectural Rationale Report";
    public static final String DEFAULT_REPORT = Report_Impl_Itext.class.getSimpleName();
    public static final String DEFAULT_REFLECTION = Reflection_Impl_JAR.class.getSimpleName();
}

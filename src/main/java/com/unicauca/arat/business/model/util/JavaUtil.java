/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.arat.business.model.util;

import java.io.File;

/**
 *
 * @author sahydo
 */
public class JavaUtil {

    public static String setNameFile(String nameFile) {
        nameFile = "reports/" + nameFile + ".pdf";
        File file = new File(nameFile);
        file.getParentFile().mkdirs();
        return nameFile;
    }
}
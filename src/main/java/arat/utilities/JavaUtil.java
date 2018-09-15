/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arat.utilities;

import java.io.File;
import java.util.logging.Logger;

/**
 *
 * @author sahydo
 */
public class JavaUtil {

    private static final String SUCCESS_MESSAGE = "Rationale Report created successfully.";
    private static final String FAILURE_MESSAGE = "Can not create the Rationale Report, please close the file and try again.";
    private static final String WARNING_MESSAGE = "No annotations @Rationale were detected in the source code.";

    public static final Logger LOG = Logger.getLogger(Class.class.getName());

    public static enum ResponseCode {
        SUCCESS, WARNING, FAILURE
    };

    public static String setNameFile(String nameFile) {
        nameFile = "reports/" + nameFile + ".pdf";
        File file = new File(nameFile);
        file.getParentFile().mkdirs();
        return nameFile;
    }

    public static void showLogSuccessMessage() {
        LOG.info(SUCCESS_MESSAGE);
    }

    public static void showLogWarningMessage() {
        LOG.warning(WARNING_MESSAGE);
    }

    public static void showLogFailureMessage() {
        LOG.severe(FAILURE_MESSAGE);
    }

}

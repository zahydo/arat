/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.arat.test;

import com.unicauca.arat.presentation.RationaleClient;

/**
 *
 * @author sahydo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // RationaleClient.openGraphicWindow();
        RationaleClient.generateReport("com");
        RationaleClient.generateReportsByOne("com");
    }
    
}

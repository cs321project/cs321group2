/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs321group2;

import Models.Session;
import Utils.LogUtil;

/**
 *
 * @author Group 2
 */
public class Cs321group2 {
    
    private static Session session;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LogUtil.Verbose("Initializing Application");
        session = Session.getInstance();
    }
}

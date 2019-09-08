/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utils.LogUtil;

/**
 *
 * @author Group 2
 */
public class Session {

    private static Session instance = null;

    private Session() {

        LogUtil.Verbose("Creating New Session Instance");
    }

    public static Session getInstance() {

        LogUtil.Verbose("Getting Session Instance");

        if (instance == null) {
            instance = new Session();
        }

        return instance;
    }
}

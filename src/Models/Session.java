/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utils.Log;

/**
 *
 * @author Group 2
 */
public class Session {

    private static Session instance = null;
    public Settings appSettings = null;
    public Map currentMap = null;
    public Player currentPlayer = null;

    private Session() {
        Log.debug("Creating New Session Instance");
        appSettings = new Settings();
    }

    public static Session getInstance() {

        Log.verbose("Getting Session Instance");

        if (instance == null) {
            instance = new Session();
        }

        return instance;
    }

}

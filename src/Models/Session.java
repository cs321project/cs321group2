/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utils.Constants;
import Utils.Log;
import Utils.StringUtil;
import java.io.Serializable;

/**
 *
 * @author Group 2
 */
public class Session implements Serializable{

    private static Session instance = null;
    public Settings appSettings = null;
    public Map currentMap = null;
    public Player currentPlayer = null;
    public boolean isNewUser = true;

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

    public void initGame(String userName) {

        if (this.isNewUser) {
            currentPlayer = new Player(userName, null, Player.MAX_HEALTH, null,
                    Player.MAX_ATTACK, Player.MAX_DEFENSE, Player.MAX_LIVES);

            currentMap = new Map(Map.MIN_LEVEL);

        } else {
            //Deserialize from player and map
        }

        Log.information(StringUtil.concat("Game Initialized: ",
                "Username: ", currentPlayer.username, ",", Constants.SINGLE_SPACE, 
                "Map Level: ", Integer.toString(currentMap.getLevel())));
    }

}

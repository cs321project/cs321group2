/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utils.Constants;
import Utils.FileUtil;
import Utils.Log;
import Utils.StringUtil;
import Utils.SystemUtil;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Group 2
 */
public class Session implements Serializable {

    private static Session instance = null;
    public Map currentMap = null;
    public Player currentPlayer = null;
    public boolean isNewUser = true;

    private Session() {
        Log.debug("Creating New Session Instance");
        FileUtil.createDirectory(this.getGameDirectory());
    }

    public static Session getInstance() {

        Log.verbose("Getting Session Instance");

        if (instance == null) {
            instance = new Session();
        }

        return instance;
    }

    public String getGameDirectory() {
        String userDir = SystemUtil.getUserDirectory();
        String dir = StringUtil.concat(userDir, File.separator,
                "DungeonCrawlerData");

        return dir;
    }

    public boolean initGame(String userName) {

        List<Loot> beginnerInventory = new ArrayList();
        beginnerInventory.add(new Loot(null, 5, "Sword"));
        beginnerInventory.add(new Loot(null, 5, "Sheild"));

        currentPlayer = new Player(userName, beginnerInventory, Player.MAX_HEALTH, null,
                Player.MAX_ATTACK, Player.MAX_DEFENSE, Player.MAX_LIVES, Map.MIN_LEVEL);

        if (this.isNewUser) {
            currentMap = new Map(Map.MIN_LEVEL);

        } else {
            Session s = null;

            try {
                s = Settings.getSetting(this);
            } catch (IOException | ClassNotFoundException ex) {
                Log.exception(ex);
            }
            
            if(s != null) {
                this.currentMap = s.currentMap;
                this.currentPlayer = s.currentPlayer;
                this.isNewUser = false;
            }
        }

        Log.information(StringUtil.concat("Game Initialized: ",
                "Username: ", currentPlayer.getUsername(), ",", Constants.SINGLE_SPACE,
                "Map Level: ", Integer.toString(currentMap.getLevel())));

        return true;
    }

}

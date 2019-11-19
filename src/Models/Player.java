/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;
import Utils.FileUtil;
import Utils.Log;
import Utils.StringUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Group 2
 */
public class Player extends AbstractMapItem {

    public static final int MAX_HEALTH = 100;
    public static final int MAX_ATTACK = 10;
    public static final int MAX_DEFENSE = 10;
    public static final int MAX_LIVES = 5;

    private String username;
    private List<Loot> inventory;
    private int health;
    private int baseAttack;
    private int baseDefense;
    private int lives;
    private int highestLevel;

    public Player() {

    }

    public Player(String username, List<Loot> inventory, int health, Location location, int baseAttack, int baseDefense, int lives, int highestLevel) {
        this.username = username;
        this.inventory = inventory;
        this.health = health;
        this.location = location;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.lives = lives;
        this.highestLevel = highestLevel;

        FileUtil.createDirectory(this.getPlayerSettingsDir());

        try {
            FileUtil.createIfNotPresent(this.getPlayerSettingsFile());
        } catch(IOException ex)  {
            Log.exception(ex);
        }
    }

    public String getPlayerSettingsDir() {
        String gameDir = Session.getInstance().getGameDirectory();
        String file = StringUtil.concat(gameDir, File.separator,
                this.username);

        return file;
    }

    public String getPlayerSettingsFile() {
        String playerDir = this.getPlayerSettingsDir();
        String file = StringUtil.concat(playerDir, File.separator,
                "LastGame.txt");

        Log.verbose(StringUtil.concat("Getting player settings: ", file));

        return file;
    }

    public String getUsername() {
        return this.username;
    }

    public void setInventory(List<Loot> inventory) {
        this.inventory = inventory;
    }

    public List<Loot> getInventory() {
        return this.inventory;
    }

    public List<String> getInventoryIDs() {
        List<String> inv = new ArrayList<>();

        this.inventory.stream().filter((arg) -> (arg != null)).forEachOrdered((arg) -> {
            inv.add(arg.getID());
        });

        return inv;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getAttack() {
        return this.baseAttack;
    }

    public void setDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public int getDefense() {
        return this.baseDefense;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return this.lives;
    }

    public void equip(Loot item) {

    }

    public void unEquip(Loot item) {

    }

    public void attack() {

    }

    public void move() {

    }

    public void pickupLoot() {

    }

    public void heal() {

    }

    public void revive() {

    }

    private void die() {

    }

    public int getHighestLevel() {
        return this.highestLevel;
    }
}

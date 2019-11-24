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
 * Player represents player data and the player on the map
 *
 * @author Group 2
 */
public final class Player extends AbstractMapItem {

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
    private boolean hasKey = false;
    private Session session = Session.getInstance();

    /**
     * Constructor
     */
    public Player() {
        super.setID("Player");
    }

    /**
     * Constructor
     *
     * @param username
     * @param inventory
     * @param health
     * @param location
     * @param baseAttack
     * @param baseDefense
     * @param lives
     * @param highestLevel
     */
    public Player(String username, List<Loot> inventory, int health, Location location, int baseAttack, int baseDefense, int lives, int highestLevel) {

        super.setID("Player");
        super.setLocation(location);
        this.username = username;
        this.inventory = inventory;
        this.health = health;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.lives = lives;
        this.highestLevel = highestLevel;

        FileUtil.createDirectory(this.getPlayerSettingsDir());

        try {
            FileUtil.createIfNotPresent(this.getPlayerSettingsFile());
        } catch (IOException ex) {
            Log.exception(ex);
        }
    }

    /**
     * Player directory where player info and settings are serialized
     *
     * @return
     */
    public String getPlayerSettingsDir() {
        String gameDir = this.session.getGameDirectory();
        String file = StringUtil.concat(gameDir, File.separator,
                this.username);

        return file;
    }

    /**
     * File where players sessions are serialized
     *
     * @return
     */
    public String getPlayerSettingsFile() {
        String playerDir = this.getPlayerSettingsDir();
        String file = StringUtil.concat(playerDir, File.separator,
                "LastGame.txt");

        Log.verbose(StringUtil.concat("Getting player settings: ", file));

        return file;
    }

    /**
     * Player username used to log in
     *
     * @return
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * List of loot the player currently has in inventory
     *
     * @param inventory
     */
    public void setInventory(List<Loot> inventory) {
        this.inventory = inventory;
    }

    /**
     * Gets list of loot the user currently has in inventory
     *
     * @return
     */
    public List<Loot> getInventory() {
        return this.inventory;
    }

    /**
     * Gets the display names of the inventory items
     *
     * @return
     */
    public List<String> getInventoryDisplayNames() {
        List<String> inv = new ArrayList<>();

        this.inventory.stream().filter((arg) -> (arg != null)).forEachOrdered((arg) -> {
            inv.add(arg.getDisplayName());
        });

        return inv;
    }

    /**
     * Get the health value of the player
     *
     * @return
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Gets the attack level of the player
     *
     * @return
     */
    public int getAttack() {
        return this.baseAttack;
    }

    /**
     * Gets the defense level of the user
     *
     * @return
     */
    public int getDefense() {
        return this.baseDefense;
    }

    /**
     * Gets the number of lives that the player has left
     *
     * @return
     */
    public int getLives() {
        return this.lives;
    }

    /**
     * Add loot the user inventory
     *
     * @param item
     */
    public void equip(Loot item) {
        this.inventory.add(item);
    }

    /**
     * Removes item from the players inventory
     *
     * @param item
     */
    public void unEquip(Loot item) {
        this.inventory.remove(item);
    }

    /**
     * Attack enemies on the map
     */
    public void attack() {

    }

    /**
     * Moves the player around the map
     *
     * @param direction
     * @return
     */
    public boolean move(PlayerDirection direction) {

        AbstractMapItem[][] map
                = this.session.currentMap.getMapGrid();

        switch (direction) {
            case Left: {
                AbstractMapItem item
                        = map[this.getLocation().getyCoord() - 1][this.getLocation().getxCoord()];

                if (!this.canMove(item)) {
                    return false;
                } else {
                    map[this.getLocation().getyCoord()][this.getLocation().getxCoord()] = new Floor();
                    this.getLocation().setyCoord(this.getLocation().getyCoord() - 1);
                }

                break;
            }
            case Right: {
                AbstractMapItem item
                        = map[this.getLocation().getyCoord() + 1][this.getLocation().getxCoord()];

                if (!this.canMove(item)) {
                    return false;
                } else {
                    map[this.getLocation().getyCoord()][this.getLocation().getxCoord()] = new Floor();
                    this.getLocation().setyCoord(this.getLocation().getyCoord() + 1);
                }

                break;
            }
            case Backward: {
                AbstractMapItem item
                        = map[this.getLocation().getyCoord()][this.getLocation().getxCoord() + 1];

                if (!this.canMove(item)) {
                    return false;
                } else {
                    map[this.getLocation().getyCoord()][this.getLocation().getxCoord()] = new Floor();
                    this.getLocation().setxCoord(this.getLocation().getxCoord() + 1);
                }

                break;
            }
            case Forward: {
                AbstractMapItem item
                        = map[this.getLocation().getyCoord()][this.getLocation().getxCoord() - 1];

                if (!this.canMove(item)) {
                    return false;
                } else {
                    map[this.getLocation().getyCoord()][this.getLocation().getxCoord()] = new Floor();
                    this.getLocation().setxCoord(this.getLocation().getxCoord() - 1);
                }

                break;
            }
            default:
                break;
        }

        map[this.getLocation().getyCoord()][this.getLocation().getxCoord()] = this;
        Session.getInstance().currentMap.setMapGrid(map);

        return true;
    }

    private boolean canMove(AbstractMapItem item) {

        switch (item.getID()) {
            case "Wall": {
                return false;
            }
            case "Loot": {
                Loot loot = (Loot) item;
                this.equip(loot);
                return true;
            }
            case "Enemy": {
                return false;
            }
            case "Trap": {
                Trap trap = (Trap) item;
                return false;
            }
            case "Door": {
                if (this.hasKey) {
                    Door mapDoor = this.session.currentMap.getMapDoor();

                    if (mapDoor != null) {
                        mapDoor.unLock();
                    }

                    return true;
                } else {
                    return false;
                }
            }
            default: //Just open floor here
                return true;
        }
    }

    /**
     * Improves the players health
     */
    public void heal() {

    }

    /**
     * Spawns the user
     */
    public void revive() {

    }

    /**
     * Spawns the user
     *
     * @param damageValue
     */
    public void takeDamage(int damageValue) {

    }

    /**
     * Starts the game over when the player is out of health and lives
     */
    private void die() {

    }

    /**
     * Gets the highest map level that the player has achieved
     *
     * @return
     */
    public int getHighestLevel() {
        return this.highestLevel;

    }

    @Override
    public String toString() {
        return "Player";
    }

    /**
     * Directions that the player can move on the map grid
     */
    public enum PlayerDirection {
        Left,
        Right,
        Forward,
        Backward
    }
}

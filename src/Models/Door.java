/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;

/**
 * Door is the item that is used to unlock the next level from the map
 *
 * @author Group 2
 */
public class Door extends AbstractMapItem {

    private int level;
    private final Session session = Session.getInstance();

    /**
     * Constructor
     */
    public Door() {
        super.setID("Door");
    }

    /**
     * Constructor
     *
     * @param location Item placement on the map grid
     * @param level Map that the user is currently on
     */
    public Door(Location location, int level) {
        super.setID("Door");
        super.setLocation(location);
        this.level = level;
    }

    @Override
    public String toString() {
        return "Door";
    }

    /**
     * Sets the level of the map
     *
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get the level of the map
     *
     * @return
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Unlock the next map/level
     *
     */
    public void unLock() {

        // Reset session variable for next level
    }

}

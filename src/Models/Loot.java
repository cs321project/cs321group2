/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;

/**
 * Loot represents items on the map that the user can use to improve health,
 * inventory, etc.
 *
 * @author Group 2
 */
public class Loot extends AbstractMapItem {

    public static final int MAX_VALUE = 5;

    private int value;
    private String displayName;
    private final Session session = Session.getInstance();

    /**
     * Constructor
     */
    public Loot() {
        super.setID("Loot");
    }

    /**
     * Constructor
     *
     * @param location Placement of the item on the map grid
     * @param value Value of the loot to the user
     * @param displayName displayName of the Loot
     */
    public Loot(Location location, int value, String displayName) {
        super.setID("Loot");
        super.setLocation(location);
        this.value = value;
        this.displayName = displayName;
    }

    /**
     * Get the value of the loot to the user
     *
     * @return
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Get the display name of the loot
     *
     * @return
     */
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public String toString() {
        return "Loot";
    }
}

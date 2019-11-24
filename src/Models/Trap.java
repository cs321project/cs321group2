/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;

/**
 * Trap represents traps on the map grid that do damage to the player
 *
 * @author Group 2
 */
public class Trap extends AbstractMapItem {

    public static final int MAX_VALUE = 5;

    private final int damageValue;
    private final Session session = Session.getInstance();

    /**
     * Constructor
     */
    public Trap() {
        super.setID("Trap");
        this.damageValue = MAX_VALUE;
    }

    /**
     * Constructor
     *
     * @param location
     * @param damageValue
     */
    public Trap(Location location, int damageValue) {
        super.setLocation(location);
        super.setID("Trap");
        this.damageValue = damageValue;
    }

    /**
     * Gets damage value of trap
     *
     * @return
     */
    public int getValue() {
        return this.damageValue;
    }

    /**
     * Engages trap and does damage to the player
     *
     * @return
     */
    private void engage() {

    }

    @Override
    public String toString() {
        return "Trap";
    }

}

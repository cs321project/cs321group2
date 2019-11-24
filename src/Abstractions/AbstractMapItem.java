/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstractions;

import Models.Location;
import java.io.Serializable;

/**
 * AbstractMapItem is used as the super class for every object placed on the map
 *
 * @author Group 2
 */
public class AbstractMapItem implements Serializable {

    /**
     * Location of each item on the map
     */
    private Location location;

    /**
     * String ID of each map on the item
     */
    private String ID;

    /**
     * Set a string ID the describe the map item
     *
     * @param id
     */
    public void setID(String id) {
        this.ID = id;
    }

    /**
     * Get a string ID to describe the map item
     *
     * @return
     */
    public String getID() {
        return this.ID;
    }

    /**
     * Set location of the item on the map
     *
     * @param location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Get location of item on the map
     *
     * @return
     */
    public Location getLocation() {
        return location;
    }
}

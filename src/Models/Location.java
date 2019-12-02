/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 * Location of items on the map
 *
 * @author Matthew
 */
public class Location implements Serializable {

    private int xCoord;
    private int yCoord;

    /**
     * Constructor
     */
    public Location() {

    }

    /**
     * Constructor
     *
     * @param x int value for location on vertical axis (0 is top row, then
     * numbers increase as location descends)
     * @param y int value for location on horizontal axis
     */
    public Location(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    /**
     * Get x coordinate
     *
     * @return
     */
    public int getxCoord() {
        return xCoord;
    }

    /**
     * Set x coordinate
     *
     * @param xCoord
     */
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    /**
     * get y coordinate
     *
     * @return
     */
    public int getyCoord() {
        return yCoord;
    }

    /**
     * Set y coordinate
     *
     * @param yCoord
     */
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    /**
     * Determine if two locations are equal
     *
     * @param loc
     * @return
     */
    public boolean equals(Location loc) {
        return this.getxCoord() == loc.getxCoord()
                && this.getyCoord() == loc.getyCoord();
    }
}

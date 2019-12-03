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
     * @param x
     * @param y
     */
    public Location(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    /**
     * Get x coordinate
     *
     * @return X
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
     * @return Y
     */
    public int getyCoord() {
        return yCoord;
    }

    /**
     * set y coordinate
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
     * @return boolean
     */
    public boolean equals(Location loc) {
        return this.getxCoord() == loc.getxCoord()
                && this.getyCoord() == loc.getyCoord();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author Matthew
 */
public class Location implements Serializable {

    private int xCoord;
    private int yCoord;

    /**
     *
     */
    public Location() {

    }

    /**
     *
     * @param x
     * @param y
     */
    public Location(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    /**
     *
     * @return
     */
    public int getxCoord() {
        return xCoord;
    }

    /**
     *
     * @param xCoord
     */
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    /**
     *
     * @return
     */
    public int getyCoord() {
        return yCoord;
    }

    /**
     *
     * @param yCoord
     */
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    /**
     *
     * @param loc
     * @return
     */
    public boolean equals(Location loc) {
        return this.getxCoord() == loc.getxCoord()
                && this.getyCoord() == loc.getyCoord();
    }
}

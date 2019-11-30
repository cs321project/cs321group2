/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;

/**
 * The AbstractMapItem that represents the passage from one room to another.
 * It keeps track of its relative position in the room 
 * (left wall, top wall, etc.).
 * @author Matthew
 */
public class RoomTransitionTile extends AbstractMapItem {

    public boolean onLeftWall = false;
    public boolean onRightWall = false;
    public boolean onTopWall = false;
    public boolean onBottomWall = false;
    
    /**
     * Default constructor
     */
    public RoomTransitionTile() {

    }
    
    /**
     * Constructor
     * @param loc becomes the tile's location
     * @param pos A string of either "Top", "Bottom", "Left", or "Right",
     * indicating on which side of the room the tile is.
     */
    public RoomTransitionTile(Location loc, String pos) {
        super.setID("Room");
        super.setLocation(loc);
        switch (pos) {
            case "Top":
                onTopWall = true;
                break;
            case "Bottom":
                onBottomWall = true;
                break;
            case "Left":
                onLeftWall = true;
                break;
            case "Right":
                onRightWall = true;
                break;
        }
    }

    @Override
    public String toString() {
        return "RoomTransitionTile";
    }
}

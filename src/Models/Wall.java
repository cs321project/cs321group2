/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;

/**
 * Wall represents walls on the map
 *
 * @author Group 2
 */
public class Wall extends AbstractMapItem {

    /**
     * Constructor
     */
    public Wall() {
        super.setID(this.toString());
    }
    
    public Wall(Location loc) {
        super.setLocation(loc);
        super.setID("Wall");
    }

    @Override
    public final String toString() {
        return "Wall";
    }

}

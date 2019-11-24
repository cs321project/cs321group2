/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;

/**
 * Floor represents floor tiles on the map grid
 *
 * @author Group2
 */
public class Floor extends AbstractMapItem {

    /**
     * Constructor
     */
    public Floor() {
        super.setID("Floor");
    }

    @Override
    public String toString() {
        return "Floor";
    }

}

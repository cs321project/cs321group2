/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;

/**
 *
 * @author Matthew
 */
public class RoomTransitionTile extends AbstractMapItem {

    /**
     * Constructor
     */
    public RoomTransitionTile() {
        super.setID(this.toString());
    }

    @Override
    public final String toString() {
        return "RoomTransitionTile";
    }
}

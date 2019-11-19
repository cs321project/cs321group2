/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;
//import javafx.util.Pair;

/**
 *
 * @author Group 2
 */
public class Obstacle extends AbstractMapItem {
    
    private int id;
    protected Location location;

    public Obstacle() {

    }

    public Obstacle(Location location) {
        this.location = location;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

}

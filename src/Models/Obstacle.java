/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javafx.util.Pair;

/**
 *
 * @author Group 2
 */
public class Obstacle {

    private Pair location;
    private int id;

    public Obstacle() {

    }

    public Obstacle(Pair location) {
        this.location = location;
    }

    public void setLocation(Pair location) {
        this.location = location;
    }

    public Pair getLocation() {
        return this.location;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

}

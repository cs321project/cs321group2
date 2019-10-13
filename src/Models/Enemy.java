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
public class Enemy {

    private Pair location;
    private int health;

    public Enemy() {

    }

    public Enemy(Pair location, int health) {
        this.location = location;
        this.health = health;
    }

    public void setLocation(Pair location) {
        this.location = location;
    }

    public Pair getLocation() {
        return this.location;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

}

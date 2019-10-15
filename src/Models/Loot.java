/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;
import javafx.util.Pair;

/**
 *
 * @author Group 2
 */
public class Loot extends AbstractMapItem {

    private int value;
    private int id;

    public Loot() {

    }

    public Loot(Pair location, int value, int id) {
        this.location = location;
        this.value = value;
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

}

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
public class Door extends AbstractMapItem {

    private int level;

    public Door() {

    }

    public Door(Pair location, int level) {
        this.location = location;
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
    
    private void unLock() {
        
    }

}

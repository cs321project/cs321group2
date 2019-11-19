/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;

/**
 *
 * @author Group 2
 */
public class Door extends AbstractMapItem {

    private int level;
    private Location location;

    public Door() {

    }

    public Door(Location location, int level) {
        this.location = location;
        this.level = level;
    }
    
    @Override
    public String toString()
    {
        return "Door";
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

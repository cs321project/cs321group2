/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Interfaces.IPlayer;

/**
 *
 * @author Group 2
 */
public class BasicPlayer implements IPlayer {

    private Inventory Inventory;
    
    public Inventory getInventory() {
        return this.Inventory;
    }
    
    public void setInventory(Inventory Inventory) {
        this.Inventory = Inventory;
    }
    
}

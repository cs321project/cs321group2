/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Group 2
 */
public class Trap extends Obstacle {

    private int damageValue;

    public Trap() {

    }
    
    @Override
    public String toString()
    {
        return "Trap";
    }

    public void setValue(int damageValue) {
        this.damageValue = damageValue;
    }

    public int getValue() {
        return this.damageValue;
    }
    
    private void engage() {
        
    }

    
}

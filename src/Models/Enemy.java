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
public class Enemy extends AbstractMapItem {

    private int health;
    private int defense = 5;
    private int attack = 20;
    private boolean hasKey = false;

    private Location location;
    
    public Enemy() {
        this.health = 10;
    }

    public Enemy(Location location, int health) {
        this.location = location;
        this.health = health;
    }

    public void setHealth(int health) {
        this.health = health;
        if(this.health <= 0)
        {
            this.die();
        }
    }

    public int getHealth() {
        return this.health;
    }
    
    public int getDefense() {
        return this.defense;
    }

    public void attack(Player player) {
        int damage;
        damage = this.attack * (100/(100 + player.getDefense()));
        player.setHealth(player.getHealth() - damage);
    }

    public void move() {

    }

    private void die() {

    }

    private void giveKey()
    {
        hasKey = true;
    }
    
    @Override
    public String toString()
    {
        return "Enemy";
    }
}

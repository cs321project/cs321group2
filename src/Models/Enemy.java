/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;

/**
 * Enemy represents enemies that attempt to hurt the player on the map
 *
 * @author Group 2
 */
public class Enemy extends AbstractMapItem {

    public static final int MAX_HEALTH = 5;
    public static final int MAX_ATTACK = 2;
    public static final int MAX_DEFENSE = 2;

    private int health;
    private int attack;
    private int defense;
    private boolean hasKey;
    private final Session session = Session.getInstance();

    /**
     * Constructor
     */
    public Enemy() {
        super.setID("Enemy");
    }

    /**
     * Constructor
     *
     * @param location Enemy placement on the map grid
     * @param health Enemy health
     * @param attack Enemy attack
     * @param defense Enemy defense
     */
    public Enemy(Location location, int health, int attack, int defense) {
        super.setID("Enemy");
        super.setLocation(location);
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    /**
     *
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
        if (this.health <= 0) {
            this.die();
        }
    }

    /**
     *
     * @return
     */
    public int getHealth() {
        return this.health;
    }

    /**
     *
     * @return
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     *
     * @return
     */
    public int getAttack() {
        return this.attack;
    }

    ///**
    // * Removes health when the enemy takes damage from the player
    // *
    // * @param damage
    // */
    //public void takeDamage(int damage) {
    //    this.health = this.health - (damage / this.defense);
    //    if (this.health <= 0) {
    //        this.die();
    //    }
    //}
    ///**
    // * Attack the player
    // */
    //public void attack() {
    //    this.session.currentPlayer.takeDamage(this.attack);
    //}
    
    /**
     * Remove the enemy from the map
     */
    private void die() {

    }

    /**
     *
     */
    public void giveKey() {
        hasKey = true;
    }

    @Override
    public String toString() {
        return "Enemy";
    }

}

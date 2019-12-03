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
    private boolean hasKey = true;
    private final Session session = Session.getInstance();

    /**
     * Constructor
     */
    public Enemy() {
        super.setID(this.toString());
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
        super.setID(this.toString());
        super.setLocation(location);
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    /**
     * Set the health level of the enemy
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
     * Get the health level of the enemy
     *
     * @return Health level
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Get defense level of the enemy
     *
     * @return Defense level
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * Get the attack level of the enemy
     *
     * @return Attack level
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * Removes health when the enemy takes damage from the player
     *
     * @param damage
     */
    public void takeDamage(int damage) {
        this.health = this.health - (damage / this.defense);
        if (this.health <= 0) {
            this.die();
        } else {
            this.attack();
        }
    }

    /**
     * Attack the player
     */
    public void attack() {
        this.session.currentPlayer.takeDamage(this.attack, this);
    }

    /**
     * Remove the enemy from the map
     */
    private void die() {
        AbstractMapItem[][] mapGrid = this.session.currentMap.getMapGrid();
        int x = this.getLocation().getxCoord();
        int y = this.getLocation().getyCoord();

        if (this.hasKey) {
            this.session.currentPlayer.giveKey();
        }

        if (mapGrid != null) {
            mapGrid[y][x] = new Floor();
        }
    }

    /**
     * Gives the enemy the door key that will advance the player to the next
     * level. The user will get this key if they defeat the enemy.
     */
    public void giveKey() {
        hasKey = true;
    }

    @Override
    public final String toString() {
        return "Enemy";
    }

}

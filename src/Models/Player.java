/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author Group 2
 */
public class Player {

    private List<Loot> inventory;
    private int health;
    private Pair location;
    private int baseAttack;
    private int baseDefense;
    private int lives;

    public Player() {

    }

    public Player(List<Loot> inventory, int health, Pair location, int baseAttack, int baseDefense, int lives) {
        this.inventory = inventory;
        this.health = health;
        this.location = location;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.lives = lives;
    }

    public void setInventory(List<Loot> inventory) {
        this.inventory = inventory;
    }

    public List<Loot> getInventory() {
        return this.inventory;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setLocation(Pair location) {
        this.location = location;
    }

    public Pair getLocation() {
        return this.location;
    }

    public void setAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getAttack() {
        return this.baseAttack;
    }

    public void setDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public int getDefense() {
        return this.baseDefense;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return this.lives;
    }

}

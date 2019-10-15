/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;
import java.util.List;

/**
 *
 * @author Group 2
 */
public class Map {

    private int level;
    private List<Loot> loot;
    private List<Obstacle> obstacles;
    private List<Enemy> enemies;
    private Door door;
    private AbstractMapItem[][] mapGrid;
    
    public Map() {
        
    }
    
    public Map(int level, List<Loot> loot, List<Obstacle> obstacles, List<Enemy> enemies, Door door) {
        this.level = level;
        this.loot = loot;
        this.obstacles = obstacles;
        this.enemies = enemies; 
        this.door = door;
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }

    public List<Loot> getLoot() {
        return this.loot;
    }

    public void setLoot(List<Loot> loot) {
        this.loot = loot;
    }

    public List<Obstacle> getObstacles() {
        return this.obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public List<Enemy> getEnemies() {
        return this.enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public Door getDoor() {
        return this.door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

}

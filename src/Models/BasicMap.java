/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Interfaces.IEnemy;
import Interfaces.ILoot;
import Interfaces.IMap;
import Interfaces.ITrap;
import java.util.List;

/**
 *
 * @author Group 2
 */
public class BasicMap implements IMap {

    private List<ILoot> Loot;
    private List<ITrap> Traps;
    private List<IEnemy> Enemies;
    private Door Door;

    public List<ILoot> getLoot() {
        return this.Loot;
    }

    public void setLoot(List<ILoot> Loot) {
        this.Loot = Loot;
    }

    public List<ITrap> getTraps() {
        return this.Traps;
    }

    public void setTraps(List<ITrap> Traps) {
        this.Traps = Traps;
    }

    public List<IEnemy> getEnemies() {
        return this.Enemies;
    }

    public void setEnemies(List<IEnemy> Enemies) {
        this.Enemies = Enemies;
    }

    public Door getDoor() {
        return this.Door;
    }

    public void setDoor(Door Door) {
        this.Door = Door;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Interfaces.ILevel;
import Interfaces.IMap;

/**
 *
 * @author Group 2
 */
public class BasicLevel implements ILevel {

    private int ID;
    private IMap Map;

    public IMap getMap() {
        return this.Map;
    }

    public void setMap(IMap Map) {
        this.Map = Map;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

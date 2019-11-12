/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;
import java.io.Serializable;

/**
 *
 * @author Group 2
 */
public class Map implements Serializable {
    
    public static final int MIN_LEVEL = 1;
    public static final int MAX_LEVEL = 5;

    private int level;
    private AbstractMapItem[][] mapGrid;
    
    public Map() {
        
    }
    
    public Map(int level) {
        this.level = level;
        initializeGrid();
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public String getLevelOfDificulty() {
        switch(this.level) {
            case 1:
                return "Easy";
            case 2:
                return "Medium";
            default:
                return "Hard";
        }
    }
    
    public void setLevel(int level) {
        this.level = level;
    }

    private void initializeGrid() {

    }

}

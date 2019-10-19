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
    
    public void setLevel(int level) {
        this.level = level;
    }

    private void initializeGrid() {

    }

}

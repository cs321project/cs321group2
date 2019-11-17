/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Group 2
 */
public class Map implements Serializable {

    public static final int MIN_LEVEL = 1;
    public static final int MAX_LEVEL = 5;

    private int level;
    private String[] mapFormat;
    private List<AbstractMapItem> mapGrid;

    public Map() {

    }

    public Map(int level) {
        this.level = level;

        switch (level) {
            case 1:
                this.mapFormat = Maps.Maps.Map1;
                break;
            case 2:
                this.mapFormat = Maps.Maps.Map2;
                break;
            case 3:
                this.mapFormat = Maps.Maps.Map3;
                break;
        }

        this.mapGrid = new ArrayList<>();

        for (int j = 0; j < this.mapFormat.length; j++) {
            for (int i = 0; i < this.mapFormat[j].length(); i++) {
                char c = this.mapFormat[j].charAt(i);
                AbstractMapItem item = null;

                switch (c) {
                    case 'D':
                        item = new Door();
                        break;
                    case 'E':
                        item = new Enemy();
                        break;
                    case 'T':
                        item = new Trap();
                        break;
                    case 'L':
                        item = new Loot();
                        break;
                }

                if (item != null) {
                    this.mapGrid.add((AbstractMapItem) item);
                }
            }
        }

        initializeGrid();
    }

    public int getLevel() {
        return this.level;
    }

    public String getLevelOfDificulty() {
        switch (this.level) {
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

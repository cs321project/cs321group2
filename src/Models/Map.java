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
    private List<Room> rooms;

    public Map() {

    }

    public Map(int level) {
        this.level = level;
        rooms = new ArrayList<>();
        //This is test code and will likely be changed later
        //Currently only adds 1 room to a map
        switch (level) {
            case 1:
                rooms.add(new Room(Maps.Maps.OpenRoom1));
                break;
            case 2:
                rooms.add(new Room(Maps.Maps.OpenRoom2));
                break;
            case 3:
                rooms.add(new Room(Maps.Maps.OpenRoom3));
                break;
        }
        //The code that interprets the map strings and adds AbstractMapItems to
        //a list has been moved to Room
        
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

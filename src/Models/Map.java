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
    private List<Enemy> enemies;
    
    public Map() {

    }

    public Map(int level) {
        this.level = level;
        rooms = new ArrayList<>();
        //Currently only level 1 has multiple rooms
        switch (level) {
            case 1:
                assembleMap1();
                assembleEnemiesList();
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
    
    /**
     * Creates rooms and adds the to the map's room list. Also sets the rooms
     * adjacent rooms so they know their relative position.
     */
    private void assembleMap1()
    {
        //Assemble Map
        rooms.add(new Room(Maps.Maps.StartingRoomLevel1));
        rooms.add(new Room(Maps.Maps.OpenRoom1));
        rooms.get(0).setRoomAbove(rooms.get(1));
        rooms.add(new Room(Maps.Maps.DeadEndR));
        rooms.get(2).setRoomRight(rooms.get(1));
        rooms.add(new Room(Maps.Maps.DeadEndB));
        rooms.get(3).setRoomBelow(rooms.get(1));
        rooms.add(new Room(Maps.Maps.BottomRightCornerRoom));
        rooms.get(4).setRoomLeft(rooms.get(1));
        rooms.add(new Room(Maps.Maps.FinalRoomLevel1));
        rooms.get(5).setRoomBelow(rooms.get(4));
    }
    
    /**
     * Takes the enemy lists from the maps rooms and compiles all the enemies into one list.
     * This method also assigns a key to a random enemy in the list
     */
    private void assembleEnemiesList()
    {
        //Assigns key to random enemy
        List<Enemy> tempEnemies = null;
        for (int i = 0; i < rooms.size(); i++)
        {
            tempEnemies = rooms.get(i).getEnemies();
            for (int j = 0; j < tempEnemies.size(); j++)
            {
                this.enemies.add(tempEnemies.get(j));
            }
        }
        //Assigns key to random enemy on the map
        enemies.get((int) (Math.random() * enemies.size())).giveKey();
    }
    
}

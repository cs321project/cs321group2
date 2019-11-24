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
 * Map is the object to represent the map and all of the items on the map
 *
 * @author Group 2
 */
public class Map implements Serializable {

    public static final int MIN_LEVEL = 1;
    public static final int MAX_LEVEL = 5;
    public static final int NUM_ROWS = 30;
    public static final int NUM_COLS = 30;

    private int level;
    private Door mapDoor;
    private List<Room> rooms;
    private List<Enemy> enemies;
    private String[] initMapFormat;
    private AbstractMapItem[][] mapGrid;
    private final Session session = Session.getInstance();

    /**
     * Constructor
     */
    public Map() {

    }

    /**
     * Constructor
     *
     * @param level
     */
    public Map(int level) {
        this.level = level;
        this.rooms = new ArrayList<>();
        this.enemies = new ArrayList<>();

        switch (level) {
            case 1:
                //this.initMapFormat = Maps.Maps.Map1;
                assembleMap1();
                assembleEnemiesList();
                break;
            case 2:
                //this.initMapFormat = Maps.Maps.Map2;
                rooms.add(new Room(Maps.Maps.OpenRoom2));
                break;
            case 3:
                //this.initMapFormat = Maps.Maps.Map3;
                rooms.add(new Room(Maps.Maps.OpenRoom3));
                break;
        }

        //this.mapGrid = new AbstractMapItem[NUM_ROWS][NUM_COLS];
        //for (int j = 0; j < this.initMapFormat.length; j++) {
        //    for (int i = 0; i < this.initMapFormat[j].length(); i++) {
        //        char c = this.initMapFormat[j].charAt(i);
        //        AbstractMapItem item = null;
        //        Location loc = new Location(j, i);
        //        boolean isPlayer = false;
        //        switch (c) {
        //            case 'D': {
        //                item = new Door(loc, this.level);
        //                this.mapDoor = (Door) item;
        //                break;
        //            }
        //            case 'E': {
        //                item = new Enemy(loc, Enemy.MAX_HEALTH,
        //                        Enemy.MAX_ATTACK, Enemy.MAX_DEFENSE);
        //                break;
        //            }
        //            case 'T':
        //                item = new Trap(loc, Trap.MAX_VALUE);
        //                break;
        //            case 'L': {
        //                item = new Loot(loc, Loot.MAX_VALUE, "Loot");
        //                break;
        //            }
        //            case 'P': {
        //                isPlayer = true;
        //                this.mapGrid[i][j] = ((AbstractMapItem) this.session.currentPlayer);
        //                this.session.currentPlayer.setLocation(new Location(j, i));
        //                break;
        //            }
        //            case '|': {
        //                item = new Floor();
        //                break;
        //            }
        //            case '-': {
        //                item = new Wall();
        //                break;
        //            }
        //        }
        //        if (item != null && !isPlayer) {
        //            this.mapGrid[i][j] = ((AbstractMapItem) item);
        //        }
        //    }
        //}
    }

    /**
     * Get the level of the map that the user is on
     *
     * @return
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Gets the list of AbstractMapItems on the map
     *
     * @return
     */
    public AbstractMapItem[][] getMapGrid() {
        return this.mapGrid;
    }

    /**
     * Gets the door on the map
     *
     * @return
     */
    public Door getMapDoor() {
        return this.mapDoor;
    }

    /**
     * Update the list of AbstractMapItem on the map
     *
     * @param grid
     */
    public void setMapGrid(AbstractMapItem[][] grid) {
        this.mapGrid = grid;
    }

    /**
     * Gets a string representation on the map level
     *
     * @return
     */
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

    /**
     * Creates rooms and adds the to the map's room list. Also sets the rooms
     * adjacent rooms so they know their relative position.
     */
    private void assembleMap1() {
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
     * Takes the enemy lists from the maps rooms and compiles all the enemies
     * into one list. This method also assigns a key to a random enemy in the
     * list
     */
    private void assembleEnemiesList() {
        //Assigns key to random enemy
        List<Enemy> tempEnemies = null;
        for (int i = 0; i < rooms.size(); i++) {
            tempEnemies = rooms.get(i).getEnemies();
            for (int j = 0; j < tempEnemies.size(); j++) {
                this.enemies.add(tempEnemies.get(j));
            }
        }
        //Assigns key to random enemy on the map
        enemies.get((int) (Math.random() * enemies.size())).giveKey();
    }

}

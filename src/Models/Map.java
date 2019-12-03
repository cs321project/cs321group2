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
public final class Map implements Serializable {

    public static final int MIN_LEVEL = 1;
    public static final int MAX_LEVEL = 5;
    public static final int NUM_ROWS = 30;
    public static final int NUM_COLS = 30;

    private int level;
    private Door mapDoor;
    private List<Room> rooms;
    private Room currentRoom;
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

        switch (this.session.currentLevel) {
            case 1:
                switch (level) {
                    case 1:
                        this.initMapFormat = Maps.Maps.Level1Map1;
                        break;
                    case 2:
                        this.initMapFormat = Maps.Maps.Level1Map2;
                        break;
                    case 3:
                        this.initMapFormat = Maps.Maps.Level1Map3;
                        break;
                    case 4:
                        this.initMapFormat = Maps.Maps.Level1Map4;
                        break;
                }
                break;
            case 2:
                switch (level) {
                    case 1:
                        this.initMapFormat = Maps.Maps.Level2Map1;
                        break;
                    case 2:
                        this.initMapFormat = Maps.Maps.Level2Map2;
                        break;
                    case 3:
                        this.initMapFormat = Maps.Maps.Level2Map3;
                        break;
                    case 4:
                        this.initMapFormat = Maps.Maps.Level2Map4;
                        break;
                }
                break;
            default:
                switch (level) {
                    case 1:
                        this.initMapFormat = Maps.Maps.Level3Map1;
                        break;
                    case 2:
                        this.initMapFormat = Maps.Maps.Level3Map2;
                        break;
                    case 3:
                        this.initMapFormat = Maps.Maps.Level3Map3;
                        break;
                    case 4:
                        this.initMapFormat = Maps.Maps.Level3Map4;
                        break;
                }
                break;
        }

        this.setToInitialFormat();
    }

    /**
     * Sets the initial format of the map before being changed by the user
     */
    public void setToInitialFormat() {
        this.mapGrid = new AbstractMapItem[NUM_ROWS][NUM_COLS];
        for (int j = 0; j < this.initMapFormat.length; j++) {
            for (int i = 0; i < this.initMapFormat[j].length(); i++) {

                char c = this.initMapFormat[j].charAt(i);
                AbstractMapItem item = null;
                Location loc = new Location(j, i);
                boolean isPlayer = false;

                switch (c) {
                    case 'R': {
                        item = new RoomTransitionTile(loc, "Top");
                        break;
                    }
                    case 'D': {
                        item = new Door(loc, this.level);
                        this.mapDoor = (Door) item;
                        break;
                    }
                    case 'E': {
                        item = new Enemy(loc, Enemy.MAX_HEALTH,
                                Enemy.MAX_ATTACK, Enemy.MAX_DEFENSE);
                        break;
                    }
                    case 'T':
                        item = new Trap(loc, Trap.MAX_VALUE);
                        break;
                    case 'L': {
                        item = new Loot(loc, Loot.MAX_VALUE, "Loot");
                        break;
                    }
                    case 'P': {
                        isPlayer = true;
                        this.mapGrid[i][j] = ((AbstractMapItem) this.session.currentPlayer);
                        this.session.currentPlayer.setLocation(new Location(j, i));
                        break;
                    }
                    case '|': {
                        item = new Wall();
                        break;
                    }
                    default: {
                        item = new Floor();
                        break;
                    }
                }
                if (item != null && !isPlayer) {
                    this.mapGrid[i][j] = ((AbstractMapItem) item);
                }
            }
        }
    }

    /**
     * Get the level of the map that the user is on
     *
     * @return Map Level
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Gets the list of AbstractMapItems on the map
     *
     * @return Map grid of abstract map items
     */
    public AbstractMapItem[][] getMapGrid() {
        return this.mapGrid;
    }

    /**
     * Gets the door on the map
     *
     * @return Map door to the next level
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
     * @return Display name for the level of difficulty of the map
     */
    public String getLevelOfDificulty() {
        switch (this.session.currentLevel) {
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
        String[] firstRoom = Maps.Maps.Level1Map1;
        rooms.add(new Room(firstRoom));
        rooms.add(new Room(Maps.Maps.Level1Map2));
        rooms.get(0).setRoomAbove(rooms.get(1));
        rooms.add(new Room(Maps.Maps.Level2Map1));
        rooms.get(2).setRoomRight(rooms.get(1));
        rooms.add(new Room(Maps.Maps.Level2Map2));
        rooms.get(3).setRoomBelow(rooms.get(1));
        rooms.add(new Room(Maps.Maps.Level3Map2));
        rooms.get(4).setRoomLeft(rooms.get(1));
        rooms.add(new Room(Maps.Maps.Level3Map4));
        rooms.get(5).setRoomBelow(rooms.get(4));

        findDoor();
        assembleEnemiesList();

        setCurrentRoom(rooms.get(0));
        setMapGrid(currentRoom.getRoomGrid());
        this.initMapFormat = firstRoom;
    }

    /**
     * Creates rooms and adds the to the map's room list. Also sets the rooms
     * adjacent rooms so they know their relative position.
     */
    private void assembleMap2() {
        String[] firstRoom = Maps.Maps.Level1Map1;
        rooms.add(new Room(firstRoom)); //0
        rooms.add(new Room(Maps.Maps.Level1Map1)); //1
        rooms.add(new Room(Maps.Maps.Level2Map2)); //2        
        rooms.add(new Room(Maps.Maps.Level1Map1)); //3        
        rooms.add(new Room(Maps.Maps.Level1Map1)); //4        
        rooms.add(new Room(Maps.Maps.Level1Map3)); //5        

        rooms.get(0).setRoomAbove(rooms.get(1));
        rooms.get(2).setRoomBelow(rooms.get(1));
        rooms.get(3).setRoomLeft(rooms.get(1));
        rooms.get(4).setRoomLeft(rooms.get(3));
        rooms.get(5).setRoomBelow(rooms.get(4));

        findDoor();
        assembleEnemiesList();

        setCurrentRoom(rooms.get(0));
        setMapGrid(currentRoom.getRoomGrid());
        this.initMapFormat = firstRoom;
    }

    /**
     * Creates rooms and adds the to the map's room list. Also sets the rooms
     * adjacent rooms so they know their relative position.
     */
    private void assembleMap3() {
        String[] firstRoom = Maps.Maps.Level1Map1;
        rooms.add(new Room(firstRoom)); //0
        rooms.add(new Room(Maps.Maps.Level1Map1)); //1
        rooms.add(new Room(Maps.Maps.Level2Map2)); //2        
        rooms.add(new Room(Maps.Maps.Level1Map1)); //3        
        rooms.add(new Room(Maps.Maps.Level1Map1)); //4        
        rooms.add(new Room(Maps.Maps.Level1Map3)); //5   
        rooms.add(new Room(Maps.Maps.Level1Map1)); //6
        rooms.add(new Room(Maps.Maps.Level1Map2)); //7
        rooms.add(new Room(Maps.Maps.Level1Map1)); //8
        rooms.add(new Room(Maps.Maps.Level1Map1)); //9

        rooms.get(0).setRoomAbove(rooms.get(1));
        rooms.get(2).setRoomLeft(rooms.get(1));
        rooms.get(3).setRoomRight(rooms.get(1));
        rooms.get(4).setRoomRight(rooms.get(3));
        rooms.get(5).setRoomBelow(rooms.get(4));
        rooms.get(6).setRoomAbove(rooms.get(4));
        rooms.get(7).setRoomRight(rooms.get(4));
        rooms.get(8).setRoomBelow(rooms.get(7));
        rooms.get(9).setRoomBelow(rooms.get(8));

        findDoor();
        assembleEnemiesList();

        setCurrentRoom(rooms.get(0));
        setMapGrid(currentRoom.getRoomGrid());
        this.initMapFormat = firstRoom;
    }

    /**
     * Takes the enemy lists from the maps rooms and compiles all the enemies
     * into one list. This method also assigns a key to a random enemy in the
     * list
     */
    private void assembleEnemiesList() {
        //Assigns key to random enemy
        List<Enemy> tempEnemies;
        for (int i = 0; i < rooms.size(); i++) {
            tempEnemies = rooms.get(i).getEnemies();
            for (int j = 0; j < tempEnemies.size(); j++) {
                this.enemies.add(tempEnemies.get(j));
            }
        }
        //Assigns key to random enemy on the map
        enemies.get((int) (Math.random() * enemies.size())).giveKey();
    }

    /**
     * Finds the door inside one of the rooms and sets it as the map's door.
     * Also sets the level of the door.
     */
    private void findDoor() {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).door != null) {
                rooms.get(i).door.setLevel(this.level);
                mapDoor = rooms.get(i).door;
            }
        }
    }

    /**
     * Sets the map room the the player is currently in
     *
     * @param room
     */
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    /**
     * Gets the current room that the player is in
     *
     * @return
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

}

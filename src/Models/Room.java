/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Matthew
 */
public final class Room implements Serializable {

    private AbstractMapItem[][] roomGrid;

    private int roomHeight;
    private int roomWidth;

    private boolean hasTopExit = false;
    private boolean hasBottomExit = false;
    private boolean hasLeftExit = false;
    private boolean hasRightExit = false;

    private List<Floor> floors;
    private List<Wall> walls;
    private List<Enemy> enemies;
    private List<Trap> traps;
    private List<Loot> loot;
    private List<RoomTransitionTile> rtTiles;
    public Door door;

    private Room roomAbove = null;
    private Room roomBelow = null;
    private Room roomRight = null;
    private Room roomLeft = null;

    private static final int TOP_ROW = 0;
    private static final int BOTTOM_ROW = 29;
    private static final int FIRST_COLUMN = 0;
    private static final int LAST_COLUMN = 28;

    /**
     *
     */
    public Room() {

    }

    /**
     *
     * @param mapData
     */
    public Room(String[] mapData, Session session) {
        this.interpretMapData(mapData, session);
    }

    /**
     * -----OUTDATED----- Reads text from a file and returns it as a string
     *
     * @param file
     * @return the text from the file as a String
     */
    public String getMapData(File file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String text;
            String mapCode = "";

            while ((text = br.readLine()) != null) {
                mapCode += "\n" + text;
            }
            return mapCode;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return "getMapData did not work";
    }

    /**
     * Takes a string and builds a Room based on the text from the file '-'
     * indicates the end of a row '|' is a Wall '.' is a Floor 'E' is an Enemy
     * 'T' is a Trap
     *
     * @param mapData the string that contains the information for building the
     * Room
     */
    public void interpretMapData(String[] mapData, Session session) {
        floors = new ArrayList<>();
        walls = new ArrayList<>();
        enemies = new ArrayList<>();
        traps = new ArrayList<>();
        rtTiles = new ArrayList<>();
        loot = new ArrayList<>();
        door = null;

        roomWidth = mapData[0].length();
        roomHeight = mapData.length;
        
        this.roomGrid = new AbstractMapItem[roomWidth][roomHeight];

        for (int j = 0; j < mapData.length; j++) {
            for (int i = 0; i < mapData[j].length(); i++) {
                
                char c = mapData[j].charAt(i);
                AbstractMapItem item = null;
                Location loc = new Location(j, i);
                boolean isPlayer = false;
                
                switch (c) {
                    case 'R':
                        RoomTransitionTile tempRT = null;
                        //If the RoomTransitionTile is on the first row and a top exit does not already exit
                        if (loc.getxCoord() == TOP_ROW && !this.hasTopExit) {
                            this.hasTopExit = true;
                            tempRT = new RoomTransitionTile(loc, "Top");
                        }
                        if (loc.getxCoord() == BOTTOM_ROW && !this.hasBottomExit) {
                            this.hasBottomExit = true;
                            tempRT = new RoomTransitionTile(loc, "Bottom");
                        }
                        if (loc.getyCoord() == FIRST_COLUMN && !this.hasLeftExit) {
                            this.hasLeftExit = true;
                            tempRT = new RoomTransitionTile(loc, "Left");
                        }
                        if (loc.getyCoord() == LAST_COLUMN && !this.hasRightExit) {
                            this.hasRightExit = true;
                            tempRT = new RoomTransitionTile(loc, "Right");
                        }
                        if (tempRT != null) {
                            item = tempRT;
                            rtTiles.add(tempRT);
                        } 
                        break;
                    case 'D': {
                        Door tempDoor = new Door();
                        tempDoor.setLocation(loc);
                        door = tempDoor;
                        item = tempDoor;
                        break;
                    }
                    case 'E': {
                        Enemy tempEnemy = new Enemy(loc, Enemy.MAX_HEALTH,
                                Enemy.MAX_ATTACK, Enemy.MAX_DEFENSE);
                        enemies.add(tempEnemy);
                        item = tempEnemy;
                        break;
                    }
                    case 'T':
                        Trap tempTrap = new Trap(loc, Trap.MAX_VALUE);
                        traps.add(tempTrap);
                        item = tempTrap;
                        break;
                    case 'L': {
                        Loot tempLoot = new Loot(loc, Loot.MAX_VALUE, "Loot");
                        loot.add(tempLoot);
                        item = tempLoot;
                        break;
                    }
                    case 'P': {
                        isPlayer = true;
                        this.roomGrid[i][j] = ((AbstractMapItem) session.currentPlayer);
                        session.currentPlayer.setLocation(new Location(j, i));
                        break;
                    }
                    case '|': {
                        Wall tempWall = new Wall();
                        walls.add(tempWall);
                        item = tempWall;
                        break;
                    }
                    default: {
                        item = new Floor();
                        break;
                    }
                }
                if (item != null && !isPlayer) {
                    this.roomGrid[i][j] = ((AbstractMapItem) item);
                }
            }
        }
    }
    //------------Getters for all AbstractMapItem Lists-----------------------
    /**
     *
     * @return
     */
    public List<Floor> getFloors() {
        return floors;
    }

    /**
     *
     * @return
     */
    public List<Wall> getWalls() {
        return walls;
    }

    /**
     *
     * @return
     */
    public List<Enemy> getEnemies() {
        return enemies;
    }

    /**
     *
     * @return
     */
    public List<Trap> getTraps() {
        return traps;
    }

    /**
     *
     * @return
     */
    public AbstractMapItem[][] getRoomGrid() {
        return roomGrid;
    }

    //---------Getters and Setters for adjacent Rooms---------------------
    /**
     *
     * @return
     */
    public Room getRoomAbove() {
        return roomAbove;
    }

    /**
     *
     * @param roomAbove
     */
    public void setRoomAbove(Room roomAbove) {
        this.roomAbove = roomAbove;
        if (roomAbove.getRoomBelow() == null) {
            roomAbove.setRoomBelow(this);
        }
    }

    /**
     *
     * @return
     */
    public Room getRoomBelow() {
        return roomBelow;
    }

    /**
     *
     * @param roomBelow
     */
    public void setRoomBelow(Room roomBelow) {
        this.roomBelow = roomBelow;
        if (roomBelow.getRoomAbove() == null) {
            roomBelow.setRoomAbove(this);
        }
    }

    /**
     *
     * @return
     */
    public Room getRoomRight() {
        return roomRight;
    }

    /**
     *
     * @param roomRight
     */
    public void setRoomRight(Room roomRight) {
        this.roomRight = roomRight;
        if (roomRight.getRoomLeft() == null) {
            roomRight.setRoomLeft(this);
        }
    }

    /**
     *
     * @return
     */
    public Room getRoomLeft() {
        return roomLeft;
    }

    /**
     *
     * @param roomLeft
     */
    public void setRoomLeft(Room roomLeft) {
        this.roomLeft = roomLeft;
        if (roomLeft.getRoomRight() == null) {
            roomLeft.setRoomRight(this);
        }
    }

}

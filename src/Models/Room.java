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
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public final class Room implements Serializable {

    private List<AbstractMapItem> roomItems;

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
    private List<RoomTransitionTile> rtTiles;
    private Door door;

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
    public Room(String[] mapData) {
        this.interpretMapData(mapData);
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
        } catch (IOException e) {
            e.getStackTrace();
        }
        return "getMapData did not work";
    }

    /**
     * Takes a string and builds a Room based on the text from the file '#'
     * indicates the end of a row '|' is a Wall '_' is a Floor 'E' is an Enemy
     * 'T' is a Trap
     *
     * @param mapData the string that contains the information for building the
     * Room
     */
    public void interpretMapData(String[] mapData) {
        floors = new ArrayList<>();
        walls = new ArrayList<>();
        enemies = new ArrayList<>();
        traps = new ArrayList<>();
        rtTiles = new ArrayList<>();
        roomItems = new ArrayList<>();
        door = null;

        roomWidth = mapData[0].length();
        roomHeight = mapData.length;

        for (int j = 0; j < mapData.length; j++) {
            for (int i = 0; i < mapData[j].length(); i++) {
                AbstractMapItem item = null;
                switch (mapData[j].charAt(i)) {
                    case 'D':
                        door = new Door();
                        roomItems.add(door);
                        door.setLocation(new Location(i, j));
                        break;
                    case '|':
                        //System.out.println("| found " + i + " " +j);
                        Wall tempWall = new Wall();
                        tempWall.setLocation(new Location(i, j));
                        item = tempWall;
                        walls.add(tempWall);
                        break;
                    case '.':
                        //System.out.println("_ found " + i + " " +j);
                        Floor tempFloor = new Floor();
                        tempFloor.setLocation(new Location(i, j));
                        item = tempFloor;
                        floors.add(tempFloor);
                        break;
                    case 'E':
                        //System.out.println("E found " + i + " " +j);
                        Enemy tempEnemy = new Enemy();
                        tempEnemy.setLocation(new Location(i, j));
                        item = tempEnemy;
                        enemies.add(tempEnemy);
                        break;
                    case 'T':
                        //System.out.println("T found " + i + " " +j);
                        Trap tempTrap = new Trap();
                        tempTrap.setLocation(new Location(i, j));
                        item = tempTrap;
                        traps.add(tempTrap);
                        break;
                    case 'R':
                        RoomTransitionTile tempRT = new RoomTransitionTile();
                        tempRT.setLocation(new Location(i, j));
                        //If the RoomTransitionTile is on the first row and a top exit does not already exit
                        if (tempRT.getLocation().getyCoord() == TOP_ROW && !this.hasTopExit) {
                            this.hasTopExit = true;
                        }
                        if (tempRT.getLocation().getyCoord() == BOTTOM_ROW && !this.hasBottomExit) {
                            this.hasBottomExit = true;
                        }
                        if (tempRT.getLocation().getxCoord() == FIRST_COLUMN && !this.hasLeftExit) {
                            this.hasLeftExit = true;
                        }
                        if (tempRT.getLocation().getxCoord() == LAST_COLUMN && !this.hasRightExit) {
                            this.hasRightExit = true;
                        }
                        item = tempRT;
                        rtTiles.add(tempRT);
                        break;
                }

                if (item != null) {
                    this.roomItems.add(item);
                }
            }
        }
    }

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
    public List<AbstractMapItem> getRoomItems() {
        return roomItems;
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

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
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Matthew
 */
public class Room 
{
    private List<AbstractMapItem> roomItems;
    
    private int roomHeight;
    private int roomWidth;
    
    private List<Floor> floors;
    private List<Wall> walls;
    private List<Enemy> enemies;
    private List<Trap> traps;
    private List<RoomTransitionTile> rtTiles;
    private Door door;
    
    
    public Room()
    {
        
    }
    
    public Room(String[] mapData)
    {
        interpretMapData(mapData);
    }
    
    /**
     * -----OUTDATED-----
     * Reads text from a file and returns it as a string
     * @return the text from the file as a String
     */
    public String getMapData(File file)
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(file));
            String text;
            String mapCode = "";
            
            while((text = br.readLine()) != null)
            {
                mapCode += "\n" + text;
            }
            return mapCode;
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
        return "getMapData did not work";
    }
    
    /**
    * Takes a string and builds a Room based on the text from the file
    * '#' indicates the end of a row
    * '|' is a Wall
    * '_' is a Floor
    * 'E' is an Enemy
    * 'T' is a Trap
    * @param mapData the string that contains the information for building the Room
    */
    public void interpretMapData(String[] mapData)
    {
        floors = new ArrayList<>();
        walls = new ArrayList<>();
        enemies = new ArrayList<>();
        traps = new ArrayList<>();
        rtTiles = new ArrayList<>();
        roomItems = new ArrayList<>();
        door = null;
        
        roomWidth = mapData[0].length();
        roomHeight = mapData.length;
        
        for (int j = 0; j < mapData.length; j++)
        {
            for (int i = 0; i < mapData[j].length(); i++)
            {
                AbstractMapItem item = null;
                switch(mapData[j].charAt(i))
                {
                    case 'D':
                        door = new Door();
                        roomItems.add(door);
                        door.setLocation(new Location(i,j));
                        i++;
                        break;                        
                    case '|':
                        //System.out.println("| found " + i + " " +j);
                        Wall tempWall = new Wall();
                        tempWall.setLocation(new Location(i,j));
                        item = tempWall;
                        walls.add(tempWall);
                        i++;
                        break;
                    case '.':
                        //System.out.println("_ found " + i + " " +j);
                        Floor tempFloor = new Floor();
                        tempFloor.setLocation(new Location(i,j));
                        item = tempFloor;
                        floors.add(tempFloor);
                        i++; 
                        break;
                    case 'E':
                        //System.out.println("E found " + i + " " +j);
                        Enemy tempEnemy = new Enemy();
                        tempEnemy.setLocation(new Location(i,j));
                        item = tempEnemy;
                        enemies.add(tempEnemy);
                        i++;                  
                        break;
                    case 'T':
                        //System.out.println("T found " + i + " " +j);
                        Trap tempTrap = new Trap();
                        tempTrap.setLocation(new Location(i,j));
                        item = tempTrap;
                        traps.add(tempTrap);
                        i++;                   
                        break;
                    case 'R':
                        RoomTransitionTile tempRT = new RoomTransitionTile();
                        tempRT.setLocation(new Location(i,j));
                        item = tempRT;
                        rtTiles.add(tempRT);
                        i++;
                        break;                           
                }
                
                if (item!= null)
                {
                    this.roomItems.add(item);
                }
            }
        }
    }
    
    

    public List<Floor> getFloors() {
        return floors;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Trap> getTraps() {
        return traps;
    }

    public List<AbstractMapItem> getRoomItems() {
        return roomItems;
    }
    
    
    
}

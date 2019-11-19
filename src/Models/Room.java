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
/**
 *
 * @author Matthew
 */
public class Room 
{
    private AbstractMapItem[][] grid;
    
    private int roomHeight;
    private int roomWidth;
    
    private ArrayList<Floor> floors;
    private ArrayList<Wall> walls;
    private ArrayList<Enemy> enemies;
    private ArrayList<Trap> traps;
    private Door door;
    
    public Room()
    {
        
    }
    
    /**
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
    public AbstractMapItem[][] interpretMapData(String mapData)
    {
        floors = new ArrayList<>();
        walls = new ArrayList<>();
        enemies = new ArrayList<>();
        traps = new ArrayList<>();
        door = null;
        
        int k = 0; 
        roomWidth = -1; //The while loop does an extra unneeded iteration, so roomWidth is set to -1 to compensate for that
        roomHeight = 0;
        while (mapData.charAt(k) != '#') //For calculating room width
        {
            if (mapData.charAt(k) != ' ')
            {
                roomWidth++;
            }
            k++;
        }
        for (int i = 0; i < mapData.length(); i++) //For calculating room height
        {
            if (mapData.charAt(i) == '#')
            {
                roomHeight++;
            }
        }
        grid = new AbstractMapItem[roomWidth][roomHeight];
        
        int i = 0;
        int j = 0;
        for (int n = 0; n < mapData.length(); n++)
        {
            switch(mapData.charAt(n))
            {
                case '#':
                    //System.out.println("# found " + i + " " + j);
                    j++;
                    i = 0;
                    break;
                case 'D':
                    door = new Door();
                    grid[i][j] = door;
                    i++;
                    break;                        
                case '|':
                    //System.out.println("| found " + i + " " +j);
                    Wall tempWall = new Wall();
                    grid[i][j] = tempWall;
                    walls.add(tempWall);
                    i++;
                    break;
                case '_':
                    //System.out.println("_ found " + i + " " +j);
                    Floor tempFloor = new Floor();
                    grid[i][j] = tempFloor;
                    floors.add(tempFloor);
                    i++; 
                    break;
                case 'E':
                    //System.out.println("E found " + i + " " +j);
                    Enemy tempEnemy = new Enemy();
                    grid[i][j] = tempEnemy;
                    enemies.add(tempEnemy);
                    i++;                  
                    break;
                case 'T':
                    //System.out.println("T found " + i + " " +j);
                    Trap tempTrap = new Trap();
                    grid[i][j] = tempTrap;
                    traps.add(tempTrap);
                    i++;                   
                    break;
            }
        }
        return grid;
    }
    
    /**
     * Produces a string visualization of the room
     * Used for Testing
     * @return 
     */
    public String roomTest()
    {
        String mapString = "";
        //System.out.println("room height: " + roomHeight);
        //System.out.println("room width: " + roomWidth);
        for (int j = 0; j < roomHeight; j++)
        {
            mapString += "\n";
            for (int i = 0; i < roomWidth; i++)
            {
                if (grid[i][j].toString().equals("Floor"))
                {
                    mapString += "\t.";
                    //System.out.println("found a floor " + i + " " + j);
                }
                else if (grid[i][j].toString().equals("Wall"))
                {
                    mapString += "\t|";
                    //System.out.println("found a wall " + i + " " + j);
                }
                else if (grid[i][j].toString().equals("Enemy"))
                {
                    mapString += "\tE";
                    //System.out.println("found a wall " + i + " " + j);
                }
                else if (grid[i][j].toString().equals("Trap"))
                {
                    mapString += "\tT";
                    //System.out.println("found a wall " + i + " " + j);
                }
                else if (grid[i][j].toString().equals("Door"))
                {
                    mapString += "\tD";
                    //System.out.println("found a wall " + i + " " + j);
                }
            }
        }
        return mapString;
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Trap> getTraps() {
        return traps;
    }
    
    
}

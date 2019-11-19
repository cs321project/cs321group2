/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.io.File;

/**
 *
 * @author Matthew
 */
public class RoomWithDoor extends Room{
    
    public RoomWithDoor()
    {
        initializeGrid();
    }
    
    private void initializeGrid()
    {
        File file = new File("RoomWithDoor.txt");
        interpretMapData(super.getMapData(file));
    }
}

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
public class HorizontalHall extends Room
{    
    public HorizontalHall()
    {
        initializeGrid();
    }
    
    private void initializeGrid()
    {
        File file = new File("HorizontalHall.txt");
        interpretMapData(super.getMapData(file));
    }
}

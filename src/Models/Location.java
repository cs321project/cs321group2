/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


/**
 *
 * @author Matthew
 */
public class Location {
    
    private int xCoord;
    private int yCoord;
    
    public Location()
    {
        
    }
    
    public Location(int a, int b)
    {
        xCoord = a;
        yCoord = b;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
    
    
}

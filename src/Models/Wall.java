/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Group 2
 */
public class Wall extends Obstacle {
    
    private Location location;
    
    public Wall() 
    {
        
    }
    
    public Wall(Location location)
    {
        this.location = location;
    }
    
    @Override
    public String toString()
    {
        return "Wall";
    }
}

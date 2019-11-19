/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Abstractions.AbstractMapItem;
/**
 *
 * @author Matthew
 */
public class Floor extends AbstractMapItem{
    
    private Location location;
    
    public Floor()
    {
        
    }
    
    public Floor(Location location)
    {
        this.location = location;
    }
    
    public String toString()
    {
        return "Floor";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstractions;

import java.io.Serializable;
import Models.Location;

/**
 *
 * @author Group 2
 */
//test
public class AbstractMapItem implements Serializable {

    public Location location;

    public void setLocation(Location location)
    {
        this.location = location;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author 
 */
public class Session {
    
    private static Session instance = null;
    
    private Session(){
        
    }
    
    public static Session getInstance(){
        if(instance == null)
            instance = new Session();
        
        return instance;
    }
}

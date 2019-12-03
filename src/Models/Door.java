/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Abstractions.AbstractMapItem;
import Views.GameView;

/**
 * Door is the item that is used to unlock the next level from the map
 *
 * @author Group 2
 */
public class Door extends AbstractMapItem {

    private int level;
    private final Session session = Session.getInstance();

    /**
     * Constructor
     */
    public Door() {
        super.setID(this.toString());
    }

    /**
     * Constructor
     *
     * @param location Item placement on the map grid
     * @param level Map that the user is currently on
     */
    public Door(Location location, int level) {
        super.setID(this.toString());
        super.setLocation(location);
        this.level = level;
    }

    @Override
    public final String toString() {
        return "Door";
    }

    /**
     * Sets the level of the map
     *
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get the level of the map
     *
     * @return Health level
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Let the player know they have won the game
     */
    public void unLock() {
        if (this.session.currentLevel == 3) {
            GameView.DisplayGameOver(
                    this.session.currentPlayer.getUsername());
        } else {
            this.session.currentLevel = this.session.currentLevel + 1;
            this.session.currentPlayer.setHighestLevel(this.session.currentLevel);

            this.session.currentMap = null;
            this.session.currentMap = new Map(Map.MIN_LEVEL);

            GameView.DisplayWinningMessage(
                    this.session.currentPlayer.getUsername(), this.session.currentLevel);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Abstractions.AbstractMapItem;
import Models.Map;
import Models.Player.PlayerDirection;
import Models.Session;
import Utils.Log;
import Utils.SystemUtil;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JTextField;

/**
 *
 * @author Group 2
 */
public class MapView extends JTextField implements java.awt.event.KeyListener, Serializable {

    /**
     *
     */
    public static final BufferedImage WALL = SystemUtil.getBufferedImageFromResource("/Images/wall.png");

    /**
     *
     */
    public static final BufferedImage DOOR = SystemUtil.getBufferedImageFromResource("/Images/door.png");

    /**
     *
     */
    public static final BufferedImage ROOM = SystemUtil.getBufferedImageFromResource("/Images/transparent.png");

    /**
     *
     */
    public static final BufferedImage ENEMY = SystemUtil.getBufferedImageFromResource("/Images/enemy.png");

    /**
     *
     */
    public static final BufferedImage LOOT = SystemUtil.getBufferedImageFromResource("/Images/loot.png");

    /**
     *
     */
    public static final BufferedImage TRAP = SystemUtil.getBufferedImageFromResource("/Images/trap.png");

    /**
     *
     */
    public static final BufferedImage PLAYER = SystemUtil.getBufferedImageFromResource("/Images/player.png");

    /**
     *
     */
    public static final BufferedImage FLOOR = SystemUtil.getBufferedImageFromResource("/Images/transparent.png");

    /**
     *
     */
    public static final int PREFERRED_GRID_SIZE_PIXELS = 20;

    private BufferedImage[][] terrainGrid;
    private final GameView gameView;

    /**
     * Constructor
     *
     * @param gameView
     */
    public MapView(GameView gameView) {
        super.setVisible(true);
        super.setSize(530, 455);
        super.addKeyListener(this);
        super.setFocusable(true);
        super.requestFocus();
        super.setBackground(new Color(0, 0, 0, 0));
        super.setEditable(false);
        super.setOpaque(false);
        super.setEnabled(true);

        this.terrainGrid = null;
        this.gameView = gameView;
        this.setMap();

        int preferredWidth = Map.NUM_COLS * PREFERRED_GRID_SIZE_PIXELS;
        int preferredHeight = Map.NUM_ROWS * PREFERRED_GRID_SIZE_PIXELS;
        super.setPreferredSize(new Dimension(preferredWidth, preferredHeight));
    }

    /**
     *
     */
    public void setMap() {
        this.terrainGrid = new BufferedImage[Map.NUM_ROWS][Map.NUM_COLS];

        AbstractMapItem[][] mapGrid = Session.getInstance().currentMap.getMapGrid();
        for (int j = 0; j < mapGrid.length; j++) {
            for (int i = 0; i < mapGrid[j].length; i++) {

                AbstractMapItem item = mapGrid[j][i];
                String ID = item.getID();
                BufferedImage res = null;

                switch (ID) {
                    case "Wall":
                        res = WALL;
                        break;
                    case "Door":
                        res = DOOR;
                        break;
                    case "Enemy":
                        res = ENEMY;
                        break;
                    case "Loot":
                        res = LOOT;
                        break;
                    case "Trap":
                        res = TRAP;
                        break;
                    case "Player":
                        res = PLAYER;
                        break;
                    case "Floor":
                        res = FLOOR;
                        break;
                    case "RoomTransitionTile":
                        res = ROOM;
                        break;
                }
                this.terrainGrid[i][j] = res;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Image img = null;
        try {
            img = ImageIO.read(MapView.class.getResource("/Images/MapBackground.png"));
        } catch (IOException ex) {
            Logger.getLogger(MapView.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean drawImage;

        g.clearRect(0, 0, getWidth(), getHeight());

        drawImage = g.drawImage(img, 0, 0, null);

        int rectWidth = getWidth() / Map.NUM_COLS;
        int rectHeight = getHeight() / Map.NUM_ROWS;

        for (int i = 0; i < Map.NUM_ROWS; i++) {
            for (int j = 0; j < Map.NUM_COLS; j++) {
                int x = i * rectWidth;
                int y = j * rectHeight;
                g.drawImage(this.terrainGrid[j][i], x, y, rectWidth, rectHeight, null);
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        boolean moved;

        switch (key) {
            case 'w':
            case 'W':
                moved = Session.getInstance().currentPlayer.move(PlayerDirection.Forward);
                Log.verbose("Forward");
                break;
            case 'a':
            case 'A':
                moved = Session.getInstance().currentPlayer.move(PlayerDirection.Left);
                Log.verbose("Left");
                break;
            case 's':
            case 'S':
                moved = Session.getInstance().currentPlayer.move(PlayerDirection.Backward);
                Log.verbose("Backward");
                break;
            case 'd':
            case 'D':
                moved = Session.getInstance().currentPlayer.move(PlayerDirection.Right);
                Log.verbose("Right");
                break;
            default:
                Log.verbose("Key not detected");
        }

        this.setMap();
        super.repaint();
        this.gameView.UpdatePlayerStats();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Utils.Log;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Group 2
 */
public class MapView extends JTextField implements java.awt.event.KeyListener {

    public static final Color WALL = new Color(97, 71, 41);
    public static final Color DOOR = new Color(214, 204, 2);
    public static final Color ENEMY = new Color(255, 0, 0);
    public static final Color LOOT = new Color(189, 189, 0);
    public static final Color TRAP = new Color(189, 110, 0);
    public static final Color PLAYER = new Color(0, 0, 255);
    public static final Color MAP = new Color(0, 0, 0);

    public static final Color[] TERRAIN = {
        WALL,
        DOOR,
        ENEMY,
        LOOT,
        TRAP,
        PLAYER,
        MAP
    };

    public static final int NUM_ROWS = 30;
    public static final int NUM_COLS = 30;

    public static final int PREFERRED_GRID_SIZE_PIXELS = 20;

    private final TileShape[][] terrainGrid;

    public MapView() {
        super.setVisible(true);
        super.setSize(520, 420);
        super.addKeyListener(this);
        super.setFocusable(true);
        super.requestFocus();
        super.setBackground(new Color(0, 0, 0, 0));
        super.setEditable(false);
        super.setEnabled(true);

        this.terrainGrid = new TileShape[NUM_ROWS][NUM_COLS];

        for (int j = 0; j < Maps.Maps.Map1.length; j++) {
            for (int i = 0; i < Maps.Maps.Map1[j].length(); i++) {
                char c = Maps.Maps.Map1[j].charAt(i);
                Color color = null;

                switch (c) {
                    case '|':
                        color = TERRAIN[6];
                        break;
                    case 'D':
                        color = TERRAIN[1];
                        break;
                    case 'E':
                        color = TERRAIN[2];
                        break;
                    case 'T':
                        color = TERRAIN[4];
                        break;
                    case 'P':
                        color = TERRAIN[5];
                        //new Player(i,j);
                        break;
                    case 'L':
                        color = TERRAIN[3];
                        break;
                    default:
                        color = TERRAIN[0];
                        break;
                }

                this.terrainGrid[i][j]
                        = new TileShape(j * 40, i * 40, 40, color);
            }
        }

        int preferredWidth = NUM_COLS * PREFERRED_GRID_SIZE_PIXELS;
        int preferredHeight = NUM_ROWS * PREFERRED_GRID_SIZE_PIXELS;
        super.setPreferredSize(new Dimension(preferredWidth, preferredHeight));
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.clearRect(0, 0, getWidth(), getHeight());

        int rectWidth = getWidth() / NUM_COLS;
        int rectHeight = getHeight() / NUM_ROWS;

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                int x = i * rectWidth;
                int y = j * rectHeight;
                Color terrainColor = terrainGrid[i][j].getColor();
                g.setColor(terrainColor);
                g.fillRect(x, y, rectWidth, rectHeight);
            }
        }

    }

    private enum Direction {
        Forward,
        Backward,
        Right,
        Left,
        None
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        Direction direction = Direction.None;

        switch (key) {
            case 'w':
            case 'W':
                direction = Direction.Forward;
                Log.verbose("Forward");
                break;
            case 'a':
            case 'A':
                direction = Direction.Left;
                Log.verbose("Left");
                break;
            case 's':
            case 'S':
                direction = Direction.Backward;
                Log.verbose("Backward");
                break;
            case 'd':
            case 'D':
                direction = Direction.Right;
                Log.verbose("Right");
                break;
            default:
                Log.verbose("Key not detected");
        }
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

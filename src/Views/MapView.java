/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javax.swing.JPanel;

/**
 *
 * @author Group 2
 */
public class MapView extends JPanel {

    public MapView() {
        this.setVisible(true);
        this.setSize(550, 550);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (int x = 10; x <= 550; x += 10)
            for (int y = 10; y <= 550; y += 10)
                g.drawRect(x, y, 10, 10);

    }
}

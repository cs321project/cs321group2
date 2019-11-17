/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author branc
 */
public class TileShape {
    private int x;
    private int y;
    private int width;
    private Color color;

    public TileShape(int x, int y, int width, Color c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.color = c;
    }

    public void draw(Graphics2D g2) {
        Rectangle2D.Double tile = new Rectangle2D.Double(x, y, width, width);
        g2.draw(tile);
    }
    public void setColor(Color c){
        color = c;
    }
     public Color getColor(){
        return color;
    }
    public boolean contains(Point2D p)
   {
      return x <= p.getX() && p.getX() <= x + width 
         && y <= p.getY() && p.getY() <= y + width;
   }
   public void translate(int dx, int dy)
   {
      x += dx;
      y += dy;
   }
}

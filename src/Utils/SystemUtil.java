/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Views.MapView;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Group 2
 */
public class SystemUtil {

    /**
     *
     * @return
     */
    public static String getUserDirectory() {
        return System.getProperty(Constants.USER_DIR_KEY);
    }

    /**
     *
     * @param res
     * @return
     */
    public static BufferedImage getBufferedImageFromResource(String res) {
        try {
            return ImageIO.read(MapView.class.getResource(res));
        } catch (IOException ex) {
            Logger.getLogger(SystemUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}

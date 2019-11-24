/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Group 2
 */
public class Settings {

    /**
     * De-serializes session
     *
     * @param session
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Session getSetting(Session session) throws IOException, ClassNotFoundException {

        Session s;
        try (FileInputStream file = new FileInputStream(
                session.currentPlayer.getPlayerSettingsFile());
                ObjectInputStream in = new ObjectInputStream(file)) {
            s = (Session) in.readObject();
        }

        return s;
    }

    /**
     * Serializes session
     *
     * @param session
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void addOrUpdateSetting(Session session) throws FileNotFoundException, IOException {

        try (FileOutputStream file = new FileOutputStream(
                session.currentPlayer.getPlayerSettingsFile());
                ObjectOutputStream out = new ObjectOutputStream(file)) {

            out.writeObject(session);
        }
    }
}

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
 * @author Branch Hill
 */
public class Settings {

    public static boolean getSetting(Session session) throws IOException, ClassNotFoundException {

        FileInputStream file
                = new FileInputStream(session.currentPlayer.getPlayerSettingsDir());
        ObjectInputStream in = new ObjectInputStream(file);

        Session s= (Session) in.readObject();
        Session.setInstance(s);

        in.close();
        file.close();

        return true;
    }

    public static void addOrUpdateSetting(Session session) throws FileNotFoundException, IOException {

        FileOutputStream file
                = new FileOutputStream(session.currentPlayer.getPlayerSettingsDir());
        ObjectOutputStream out = new ObjectOutputStream(file);

        out.writeObject(session);

        out.close();
        file.close();
    }
}

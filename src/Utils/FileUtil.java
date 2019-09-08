/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Group 2
 */
public class FileUtil {

    public static boolean Exists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static void CreateFile(String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
    }

    public static void CreateIfNotPresent(String path) throws IOException {
        if (Exists(path)) {
            return;
        }

        CreateFile(path);
    }

    public static void WriteMapToSettingsFile(Map map) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        CreateIfNotPresent(Constants.SETTINGS_FILE);
        PrintWriter writer = new PrintWriter(Constants.SETTINGS_FILE, "UTF-8");

        map.keySet().forEach((key) -> {
            writer.println(key.toString() + ":"
                    + map.getOrDefault(key, Constants.EMPTY_STRING).toString());
        });
    }

    public static Map GetMapFromSettingsFile() throws FileNotFoundException, IOException {
        Map map = new HashMap();

        if (!Exists(Constants.SETTINGS_FILE)) {
            return map;
        }

        BufferedReader reader = new BufferedReader(new FileReader(Constants.SETTINGS_FILE));
        String line = reader.readLine();

        while (line != null) {
            String[] pair = line.split(":");
            map.put(pair[0], pair[1]);
        }

        reader.close();
        return map;
    }

}

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

public class FileUtil {

    public static boolean fileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static void createFile(String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
    }

    public static void createIfNotPresent(String path) throws IOException {
        if (fileExists(path)) {
            return;
        }
        createFile(path);
    }

    public static void WriteMapToSettingsFile(Map map) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        createIfNotPresent(Constants.SETTINGS_FILE);
        PrintWriter writer = new PrintWriter(Constants.SETTINGS_FILE, "UTF-8");
        map.keySet().forEach(( key)->{
    writer.println(key.toString() + ":" + map.getOrDefault(key, Constants.EMPTY_STRING).toString());
});
    }

    public static Map getMapFromSettingsFile() throws FileNotFoundException, IOException {
        Map map = new HashMap();
        if (!fileExists(Constants.SETTINGS_FILE)) {
            return map;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.SETTINGS_FILE))) {
            String line = reader.readLine();
            while (line != null) {
                String[] pair = line.split(":");
                map.put(pair[0], pair[1]);
            }
        }
        return map;
    }
}
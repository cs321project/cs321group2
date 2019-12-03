package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Branch Hill
 */
public class FileUtil {

    /**
     * Checks if a file exists on disk
     *
     * @param path
     * @return boolean
     */
    public static boolean fileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * Creates a new file locally on disk
     *
     * @param path
     * @throws IOException
     */
    public static void createFile(String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
    }

    /**
     * Creates a new file if not already present
     *
     * @param path
     * @throws IOException
     */
    public static void createIfNotPresent(String path) throws IOException {
        if (fileExists(path)) {
            return;
        }
        createFile(path);
    }

    /**
     * Creates a new directory on disk
     *
     * @param path
     */
    public static void createDirectory(String path) {
        File file = new File(path);
        if (!file.exists()) {
            if (file.mkdir()) {
                Log.verbose(StringUtil.concat("Created dir: ", path));
            } else {
                Log.verbose(StringUtil.concat("Failed to create dir: ", path));
            }
        }
    }

    /**
     * Gets all subdirectories of a directory
     *
     * @param path
     * @return
     */
    public static String[] getSubdirectories(String path) {
        File file = new File(path);
        String[] directories = file.list((File current, String name)
                -> new File(current, name).isDirectory());

        return directories;
    }

    /**
     * Write to settings file
     *
     * @param map
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public static void WriteMapToSettingsFile(Map map) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        createIfNotPresent(Constants.SETTINGS_FILE);
        PrintWriter writer = new PrintWriter(Constants.SETTINGS_FILE, "UTF-8");
        map.keySet().forEach((key) -> {
            writer.println(key.toString() + ":" + map.getOrDefault(key, Constants.EMPTY_STRING).toString());
        });
    }

    /**
     * Get settings file
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     */
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

    /**
     * Reads all lines of a file
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static List<String> readLines(String path) throws FileNotFoundException, IOException {
        List<String> lineList = new ArrayList<>();

        BufferedReader reader;
        reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();
        while (line != null) {
            lineList.add(line);
        }
        reader.close();

        return lineList;
    }
}

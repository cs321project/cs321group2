package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class ApplicationSettings {

    public static Map getAppSettings() throws IOException {
        return FileUtil.getMapFromSettingsFile();
    }

    public static void updateAppSettings(Map dict) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        FileUtil.WriteMapToSettingsFile(dict);
    }
}

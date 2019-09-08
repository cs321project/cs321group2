/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 *
 * @author Branch Hill
 */
public class ApplicationSettings {

    public static Map GetAppSettings() throws IOException {
        return FileUtil.GetMapFromSettingsFile();
    }

    public static void UpdateAppSettings(Map dict) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        FileUtil.WriteMapToSettingsFile(dict);
    }

}

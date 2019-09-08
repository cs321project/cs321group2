/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utils.ApplicationSettings;
import Utils.Constants;
import Utils.Log;
import java.util.Map;

/**
 *
 * @author Branch Hill
 */
public class Settings {

    private Map applicationSettings = null;

    public Settings() {
        try {
            Log.Verbose("Initializing App Settings");
            applicationSettings = ApplicationSettings.GetAppSettings();
        } catch (Exception ex) {
            Log.Exception(ex);
        }
    }

    public String GetSetting(String key) {
        try {
            if (key == null) {
                return Constants.EMPTY_STRING;
            }

            return (String) applicationSettings.getOrDefault(key, Constants.EMPTY_STRING);
        } catch (Exception ex) {
            Log.Exception(ex);
            return Constants.EMPTY_STRING;
        }
    }

    public boolean AddOrUpdateSetting(String key, String value) {
        try {
            if (key == null || value == null) {
                return false;
            }

            applicationSettings.put(key, value);
            ApplicationSettings.UpdateAppSettings(applicationSettings);
            return true;
        } catch (Exception ex) {
            Log.Exception(ex);
            return false;
        }
    }
}

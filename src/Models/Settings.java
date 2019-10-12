/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utils.ApplicationSettings;
import Utils.Constants;
import Utils.Log;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Branch Hill
 */
public class Settings {

    private Map applicationSettings = null;

    public Settings() {
        try {
            Log.verbose("Initializing App Settings");
            applicationSettings = ApplicationSettings.getAppSettings();
        } catch (IOException ex) {
            Log.exception(ex);
        }
    }

    public String getSetting(String key) {
        try {
            if (key == null) {
                return Constants.EMPTY_STRING;
            }

            return (String) applicationSettings.getOrDefault(key, Constants.EMPTY_STRING);
        } catch (Exception ex) {
            Log.exception(ex);
            return Constants.EMPTY_STRING;
        }
    }

    public boolean addOrUpdateSetting(String key, String value) {
        try {
            if (key == null || value == null) {
                return false;
            }

            applicationSettings.put(key, value);
            ApplicationSettings.updateAppSettings(applicationSettings);
            return true;
        } catch (IOException ex) {
            Log.exception(ex);
            return false;
        }
    }
}

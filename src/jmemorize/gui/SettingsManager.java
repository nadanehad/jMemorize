package jmemorize.gui;

import java.util.prefs.Preferences;

public class SettingsManager {
    private static final String DARK_MODE_KEY = "dark_mode";

    public static boolean isDarkModeEnabled() {
        Preferences preferences = Preferences.userNodeForPackage(SettingsManager.class);
        return preferences.getBoolean(DARK_MODE_KEY, false); // Default to false (light mode)
    }

    public static void setDarkModeEnabled(boolean darkModeEnabled) {
        Preferences preferences = Preferences.userNodeForPackage(SettingsManager.class);
        preferences.putBoolean(DARK_MODE_KEY, darkModeEnabled);
    }
}


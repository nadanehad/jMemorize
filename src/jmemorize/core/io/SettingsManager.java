package jmemorize.core.io;

import jmemorize.core.Settings;

import java.io.*;

public class SettingsManager {
        public static void backupSettings(Settings settings, String filePath) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
                outputStream.writeObject(settings);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static Settings restoreSettings(String filePath) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
                return (Settings) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
}

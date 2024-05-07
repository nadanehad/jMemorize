package jmemorize.core.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImportAndExport {
    // Function to import files from the computer
    public static List<String> importFiles(String directoryPath) {
        List<String> fileContents = new ArrayList<>();
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        StringBuilder content = new StringBuilder();
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                content.append(line).append("\n");
                            }
                            fileContents.add(content.toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return fileContents;
    }

    // Function to export files to the computer
    public static void exportFiles(String directoryPath, List<String> contents) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs(); // Create directory if it doesn't exist
        }
        for (int i = 0; i < contents.size(); i++) {
            String content = contents.get(i);
            File file = new File(directory, "file" + i + ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        // Example usage of importFiles function
        List<String> importedFiles = importFiles("C:/example_directory");
        for (String content : importedFiles) {
            System.out.println("Imported File Content:");
            System.out.println(content);
        }

        // Example usage of exportFiles function
        List<String> contentsToExport = new ArrayList<>();
        contentsToExport.add("File 1 content");
        contentsToExport.add("File 2 content");
        exportFiles("C:/exported_directory", contentsToExport);
    }
}

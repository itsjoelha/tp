package seedu.duke.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Data {
    private final File file;

    public Data(String filepath) {
        this.file = new File(filepath);
    }

    public String[] searchMod(String modCode) {
        // Check if the file exists before attempting to read
        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return null;
        }

        // Initialize Scanner and handle resources properly
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\|");

                // Check if the current line contains the desired modCode
                if (words.length >= 4 && words[0].equals(modCode)) {
                    return words; // Return the parts if modCode matches
                }
            }
        } catch (FileNotFoundException e) {
            // Handle the exception properly
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Return null if the modCode is not found
        return null;
    }
}

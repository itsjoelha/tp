package seedu.duke;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Data {
    private final File file;

    public Data(String filepath) {
        this.file = new File(filepath);
    }

    public String[] searchMod(String modCode) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\|");
                if (words[0].equals(modCode)) {
                    return words;
                }
                line = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }

}

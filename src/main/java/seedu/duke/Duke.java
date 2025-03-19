package seedu.duke;

import java.util.ArrayList;
import java.util.Scanner;

import seedu.duke.data.Mod;
import seedu.duke.command.*;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static ArrayList<Mod> moduleList = new ArrayList<>();
    public static int totalMCs = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Grand Rhombus");
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String userInput = in.nextLine().trim();

            if (userInput.equalsIgnoreCase("die")) {
                System.out.println("Exiting program...");
                break;
            }

            String[] parts = userInput.split(" ", 2); // Split into two parts (cmd + argument)
            String usercmd = parts[0];
            String modCode = (parts.length > 1) ? parts[1] : ""; // Prevents IndexOutOfBoundsException

            Command cmd = null;

            switch (usercmd) {
                case "d":
                    if (modCode.isEmpty()) {
                        System.out.println("Error: Please specify a module code to delete.");
                        continue;
                    }
                    cmd = new DeleteModule(modCode);
                    break;

                case "a":
                    if (modCode.isEmpty()) {
                        System.out.println("Error: Please specify a module code to add.");
                        continue;
                    }
                    cmd = new AddModule(modCode);
                    break;

                case "/schedule":
                    cmd = new RecommendedSchedule();
                    break;

                default:
                    System.out.println("Invalid command. Try again.");
                    continue;
            }

            cmd.execute(); // Execute the selected command
        }

        in.close(); // Close scanner when the program exits
    }
}

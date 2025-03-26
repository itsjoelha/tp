package seedu.duke;

import java.util.ArrayList;
import java.util.Scanner;

import seedu.duke.data.Mod;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static ArrayList<Mod> moduleList = new ArrayList<>();
    public static int totalMCs = 0;
    public static CommandParser commandParser = new CommandParser();

    public static void main(String[] args) {
        System.out.println("Welcome to Grand Rhombus, your personal CEG Assistant");
        Scanner in = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.print("Enter command: ");
            String userInput = in.nextLine().trim();

            isRunning = !commandParser.parseCommand(userInput); // If parseCommand returns true, exit loop

        }

        in.close(); // Close scanner when the program exits
        System.out.println("Goodbye, thank you for using Grand Rhombus"); // Handle exit command

    }
}


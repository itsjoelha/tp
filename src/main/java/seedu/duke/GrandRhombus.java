package seedu.duke;

import java.util.Scanner;

public class GrandRhombus {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static final String DASH_LINE = "------------------------------------------------------";

    public static void main(String[] args) {
        System.out.println(DASH_LINE);
        System.out.println("Hello I'm GrandRhombus!");
        System.out.println("How are you today?");
        System.out.println(DASH_LINE);

        Scanner in = new Scanner(System.in);

        // Create an instance of CommandParser to process commands
        CommandParser commandParser = new CommandParser();

        // Start listening for user commands
        while (true) {
            System.out.println("Enter a command:");
            String input = in.nextLine().trim();
            commandParser.parseCommand(input); // Pass the input to CommandParser
        }
    }
}

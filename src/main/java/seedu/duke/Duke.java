package seedu.duke;

import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

        CommandParser commandParser = new CommandParser();

        // Start listening for user commands
        while (true) {
            try {
                System.out.println("Enter a command:");
                String input = in.nextLine().trim();
                commandParser.parseCommand(input); // Pass input to CommandParser
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                break;  // Break out of the loop if an exception occurs
            }
        }

        in.close();
    }
}

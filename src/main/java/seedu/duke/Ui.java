package seedu.duke;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ui {

    private static final Logger logger = Logger.getLogger(Ui.class.getName());

    static {
        logger.setLevel(Level.OFF);
    }

    public String readInput() {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine().trim();
        logger.info("Received user input: " + userInput);
        return userInput;
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Grand Rhombus, your personal CEG Assistant");
    }

    public void farewellMessage() {
        System.out.println("Goodbye, thank you for using Grand Rhombus");
    }

    public void printEnterCommand() {
        System.out.println("Enter command: ");
    }

    public static void printEmptyCommandError() {
        System.out.println("No command entered. Try again.");
    }

    public static void printUserInputError(String command) {
        System.out.println("Invalid command. Try again.");
        switch (command) {
        case "/detail":

        }
    }
}

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

    public static void exitMessage() {
        System.out.println("Exiting program...");
    }

    public void farewellMessage() {
        System.out.println("Goodbye, thank you for using Grand Rhombus");
    }

    public void printEnterCommand() {
        System.out.print("Enter command: ");
    }

    public static void printEmptyCommandError() {
        System.out.println("No command entered. Try again.");
    }

    public static void printUnknownCommandError() {
        System.out.println("Unknown command. Type '/help' for a list of commands.");
    }

    public static void printUserInputError(String command) {
        switch (command) {
        case "/detail":
            System.out.println("Error: Please specify a module code to view details.");
            System.out.println("Usage: /detail MODULE_CODE");
            break;
        case "/add":
            System.out.println("Error: Please specify a module code and semester to add.");
            System.out.println("Usage: /add MODULE_CODE SEMESTER");
            break;
        case "/addCustom":
            System.out.println("Error: Please specify module details to add custom module.");
            System.out.println("Usage: /addCustom MODULE_CODE SEMESTER NUMBER_OF_CREDITS NAME");
            break;
        case "/delete":
            System.out.println("Error: Please specify a module code to delete.");
            System.out.println("Usage: /delete MODULE_CODE");
            break;
        case "/grade":
            System.out.println("Error: Please specify a module code and grade.");
            System.out.println("Usage: /grade MODULE_CODE GRADE");
            break;
        default:
            System.out.println("Unknown command. Type '/help' for a list of commands.");
            break;

        }
    }

    public static void printExcessInputError(String command) {
        System.out.println("Error: The '" + command + "' command does not accept any arguments.");

    }

}



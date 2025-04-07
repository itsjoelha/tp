package seedu.duke;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ui {

    private static final Logger logger = Logger.getLogger(Ui.class.getName());

    static {
        logger.setLevel(Level.OFF);
    }

    public static String readInput() {
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

    public void farewellMessage(String name) {
        String farewellMessage = "Goodbye";
        if (!name.isEmpty()) {
            farewellMessage += " " + name;
        }
        System.out.println(farewellMessage + ", thank you for using Grand Rhombus");
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

    public static void printInvalidCharacterInputError(String command) {
        System.out.println("Invalid characters detected. Only letters and digits are allowed (no symbols or spaces).");
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
        case "/su":
            System.out.println("Error: Please specify a module code to S/U.");
            System.out.println("Usage: /su MODULE_CODE");
            break;
        default:
            System.out.println("Unknown command. Type '/help' for a list of commands.");
            break;

        }
    }

    public static void printExcessInputError(String command) {
        System.out.println("Error: The '" + command + "' command has too many arguments.");

    }

    public static void textWrapDescription(String description) { // prints description to fit
        // into the output window
        int wrapLength = 77;
        StringBuilder currentLine = new StringBuilder();
        String[] words = description.split(" ");

        for (String word : words) {
            // Handle words longer than wrapLength
            while (word.length() > wrapLength) {
                int breakIndex = word.lastIndexOf("/", wrapLength);
                if (breakIndex == -1) {
                    // No slash found, force split at wrapLength
                    System.out.printf("| %-78s |\n", word.substring(0, wrapLength));
                    word = word.substring(wrapLength);
                } else {
                    // Split at last slash within wrapLength
                    System.out.printf("| %-78s |\n", word.substring(0, breakIndex + 1));
                    word = word.substring(breakIndex + 1);
                }
            }

            // Move to a new line if adding word exceeds wrapLength
            if (currentLine.length() + word.length() + 1 > wrapLength) {
                System.out.printf("| %-78s |\n", currentLine.toString().trim());
                currentLine.setLength(0);
            }

            if (currentLine.isEmpty()) {
                currentLine.append(" ");
            }
            currentLine.append(word);
            currentLine.append(" ");
        }

        // Print remaining line
        System.out.printf("| %-78s |\n", currentLine.toString().trim());

    }

    public static void printDashes() {
        System.out.println("+--------------------------------------------------------------------------------+");
    }

    public static boolean isValidSem(int semester) {
        if (semester < 1 || semester > 8) {
            System.out.println("Invalid semester. Please choose between 1 and 8.");
            return false;
        }
        return true;
    }

    public static Boolean askYesNo() {

        while (true) {
            String userInput = Ui.readInput();
            if (userInput.equals("/exit")) {
                return null;
            }
            if (userInput.equalsIgnoreCase("y")) {
                return true;
            } else if (userInput.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("Please enter a 'y' or 'n'.");
        }
    }
}



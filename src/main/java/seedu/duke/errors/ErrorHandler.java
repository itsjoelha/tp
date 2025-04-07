package seedu.duke.errors;

import seedu.duke.Ui;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorHandler {

    private static final Logger logger = Logger.getLogger(ErrorHandler.class.getName());

    static {
        logger.setLevel(Level.OFF);
    }

    public static void userInputError(String[] words) {
        String command = words[0];
        switch (command) {
        case "/detail":
            logger.warning("Detail command missing module code.");
            break;
        case "/delete":
            logger.warning("Delete command missing module code.");
            break;
        case "/su":
            logger.warning("Su command missing module code.");
            break;
        case "/add":
            logger.warning("Add command missing module code or semester.");
            break;
        case "/addCustom":
            logger.warning("Add custom module command missing unspecified content");
            break;
        case "/grade":
            logger.warning("Grade command missing module code or grade");
            break;
        default:
            logger.warning("Unknown error occurred.");
            break;
        }
        Ui.printUserInputError(command);
    }

    public static void integerInputError(String word, String command) {
        if (word.equals("semester")) {
            logger.warning("Invalid semester format in " + command + " command.");
            System.out.println("Error: Semester must be a number between 1 and 8.");
        } else if (word.equals("creditNum")) {
            logger.warning("Invalid credit number format in " + command + " command.");
            System.out.println("Error: Credit number must be a positive integer.");
        }

    }

    public static void excessInputError(String command) {
        logger.warning("Additional inputs for " + command + " command.");
        Ui.printExcessInputError(command);
    }

    public static void invalidCharacterInputError(String moduleCode, String command) {
        logger.warning("Invalid input for " + moduleCode + " command.");
        Ui.printInvalidCharacterInputError(command);
    }
}

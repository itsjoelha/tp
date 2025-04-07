package seedu.duke;

import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.duke.command.ClearModules;
import seedu.duke.command.Command;
import seedu.duke.command.ListModules;
import seedu.duke.command.DetailModules;
import seedu.duke.command.AddUserModule;
import seedu.duke.command.DeleteUserModule;
import seedu.duke.command.SuUserModule;
import seedu.duke.command.GetUserGPA;
import seedu.duke.command.GradeModule;
import seedu.duke.command.Help;
import seedu.duke.command.ViewGradRequirements;
import seedu.duke.command.RecommendedSchedule;
import seedu.duke.command.Specialisation;
import seedu.duke.command.Workload;
import seedu.duke.command.AddCustomModule;
import seedu.duke.errors.ErrorHandler;


import static seedu.duke.Duke.currentUser;

public class CommandParser {

    private static final Logger logger = Logger.getLogger(CommandParser.class.getName());

    static {
        logger.setLevel(Level.OFF);
    }

    // This method will parse and separate into required sections
    public String[] parseCommand(String userInput) {
        String[] words = userInput.trim().split("\\s+", 5);
        return removeWhitespace(words);
    }

    // remove any extra spaces around each split
    public String[] removeWhitespace(String[] input) {
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].trim();
        }
        return input;
    }

    public int requiredInput(String command) {
        int input = 0;
        switch (command) {
        case "/gpa", "/grad", "/spec", "/clear":
            input = 1;
            break;
        case "/view", "/detail", "/delete", "/su", "/help", "/workload", "/schedule":
            input = 2;
            break;
        case "/add", "/grade":
            input = 3;
            break;
        default:
            input = 5;
            break;
        }
        return input;
    }

    // This method calls the appropriate command
    public boolean callCommand(String[] words) throws ArrayIndexOutOfBoundsException, NumberFormatException {
        String command = words[0];
        Command cmdObject = null;
        int semester;

        if (words.length > requiredInput(command)) {
            ErrorHandler.excessInputError(command);
            return true;
        }

        switch (command) {
        case "/view":
            if (words.length == 2) {
                semester = Integer.parseInt(words[1]);
                logger.info("Executing ListModules command to view modules in semester " + semester);
                cmdObject = new ListModules(currentUser, words[1]);
            } else {
                logger.info("Executing ListModules command to view all modules.");
                cmdObject = new ListModules(currentUser);
            }
            break;

        case "/detail":
            logger.info("Executing DetailModules command with module code: " + words[1]);
            cmdObject = new DetailModules(words[1]);
            break;

        case "/add":
            semester = Integer.parseInt(words[2]);
            logger.info("Executing AddUserModule command with module code: " + words[1] + ", semester: " + semester);
            cmdObject = new AddUserModule(currentUser, words[1], semester);
            break;

        case "/addCustom":
            semester = Integer.parseInt(words[2]);
            try {
                if (!words[1].matches("^[a-zA-Z0-9]+$")) {
                    ErrorHandler.invalidCharacterInputError("module code", command);
                    break;
                }
                int creditNum = Integer.parseInt(words[3]);
                logger.info("Executing AddCustomModule command with module code: " + words[1]
                        + ", semester: " + semester);
                cmdObject = new AddCustomModule(currentUser, words[1], semester, creditNum, words[4]);
            } catch (NumberFormatException e) {
                ErrorHandler.integerInputError("creditNum", command);
            }
            break;

        case "/delete":
            logger.info("Executing RemoveUserModule command with module code: " + words[1]);
            cmdObject = new DeleteUserModule(currentUser, words[1]);
            break;

        case "/su":
            logger.info("Executing su command with module code: " + words[1]);
            cmdObject = new SuUserModule(currentUser, words[1]);
            break;

        case "/gpa":
            logger.info("Executing getting GPA.");
            cmdObject = new GetUserGPA(currentUser);
            break;

        case "/grade":
            logger.info("Executing grade module");
            cmdObject = new GradeModule(currentUser, words[1], words[2]);
            break;

        case "/help":
            logger.info("Displaying help file.");
            if (words.length == 2) {
                cmdObject = new Help(words[1]);
            } else {
                cmdObject = new Help();
            }
            break;

        case "/grad":
            logger.info("Executing ViewGradRequirements command.");
            cmdObject = new ViewGradRequirements(currentUser);
            break;

        case "/schedule":
            if (words.length == 1) {
                logger.warning("Schedule command missing required argument.");
                System.out.println("Error: Please indicate either 'jc' or 'poly' to see the respective schedules.");
            } else if (!words[1].equals("jc") && !words[1].equals("poly")) {
                logger.warning("Schedule command has invalid argument: " + words[1]);
                System.out.println("Error: Please use either 'jc' or 'poly'.");
            } else {
                logger.info("Executing RecommendedSchedule command with argument: " + words[1]);
                cmdObject = new RecommendedSchedule(words[1]);
            }
            break;

        case "/spec":
            logger.info("Displaying Specialisations.");
            cmdObject = new Specialisation();
            break;

        case "/workload":
            if (words.length == 2) {
                semester = Integer.parseInt(words[1]);
                logger.info("Executing Workload command to view modules in semester " + semester);
                cmdObject = new Workload(currentUser, semester);
            } else {
                logger.info("Executing Workload command to view all modules.");
                cmdObject = new Workload(currentUser);
            }
            break;

        case "/clear":
            cmdObject = new ClearModules(currentUser);
            break;

        case "/exit":
            logger.info("User exited program.");
            Ui.exitMessage();
            return false;

        case "": // empty command line
            logger.warning("User entered an empty command.");
            Ui.printEmptyCommandError();
            return true;

        default:
            logger.warning("Unknown command: " + command);
            Ui.printUnknownCommandError();
        }

        if (cmdObject != null) {
            cmdObject.execute();
        }
        return true;
    }
}


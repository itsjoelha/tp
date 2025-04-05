package seedu.duke;

import java.util.logging.Level;
import java.util.logging.Logger;

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
import seedu.duke.Ui;


import static seedu.duke.Duke.currentUser;

public class CommandParser {

    private static final Logger logger = Logger.getLogger(CommandParser.class.getName());

    static {
        logger.setLevel(Level.OFF);
    }

    // This method will parse and handle commands
    public String[] parseCommand(String userInput) {
        assert userInput != null : "User input should not be null";
        
        if (userInput.isEmpty()) {
            logger.warning("User entered an empty command.");
            Ui.printEmptyCommandError();
            return true;
        }

        String[] words = userInput.split(" ", 5);
        String command = words[0];
        Command cmdObject = null;
    }

    public boolean callCommand(String[] command) throws ArrayIndexOutOfBoundsException {
        switch (command[0]) {
        case "/view":
            if (words.length > 2) {
                logger.warning("View command has too many arguments.");
                System.out.println("Error: The '/view' command accepts at most one argument (semester number).");
            } else if (words.length == 2) {
                try {
                    int semester = Integer.parseInt(words[1]);
                    if (semester < 1 || semester > 8) {
                        logger.warning("Invalid semester number: " + semester);
                        System.out.println("Error: Semester must be a number between 1 and 8.");
                    } else {
                        logger.info("Executing ListModules command to view modules in semester " + semester);
                        cmdObject = new ListModules(currentUser, words[1]);
                    }
                } catch (NumberFormatException e) {
                    logger.warning("Invalid semester format in View command.");
                    System.out.println("Error: Semester must be a number between 1 and 8.");
                }
            } else {
                logger.info("Executing ListModules command to view all modules.");
                cmdObject = new ListModules(currentUser);
            }
            break;

        case "/detail":
            if (words.length < 2) {
                logger.warning("Detail command missing module code.");
                System.out.println("Error: Please specify a module code to view details.");
                break;
            }
            logger.info("Executing DetailModules command with module code: " + words[1]);
            cmdObject = new DetailModules(words[1]);
            break;

        case "/add":
            if (words.length < 3) {
                logger.warning("Add command missing module code or semester.");
                System.out.println("Error: Please specify a module code and semester to add.");
                System.out.println("Usage: /add MODULE_CODE SEMESTER");
                break;
            }
            try {
                int semester = Integer.parseInt(words[2]);
                logger.info("Executing AddUserModule command with module code: " + words[1] +
                        ", semester: " + semester);
                cmdObject = new AddUserModule(currentUser, words[1], semester);
            } catch (NumberFormatException e) {
                logger.warning("Invalid semester format.");
                System.out.println("Error: Semester must be a number between 1 and 8.");
                break;
            }
            break;

        case "/addCustom":
            if (words.length < 5) {
                logger.warning("Add custom module command missing unspecified content");
                System.out.println("Error: Please specify module details to add custom module.");
                System.out.println("Usage: /addCustom MODULE_CODE SEMESTER NUMBER_OF_CREDITS NAME");
                break;
            }
            try {
                int semester = Integer.parseInt(words[2]);
                int creditNum = Integer.parseInt(words[3]);
                logger.info("Executing AddCustomModule command with module code: " + words[1] +
                        ", semester: " + semester);
                cmdObject = new AddCustomModule(currentUser, words[1], semester, creditNum, words[4]);
            } catch (NumberFormatException e) {
                logger.warning("Invalid semester format in AddCustomModule command.");
                System.out.println("Error: Semester must be a number between 1 and 8 and credit number must"
                        + " be a positive integer.");
                break;
            }
            break;

        case "/delete":
            if (words.length < 2) {
                logger.warning("Delete command missing module code.");
                System.out.println("Error: Please specify a module code to delete.");
                break;
            }
            logger.info("Executing RemoveUserModule command with module code: " + words[1]);
            cmdObject = new DeleteUserModule(currentUser, words[1]);
            break;

        case "/su":
            if (words.length < 2) {
                logger.warning("Su command missing module code.");
                System.out.println("Error: Please specify a module code to S/U.");
                break;
            }
            logger.info("Executing su command with module code: " + words[1]);
            cmdObject = new SuUserModule(currentUser, words[1]);
            break;

        case "/gpa":
            logger.info("Executing getting GPA.");
            cmdObject = new GetUserGPA(currentUser);
            break;

        case "/grade":
            if (words.length < 3) {
                logger.warning("Grade command missing module code or grade");
                System.out.println("Error: Please specify a module code to grade.");
                break;
            }
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
            if (words.length > 1) {
                logger.warning("Graduation Requirements command doesn't accept additional arguments.");
                System.out.println("Error: The '/grad' command doesn't accept any arguments.");
            } else {
                logger.info("Executing ViewGradRequirements command.");
                cmdObject = new ViewGradRequirements(currentUser);
            }
            break;

        case "/schedule":
            if (words.length > 1) {
                logger.warning("Specialisation command doesn't accept additional arguments.");
                System.out.println("Error: The '/schedule' command doesn't accept any arguments.");
            } else {
                logger.info("Executing RecommendedSchedule command.");
                cmdObject = new RecommendedSchedule();
            }
            break;

        case "/spec":
            if (words.length > 1) {
                logger.warning("Specialisation command doesn't accept additional arguments.");
                System.out.println("Error: The '/spec' command doesn't accept any arguments.");
            } else {
                logger.info("Displaying Specialisations.");
                cmdObject = new Specialisation();
            }
            break;

        case "/workload":
            if (words.length > 2) {
                logger.warning("Workload command has too many arguments.");
                System.out.println("Error: The '/workload' command accepts at most one argument (semester number).");
            } else if (words.length == 2) {
                try {
                    int semester = Integer.parseInt(words[1]);
                    if (semester < 1 || semester > 8) {
                        logger.warning("Invalid semester number: " + semester);
                        System.out.println("Error: Semester must be a number between 1 and 8.");
                    } else {
                        logger.info("Executing Workload command to view modules in semester " + semester);
                        cmdObject = new Workload(currentUser, words[1]);
                    }
                } catch (NumberFormatException e) {
                    logger.warning("Invalid semester format in Workload command.");
                    System.out.println("Error: Semester must be a number between 1 and 8.");
                }
            } else {
                logger.info("Executing Workload command to view all modules.");
                cmdObject = new Workload(currentUser);
            }
            break;

        case "/exit":
            logger.info("User exited program.");
            System.out.println("Exiting program...");
            return false;

        default:
            logger.warning("Unknown command: " + command);
            System.out.println("Unknown command. Type '/help' for a list of commands.");
        }

        if (cmdObject != null) {
            cmdObject.execute();
        }

        return true;

    }
}


package seedu.duke;

import java.util.logging.Level;
import java.util.logging.Logger;

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


import static seedu.duke.Duke.currentUser;

public class CommandParser {

    private static final Logger logger = Logger.getLogger(CommandParser.class.getName());

    static {
        logger.setLevel(Level.OFF);
    }

    // This method will parse and handle commands
    public boolean parseCommand(String userInput) {

        logger.info("Received user input: " + userInput);
        assert userInput != null : "User input should not be null";

        // Trim leading/trailing spaces
        userInput = userInput.trim();

        if (userInput.isEmpty()) {
            logger.warning("User entered an empty command.");
            System.out.println("No command entered. Try again.");
            return false;
        }

        String[] words = userInput.split(" ", 5);
        String command = words[0];

        switch (command) {
        case "/view":
            logger.info("Executing ListModules command.");
            new ListModules(currentUser).execute();
            break;

        case "/detail":
            if (words.length < 2) {
                logger.warning("Detail command missing module code.");
                System.out.println("Error: Please specify a module code to view details.");
                return false;
            }
            logger.info("Executing DetailModules command with module code: " + words[1]);
            new DetailModules(words[1]).execute();
            break;

        case "/add":
            if (words.length < 3) {
                logger.warning("Add command missing module code or semester.");
                System.out.println("Error: Please specify a module code and semester to add.");
                System.out.println("Usage: /add MODULE_CODE SEMESTER");
                return false;
            }
            try {
                int semester = Integer.parseInt(words[2]);
                logger.info("Executing AddUserModule command with module code: " + words[1] +
                        ", semester: " + semester);
                new AddUserModule(currentUser, words[1], semester).execute();
            } catch (NumberFormatException e) {
                logger.warning("Invalid semester format.");
                System.out.println("Error: Semester must be a number between 1 and 8.");
                return false;
            }
            break;

        case "/addCustom":
            if (words.length < 5) {
                logger.warning("Add custom module command missing unspecified content");
                System.out.println("Error: Please specify module details to add custom module.");
                System.out.println("Usage: /addCustom MODULE_CODE SEMESTER CREDIT_NUMBER NAME");
                return false;
            }
            try {
                int semester = Integer.parseInt(words[2]);
                int creditNum = Integer.parseInt(words[3]);
                logger.info("Executing AddCustomModule command with module code: " + words[1] +
                        ", semester: " + semester);
                new AddCustomModule(currentUser, words[1], semester, creditNum, words[4]).execute();
            } catch (NumberFormatException e) {
                logger.warning("Invalid semester format in AddCustomModule command.");
                System.out.println("Error: Semester must be a number between 1 and 8 and credit number must"
                        + " be a positive integer.");
                return false;
            }
            break;

        case "/delete":
            if (words.length < 2) {
                logger.warning("Delete command missing module code.");
                System.out.println("Error: Please specify a module code to delete.");
                return false;
            }
            logger.info("Executing RemoveUserModule command with module code: " + words[1]);
            new DeleteUserModule(currentUser, words[1]).execute();
            break;

        case "/su":
            if (words.length < 3) {
                logger.warning("Su command missing module code.");
                System.out.println("Error: Please specify a module code to suspend.");
                return false;
            }
            logger.info("Executing su command with module code: " + words[1]);
            new SuUserModule(currentUser, words[1]).execute();
            break;

        case "/gpa":
            logger.info("Executing getting GPA.");
            new GetUserGPA(currentUser).execute();
            break;

        case "/grade":
            if (words.length < 3) {
                logger.warning("Grade command missing module code or grade");
                System.out.println("Error: Please specify a module code to grade.");
                return false;
            }
            logger.info("Executing grade module");
            new GradeModule(currentUser, words[1], words[2]).execute();
            break;


        case "/help":
            logger.info("Displaying help file.");
            Help.displayHelpFile();
            break;

        case "/grad":
            logger.info("Executing ViewGradRequirements command.");
            new ViewGradRequirements(currentUser).execute();
            break;

        case "/schedule":
            logger.info("Executing RecommendedSchedule command.");
            new RecommendedSchedule().execute();
            break;

        case "/specialisation":
            logger.info("Displaying Specialisations.");
            Specialisation.displaySpecialisations();
            break;

        case "/workload":
            logger.info("Executing Workload command.");
            new Workload(currentUser).execute();
            break;

        case "/exit":
            logger.info("User exited program.");
            System.out.println("Exiting program...");
            return true;

        default:
            logger.warning("Unknown command: " + command);
            System.out.println("Unknown command. Type '/help' for a list of commands.");
        }

        return false;

    }
}

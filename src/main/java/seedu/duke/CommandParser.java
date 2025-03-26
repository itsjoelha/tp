package seedu.duke;

import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.duke.command.AddMod;
import seedu.duke.command.Command;
import seedu.duke.command.DeleteMod;
import seedu.duke.command.DetailModules;
import seedu.duke.command.Help;
import seedu.duke.command.ListModules;
import seedu.duke.command.RecommendedSchedule;
import seedu.duke.command.Specialisation;
import seedu.duke.command.ViewGradRequirements;
import seedu.duke.command.Workload;

public class CommandParser {

    private static final Logger logger = Logger.getLogger(CommandParser.class.getName());

    static {
        logger.setLevel(Level.OFF);
    }

    // This method will parse and handle commands
    public boolean parseCommand(String userInput) {

        logger.info("Received user input: " + userInput);
        assert userInput != null : "User input should not be null";

        // Trim leading/trailing spaces to avoid parsing issues
        userInput = userInput.trim();

        // If input is empty, return early
        if (userInput.isEmpty()) {
            logger.warning("User entered an empty command.");
            System.out.println("No command entered. Try again.");
            return false;
        }

        String[] words = userInput.split(" ");
        String command = words[0];

        // Handle commands with arguments
        if (command.equals("/view")) {
            logger.info("Executing ListModules command.");
            Command cmd = new ListModules();
            cmd.execute();
        } else if (command.startsWith("/detail")) {
            if (words.length < 2) {
                logger.warning("Detail command missing module code.");
                System.out.println("Error: Please specify a module code to view details.");
                return false;
            }
            logger.info("Executing DetailModules command with module code: " + words[1]);
            Command cmd = new DetailModules(words[1]);
            cmd.execute();
        } else if (command.startsWith("/add")) {
            if (words.length < 2) {
                logger.warning("Add command missing module code.");
                System.out.println("Error: Please specify a module code to add.");
                return false;
            }
            logger.info("Executing AddModule command with module code: " + words[1]);
            Command cmd = new AddMod(words[1]);
            cmd.execute();
        } else if (command.startsWith("/delete")) {
            if (words.length < 2) {
                logger.warning("Delete command missing module code.");
                System.out.println("Error: Please specify a module code to delete.");
                return false;
            }
            logger.info("Executing DeleteModule command with module code: " + words[1]);
            Command cmd = new DeleteMod(words[1]);
            cmd.execute();
        } else if (command.equals("/help")) {
            logger.info("Displaying help file.");
            Help.displayHelpFile(); // Handle help command
        } else if (command.equals("/grad")) {
            logger.info("Executing ViewGradRequirements command.");
            Command cmd = new ViewGradRequirements();
            cmd.execute(); // Handle grad command
        } else if (command.equals("/schedule")) {
            logger.info("Executing RecommendedSchedule command.");
            Command cmd = new RecommendedSchedule();
            cmd.execute(); // Handle schedule command
        } else if (command.equals("/specialisation")) {
            logger.info("Displaying Specialisations.");
            Specialisation.displaySpecialisations(); // Handle specialisation command
        } else if (command.equals("/workload")) {
            logger.info("Executing Workload command.");
            Command cmd = new Workload();
            cmd.execute();
        } else if (command.equals("/exit")) {
            logger.info("User exited program.");
            System.out.println("EXIT"); // Handle exit command
            return true;
        } else {
            logger.warning("Unknown command: " + command);
            System.out.println("Unknown command. Type '/help' for a list of commands."); // Unknown command
        }

        return false;
    }
}


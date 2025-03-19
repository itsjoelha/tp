package seedu.duke;
import seedu.duke.command.Command;
import seedu.duke.command.DetailModules;
import seedu.duke.command.ListModules;
import seedu.duke.command.DeleteModule;
import seedu.duke.command.AddModule;
import seedu.duke.command.ViewGradRequirements;
import seedu.duke.command.RecommendedSchedule;



public class CommandParser {

    // This method will parse and handle commands
    public void parseCommand(String userInput) {
        String[] words = userInput.split(" ");
        String command = words[0];

        if (command.equals("/view")) {
            Command cmd = new ListModules();
            cmd.execute();
        } else if (command.startsWith("/detail")) {
            Command cmd = new DetailModules(words[1]);
            cmd.execute();
        } else if (command.startsWith("/add")) {
            Command cmd = new AddModule(words[1]);
            cmd.execute();// Handle add command
        } else if (command.startsWith("/delete")) {
            Command cmd = new DeleteModule(words[1]);
            cmd.execute(); // Handle delete command
        } else if (command.equals("/help")) {
            Help.displayHelpFile(); // Handle help command
        } else if (command.equals("/grad")) {
            Command cmd = new ViewGradRequirements();
            cmd.execute(); // Handle grad command
        } else if (command.equals("/schedule")) {
            Command cmd = new RecommendedSchedule();
            cmd.execute();// Handle schedule command
        } else if (command.equals("/specialisation")) {
            Specialisation.displaySpecialisations(); // Handle specialisation command
        } else if (command.equals("/exit")) {
            System.out.println("EXIT"); // Handle exit command
        } else {
            System.out.println("Unknown command. Type '/help' for a list of commands."); // Unknown command
        }
    }
}

package seedu.duke;
import seedu.duke.command.*;

import javax.sound.midi.SysexMessage;

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
            System.out.println("HELP"); // Handle help command
        } else if (command.equals("/grad")) {
            System.out.println("GRAD"); // Handle grad command
        } else if (command.equals("/schedule -jc")) {
            System.out.println("SCHEDULE JC");// Handle schedule -jc command
        } else if (command.equals("/schedule -poly")) {
            System.out.println("SCHEDULE POLY"); // Handle schedule -poly command
        } else if (command.equals("/specialisation")) {
            Specialisation.displaySpecialisations(); // Handle specialisation command
        } else if (command.equals("/exit")) {
            System.out.println("EXIT"); // Handle exit command
        } else {
            System.out.println("Unknown command. Type '/help' for a list of commands."); // Unknown command
        }
    }
}

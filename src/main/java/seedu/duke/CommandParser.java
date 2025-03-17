package seedu.duke;

public class CommandParser {

    // This method will parse and handle commands
    public void parseCommand(String command) {
        if (command.equals("/view")) {
            System.out.println("VIEW"); // Handle view command
        } else if (command.startsWith("/add")) {
            System.out.println("ADD"); // Handle add command
        } else if (command.startsWith("/delete")) {
            System.out.println("DELETE"); // Handle delete command
        } else if (command.equals("/help")) {
            System.out.println("HELP"); // Handle help command
        } else if (command.equals("/grad")) {
            System.out.println("GRAD"); // Handle grad command
        } else if (command.equals("/schedule -jc")) {
            System.out.println("SCHEDULE JC");// Handle schedule -jc command
        } else if (command.equals("/schedule -poly")) {
            System.out.println("SCHEDULE POLY"); // Handle schedule -poly command
        } else if (command.equals("/specialisation")) {
            System.out.println("SPECIALISATION"); // Handle specialisation command
        } else if (command.equals("/exit")) {
            System.out.println("EXIT"); // Handle exit command
        } else {
            System.out.println("Unknown command. Type '/help' for a list of commands."); // Unknown command
        }
    }
}

package seedu.duke;

import java.util.ArrayList;
import java.util.Scanner;

import seedu.duke.data.Mod;
import seedu.duke.command.AddModule;
import seedu.duke.command.DeleteModule;
import seedu.duke.command.Command;
import seedu.duke.command.ListModules;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static ArrayList<Mod> moduleList = new ArrayList<>();
    public static int totalMCs = 0;
    public static CommandParser commandParser = new CommandParser();

    public static void main(String[] args) {
        System.out.println("Welcome to Grand Rhombus");
        Scanner in = new Scanner(System.in);

        String userInput = in.nextLine();
        while (!userInput.equals("/exit")) {
            commandParser.parseCommand(userInput);
            userInput = in.nextLine();
        }

    }
}

package seedu.duke;

import java.util.Scanner;

import seedu.duke.data.User;
import seedu.duke.data.UserData;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static CommandParser commandParser = new CommandParser();
    public static User currentUser = new User();
    public static UserData userData = new UserData("data/user.txt");
    public static Ui ui = new Ui();

    public static void main(String[] args) {
        ui.welcomeMessage();
        currentUser = userData.loadUserData();
        String userInput = ui.readInput();
        boolean isRunning = true;

        while (isRunning) {
            ui.printEnterCommand();
            String[] command = null;
            try {
                command = commandParser.parseCommand(userInput);
                isRunning = commandParser.callCommand(command);// If parseCommand returns false, exit loop
            } catch (ArrayIndexOutOfBoundsException e) {
                assert command != null;
                Ui.printUserInputError(command[0]);
            } finally {
                userInput = ui.readInput();
                userData.saveUserData(currentUser);
            }
        }
        ui.farewellMessage();
    }
}

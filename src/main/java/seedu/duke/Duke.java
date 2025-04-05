package seedu.duke;

import seedu.duke.data.User;
import seedu.duke.data.UserData;
import seedu.duke.errors.ErrorHandler;

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

        boolean isRunning = true;

        while (isRunning) {
            ui.printEnterCommand();
            String userInput = ui.readInput();
            String[] command = null;
            try {
                command = commandParser.parseCommand(userInput);
                isRunning = commandParser.callCommand(command);// If parseCommand returns false, exit loop
            } catch (ArrayIndexOutOfBoundsException e) {
                assert command != null;
                ErrorHandler.userInputError(command);
            } catch (NumberFormatException e) {
                assert command != null;
                ErrorHandler.integerInputError("semester", command[0]);
            }  finally {
                userData.saveUserData(currentUser);
            }
        }
        ui.farewellMessage();
    }
}

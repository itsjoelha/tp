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
            ui.enterCommand();

            if (!in.hasNextLine()) {  // Prevent NoSuchElementException
                break;
            }

            isRunning = commandParser.parseCommand(userInput); // If parseCommand returns true, exit loop
            userData.saveUserData(currentUser);
        }
        ui.farewellMessage();
    }
    public void run() {
        ui.welcomeMessage();
        String input = ui.readInput();

        while (!input.equals("bye")) {
            String[] command = null;
            try {
                command = Parser.parseCommand(input);
                tasks.execute(command);
            } catch (ArrayIndexOutOfBoundsException e) {
                Ui.printDescriptionError(command[0]);
            } catch (NullPointerException e) {
                Ui.printEmptyCommandError();
            } finally {
                storage.saveTasks(tasks.tasks);
                input = ui.readInput();
            }
        }

        ui.farewellMessage();
    }
}

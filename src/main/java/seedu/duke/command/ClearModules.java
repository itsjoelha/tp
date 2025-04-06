package seedu.duke.command;

import seedu.duke.user.User;

public class ClearModules implements Command {
    private final User user;

    public ClearModules(User user) {
        this.user = user;
    }

    public void execute() {
        user.clearModules();
        System.out.println("All modules cleared from schedule");
    }
}

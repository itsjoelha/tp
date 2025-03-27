package seedu.duke.command;

import seedu.duke.data.User;

public class DeleteUserModule implements Command {
    private final String moduleCode;
    private final User user;

    public DeleteUserModule(User user, String moduleCode) {
        this.user = user;
        this.moduleCode = moduleCode;
    }

    @Override
    public void execute() {
        boolean removed = user.removeModule(moduleCode);
        if (removed) {
            System.out.println("Module " + moduleCode + " successfully removed.");
        } else {
            System.out.println("Module " + moduleCode + " not found.");
        }
    }
}

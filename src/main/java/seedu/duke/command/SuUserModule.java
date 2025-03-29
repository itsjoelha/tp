package seedu.duke.command;

import seedu.duke.data.User;

public class SuUserModule implements Command {
    private String moduleCode;
    private final User user;

    public SuUserModule(User user, String moduleCode) {
        this.user = user;
        this.moduleCode = moduleCode;
    }
    @Override
    public void execute() {
        boolean sUed = user.suModule(moduleCode);
        if (sUed) {
            System.out.println("Module " + moduleCode.toUpperCase() + " successfully SU-ed");
        } else {
            System.out.println("Failed to SU " + moduleCode.toUpperCase() + ". It may not exist");
        }
    }
}

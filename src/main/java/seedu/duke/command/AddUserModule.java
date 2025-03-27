package seedu.duke.command;

import seedu.duke.data.User;

public class AddUserModule implements Command {
    private final String moduleCode;
    private final int semester;
    private final User user;

    public AddUserModule(User user, String moduleCode, int semester) {
        this.user = user;
        this.moduleCode = moduleCode;
        this.semester = semester;
    }

    @Override
    public void execute() {
        if (semester < 1 || semester > 8) {
            System.out.println("Invalid semester. Please choose between 1 and 8.");
            return;
        }

        boolean added = user.addModule(moduleCode, semester);
        if (added) {
            System.out.println("Module " + moduleCode + " successfully added to semester " + semester);
        } else {
            System.out.println("Failed to add module " + moduleCode + ". It may already exist.");
        }
    }
}

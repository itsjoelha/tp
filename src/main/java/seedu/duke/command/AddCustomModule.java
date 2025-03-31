package seedu.duke.command;

import seedu.duke.data.User;

public class AddCustomModule implements Command {
    private final String name;
    private final String moduleCode;
    private final int numMC;
    private final int semester;
    private final User user;


    public AddCustomModule(User user, String moduleCode, int semester, int numMC, String name) {
        this.numMC = numMC;
        this.name = name;
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

        boolean added = user.addCustomModule(moduleCode, numMC, name, semester);
        if (added) {
            System.out.println("Module " + moduleCode + " successfully added to semester " + semester +
                    " as a Custom Module.");
        } else {
            System.out.println("Failed to add module " + moduleCode + ". It may already exist.");
        }
    }

}

package seedu.duke.command;

import java.util.ArrayList;
import java.util.Map;

import seedu.duke.data.User;
import seedu.duke.data.UserMod;

public class SuUserModule implements Command {
    private String moduleCode;
    private final User user;

    public SuUserModule(User user, String moduleCode) {
        this.user = user;
        this.moduleCode = moduleCode;
    }
    @Override
    public void execute() {
        UserMod module = user.getModule(moduleCode);
        if (module == null) {
            System.out.println("Failed to SU " + moduleCode.toUpperCase() + ". It may not exist");
            return;
        }
        module.setSU(true);
        System.out.println("Module " + moduleCode.toUpperCase() + " successfully SU-ed");
    }
}

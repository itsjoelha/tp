package seedu.duke.command;

import java.util.ArrayList;
import java.util.Map;

import seedu.duke.data.User;
import seedu.duke.data.UserMod;

public class DeleteUserModule implements Command {
    private final String moduleCode;
    private final User user;

    public DeleteUserModule(User user, String moduleCode) {
        this.user = user;
        this.moduleCode = moduleCode;
    }

    @Override
    public void execute() {
        Map<Integer, ArrayList<UserMod>> semesterModules = user.getSemesterModules();

        for (int semester : semesterModules.keySet()) {
            if (semesterModules.get(semester).removeIf(UserMod ->
                    UserMod.getCode().equals(moduleCode.toUpperCase()))) {
                user.checkAllPrereqs();
                System.out.println("Module " + moduleCode.toUpperCase() + " successfully removed.");
                return;
            }
        }

        System.out.println("Module " + moduleCode.toUpperCase() + " not found.");
    }
}

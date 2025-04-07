package seedu.duke.command;

import java.util.ArrayList;
import java.util.Map;

import seedu.duke.data.UserMod;
import seedu.duke.user.User;

public class WaiveModPrereq implements Command {
    private final String moduleCode;
    private final User user;

    public WaiveModPrereq(User user, String moduleCode) {
        this.user = user;
        this.moduleCode = moduleCode;
    }

    public void execute() {
        Map<Integer, ArrayList<UserMod>> semesterModules = user.getSemesterModules();

        for (int semester : semesterModules.keySet()) {
            for (UserMod userMod : semesterModules.get(semester)) {
                if (userMod.getCode().equalsIgnoreCase(moduleCode)) {
                    userMod.togglePrereqWaived();
                    System.out.println((userMod.isPrereqWaived() ? "Waived" : "Unwaived") +
                            " " + userMod.getCode());
                    return;
                }
            }
        }

        System.out.println("Module " + moduleCode.toUpperCase() + " not found.");
    }
}

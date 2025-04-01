package seedu.duke.command;

import java.util.ArrayList;
import java.util.Map;

import seedu.duke.data.User;
import seedu.duke.data.UserMod;
import seedu.duke.errors.ModNotInDatabase;

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

        Map<Integer, ArrayList<UserMod>> semesterModules = user.getSemesterModules();

        try {
            UserMod newMod = new UserMod(moduleCode);

            semesterModules.putIfAbsent(semester, new ArrayList<>());
            if (user.hasModule(moduleCode)) {
                System.out.println("Failed to add module " + moduleCode.toUpperCase() + ". It may already exist.");
                return;
            }

            semesterModules.get(semester).add(newMod);
            user.setSemesterModules(semesterModules);
            user.updateGPA();

            if (!user.fulfillsModPrereq(newMod, semester)) {
                System.out.println("WARNING: " + moduleCode + " missing prerequisites");
                return;
            }

            System.out.println("Module " + moduleCode.toUpperCase() + " successfully added to Semester " + semester);


        } catch (ModNotInDatabase e) {
            System.out.println(moduleCode + " not in database. /addCustom to add custom modules");
        }
    }
}

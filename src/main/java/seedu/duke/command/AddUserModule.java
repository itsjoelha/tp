package seedu.duke.command;

import java.util.ArrayList;
import java.util.Map;

import seedu.duke.Ui;
import seedu.duke.user.User;
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

        if (!Ui.isValidSem(semester)) {
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

            if (!user.fulfillsModPrereq(newMod, semester)) {
                System.out.println("WARNING: " + moduleCode.toUpperCase() + " missing prerequisites");
                Ui.printDashes();
                System.out.printf("| %-78s |\n", "Prerequisites:");
                Ui.textWrapDescription(newMod.getPrerequisites());
                Ui.printDashes();
                return;
            }

            System.out.println("Module " + moduleCode.toUpperCase() + " successfully added to Semester " + semester);


        } catch (ModNotInDatabase e) {
            System.out.println(moduleCode.toUpperCase() + " not in database. /addCustom to add custom modules");
        }
    }
}

package seedu.duke.command;

import java.util.ArrayList;
import java.util.Map;

import seedu.duke.Ui;
import seedu.duke.storage.ModStorage;
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


    public boolean moduleIsValid() {
        if (!ModStorage.moduleExists(moduleCode.toUpperCase())) {
            System.out.println("Module " + moduleCode.toUpperCase() + " not in database." +
                    " Use /addCustom to add custom modules.");
            return false;
        }

        if (user.hasModule(moduleCode)) {
            System.out.println("Failed to add module " + moduleCode.toUpperCase() +
                    ". It already exists in the schedule.");
            return false;
        }

        if (semester < 1 || semester > 8) {
            System.out.println("Invalid semester. Please choose between 1 and 8.");
            return false;
        }

        return true;
    }


    @Override
    public void execute() {
        Map<Integer, ArrayList<UserMod>> semesterModules = user.getSemesterModules();
        try {
            if (moduleIsValid()) {
                UserMod newMod = new UserMod(moduleCode);
                semesterModules.putIfAbsent(semester, new ArrayList<>());

                semesterModules.get(semester).add(newMod);
                user.setSemesterModules(semesterModules);

                if (!user.fulfillsModPrereq(newMod, semester)) {
                    System.out.println("WARNING: " + moduleCode.toUpperCase() + " missing prerequisites");
                    Ui.printDashes();
                    System.out.printf("| %-78s |\n", "Prerequisites:");
                    Ui.textWrapDescription(newMod.getPrerequisites());
                    Ui.printDashes();
                }

                System.out.println("Module " + moduleCode.toUpperCase() +
                        " successfully added to Semester " + semester);
            }
        } catch (ModNotInDatabase e) {
            System.out.println("Module " + moduleCode.toUpperCase() + " not in database." +
                    " Use /addCustom to add custom modules.");
        }
    }
}

package seedu.duke.command;

import java.util.ArrayList;
import java.util.Map;

import seedu.duke.user.User;
import seedu.duke.data.UserMod;

public class AddCustomModule implements Command {
    private final String name;
    private final String moduleCode;
    private final int numMC;
    private final int semester;
    private final User user;


    public AddCustomModule(User user, String moduleCode, int semester, int numMC,
                           String name) {
        this.numMC = numMC;
        this.name = name;
        this.user = user;
        this.moduleCode = moduleCode.toUpperCase();
        this.semester = semester;
    }

    @Override
    public void execute() { // test
        if (semester < 1 || semester > 8) {
            System.out.println("Invalid semester. Please choose a number between 1 and 8.");
            return;
        }

        assert semester >= 1 && semester <= 8 : "Invalid semester";
        UserMod newMod = new UserMod(moduleCode.toUpperCase(), numMC, name);
        assert newMod != null: "newMod not instantiated yet";
        Map<Integer, ArrayList<UserMod>> semesterModules = user.getSemesterModules();
        semesterModules.putIfAbsent(semester, new ArrayList<>());

        if (user.hasModule(moduleCode)) {
            System.out.println("Failed to add module " + moduleCode.toUpperCase() + ". It already exists.");
            return; // Module already exists
        }

        semesterModules.get(semester).add(newMod);
        user.setSemesterModules(semesterModules);

        System.out.println("Module " + moduleCode.toUpperCase() + " successfully added to Semester " + semester +
                " as a Custom Module.");
    }

}

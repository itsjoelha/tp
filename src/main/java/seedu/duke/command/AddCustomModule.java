package seedu.duke.command;

import java.util.ArrayList;
import java.util.Map;

import seedu.duke.data.User;
import seedu.duke.data.UserMod;

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
    public void execute() { // test
        if (semester < 1 || semester > 8) {
            System.out.println("Invalid semester. Please choose between 1 and 8.");
            return;
        }

        UserMod newMod = new UserMod(moduleCode, numMC, name);
        Map<Integer, ArrayList<UserMod>> semesterModules = user.getSemesterModules();
        semesterModules.putIfAbsent(semester, new ArrayList<>());

        if (user.hasModule(moduleCode)) {
            System.out.println("Failed to add module " + moduleCode + ". It already exists.");
            return; // Module already exists
        }

        semesterModules.get(semester).add(newMod);
        user.setSemesterModules(semesterModules);
        user.updateGPA();

        System.out.println("Module " + moduleCode + " successfully added to semester " + semester +
                " as a Custom Module.");
    }

}

package seedu.duke.command;

import java.util.ArrayList;
import java.util.Map;

import seedu.duke.storage.ModStorage;
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

    public boolean customModuleIsValid() {
        if (user.hasModule(moduleCode)) {
            System.out.println("Failed to add module " + moduleCode.toUpperCase()
                    + ". It already exists in the schedule.");
            return false;
        }

        if (ModStorage.moduleExists(moduleCode.toUpperCase())) {
            System.out.println("Module " + moduleCode.toUpperCase() + " already exists in the database." +
                    " Use /add to add the module.");
            return false;
        }

        if (semester < 1 || semester > 8) {
            System.out.println("Invalid semester. Please choose a number between 1 and 8.");
            return false;
        }

        if (numMC < 1 || numMC > 20) {
            System.out.println("Invalid numMC. Please choose a number between 1 and 20.");
            return false;
        }

        return true;
    }

    @Override
    public void execute() { // test
        if (customModuleIsValid()) {
            assert semester >= 1 && semester <= 8 : "Invalid semester";
            assert numMC >= 1 && numMC <= 20 : "Invalid numMC";
            UserMod newMod = new UserMod(moduleCode.toUpperCase(), numMC, name);
            Map<Integer, ArrayList<UserMod>> semesterModules = user.getSemesterModules();
            semesterModules.putIfAbsent(semester, new ArrayList<>());


            semesterModules.get(semester).add(newMod);
            user.setSemesterModules(semesterModules);

            System.out.println("Module " + moduleCode.toUpperCase() + " successfully added to Semester " + semester +
                    " as a Custom Module.");
        }
    }

}

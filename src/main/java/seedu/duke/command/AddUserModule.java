package seedu.duke.command;
import static seedu.duke.Duke.moduleList;
import static seedu.duke.Duke.totalMCs;
import seedu.duke.data.UserMod;

import static seedu.duke.Duke.userModuleList;

public class AddUserModule implements Command {
    private final String moduleCode;

    public AddUserModule(String moduleCode) {
        this.moduleCode = moduleCode;
    }


    @Override
    public void execute() {
        UserMod module = new UserMod(moduleCode);
        if (module.getName() != null) {
            userModuleList.add(module);
            totalMCs += module.getNumMC();
            System.out.println("Module " + module.getCode() + " added");
            System.out.println("Total MCs:" + totalMCs);
        } else {
            System.out.println("Module " + moduleCode + " not added");
        }
    }
}


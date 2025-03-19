package seedu.duke.command;

import static seedu.duke.Duke.moduleList;
import static seedu.duke.Duke.totalMCs;

import seedu.duke.data.Mod;

public class DeleteModule implements Command {
    private final String modCode;

    public DeleteModule(String modCode) {
        this.modCode = modCode;
    }

    public void execute() {
        for (Mod m : moduleList) {
            if (m.getCode().equals(modCode)) {
                totalMCs -= m.getNumMC();
                moduleList.remove(m);
                System.out.println("Deleted " + m.getCode() + " from list");
                System.out.println("Total MCs:" + totalMCs);
                return;
            }
        }
        System.out.println("Module not found");
    }
}


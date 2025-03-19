package seedu.duke.command;
import static seedu.duke.Duke.moduleList;

import seedu.duke.data.Mod;

public class ListModules implements Command {
    public ListModules() {};
    public void execute() {
        if (moduleList.isEmpty()) {
            System.out.println("No modules in List");
        } else {
            System.out.println("Modules in List: ");
            for (Mod m : moduleList) {
                System.out.println(m.toString());
            }
        }
    }
}

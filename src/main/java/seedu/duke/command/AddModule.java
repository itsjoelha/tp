package seedu.duke.command;
import static seedu.duke.GrandRhombus.moduleList;
import static seedu.duke.GrandRhombus.totalMCs;
import seedu.duke.data.Mod;

public class AddModule implements Command {
    private final String modCode;

    public AddModule(String modCode) {
        this.modCode = modCode;
    }

    public void execute() {
        Mod module = new Mod(modCode);
        if (module.getName() != null) {
            moduleList.add(module);
            totalMCs += module.getNumMC();
            System.out.println("Module " + module.getCode() + " added");
            System.out.println("Total MCs:" + totalMCs);
        } else {
            System.out.println("Module " + modCode + " not added");
        }
    }
}

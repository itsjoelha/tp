package seedu.duke.command;

import seedu.duke.data.Mod;
import seedu.duke.errors.ModNotInDatabase;
import seedu.duke.Ui;

public class DetailModules implements Command {
    private final String modCode;

    public DetailModules(String modCode) {
        this.modCode = modCode.toUpperCase();
    }

    public void execute() {
        try {
            Mod module = new Mod(this.modCode);
            int mcValue = module.getNumMC();
            String mcFormat = (mcValue < 10) ? "%1d MCs" : "%2d MCs";
            String spaceFormat = (mcValue < 10) ? "%-58s" : "%-57s";

            Ui.printDashes();
            System.out.printf("| %-9s | " + spaceFormat + " | " + mcFormat + " |\n", module.getCode(),
                    module.getName(), mcValue);
            Ui.printDashes();

            Ui.textWrapDescription(module.getDescription());
            Ui.printDashes();

            System.out.printf("| %-78s |\n", "Preclusions:");
            Ui.textWrapDescription(module.getPreclusion());
            Ui.printDashes();

            System.out.printf("| %-78s |\n", "Prerequisites:");
            Ui.textWrapDescription(module.getPrerequisites());
            Ui.printDashes();
        } catch (ModNotInDatabase e) {
            System.out.println("Unable to retrieve module details.");
        }
    }

}

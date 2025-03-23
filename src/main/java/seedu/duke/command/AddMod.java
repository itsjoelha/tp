package seedu.duke.command;
import static seedu.duke.Duke.moduleList;
import static seedu.duke.Duke.totalMCs;

import seedu.duke.data.Mod;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AddMod implements Command {
    private final String modCode;
    private static Logger logger = Logger.getLogger(AddMod.class.getName());
    static {
        logger.setLevel(Level.ALL);
    }

    public AddMod(String modCode) {
        this.modCode = modCode;
        logger.info("Initialised AddMod Command object");
    }

    public void execute() {
        logger.info("Executing AddMod Command object");
        assert modCode != null;

        Mod module = new Mod(modCode);
        logger.info("Fetched mod from database " + modCode + ": " + module.getName());
        if (module.getName() != null) {
            assert module.getDescription() != null;
            assert module.getNumMC() > 0;
            moduleList.add(module);

            logger.info("Original NumMCs: "+ totalMCs);
            logger.info("NumMCs in mod: " + module.getNumMC());
            totalMCs += module.getNumMC();

            System.out.println("Mod " + module.getCode() + " added");
            System.out.println("Total MCs:" + totalMCs);
        } else {
            logger.warning("Mod " + module.getCode() + "not found in database");
            logger.info("Mod " + module.getCode() + " not added to Modlist");
            System.out.println("Mod " + modCode + " not added");
        }
    }
}

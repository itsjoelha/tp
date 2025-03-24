package seedu.duke.command;

import static seedu.duke.Duke.moduleList;
import static seedu.duke.Duke.totalMCs;

import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.duke.data.Mod;

public class DeleteMod implements Command {
    private static final Logger logger = Logger.getLogger(DeleteMod.class.getName());

    static {
        logger.setLevel(Level.OFF);
    }

    private final String modCode;

    public DeleteMod(String modCode) {
        this.modCode = modCode;
    }

    public void execute() {
        assert modCode != null;
        logger.info("Attempting to delete mod " + modCode);
        for (Mod m : moduleList) {
            assert !moduleList.isEmpty();
            if (m.getCode().equals(modCode)) {
                assert m.getNumMC() >= 0;
                logger.info("Mod found in moduleList");
                logger.info("NumMCs to be removed:" + m.getNumMC());
                totalMCs -= m.getNumMC();
                moduleList.remove(m);
                System.out.println("Deleted " + m.getCode() + " from list");
                System.out.println("Total MCs: " + totalMCs);
                return;
            }
        }
        logger.warning("Mod not found in moduleList");
        System.out.println("Module not found");
    }
}


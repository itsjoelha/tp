package seedu.duke.data;

import seedu.duke.errors.ErrorHandler;

public class Mod {
    private final String name;
    private final String description;
    private final int numMC;
    private final String code;

    public Mod(String name, String description, int numMC, String code) {
        this.name = name;
        this.description = description;
        this.numMC = numMC;
        this.code = code;
    }


    public Mod(String code) {
        Mod foundMod = MasterModuleList.findModuleByCode(code.toUpperCase());
        if (foundMod != null) {
            this.code = foundMod.getCode();
            this.description = foundMod.getDescription();
            this.name = foundMod.getName();
            this.numMC = foundMod.getNumMC();
        } else {
            ErrorHandler.handleModuleDoesNotExist();
            // Set fields to null
            this.code = null;
            this.description = null;
            this.name = null;
            this.numMC = 0;
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getNumMC() {
        return numMC;
    }

    public String getCode() {
        return code;
    }

    public String toString() {
        return code + " | " + name + " | " + "(" + numMC + " MCs)";
    }
}

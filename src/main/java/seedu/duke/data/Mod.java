package seedu.duke.data;

import seedu.duke.errors.ErrorHandler;

public class Mod {
    private final String name;
    private final String description;
    private final int numMC;
    private final String code;
    private final double lectureHours;
    private final double tutHours;
    private final double labHours;
    private final double projHours;
    private final double prepHours;

    public Mod(String name, String description, int numMC, String code,
               double lectureHours, double tutHours, double labHours, double projHours, double prepHours) {
        this.name = name;
        this.description = description;
        this.numMC = numMC;
        this.code = code;
        this.lectureHours = lectureHours;
        this.tutHours = tutHours;
        this.labHours = labHours;
        this.projHours = projHours;
        this.prepHours = prepHours;
    }

    public Mod(String code) {
        Mod foundMod = MasterModuleList.findModuleByCode(code.toUpperCase());
        if (foundMod != null) {
            this.code = foundMod.getCode();
            this.description = foundMod.getDescription();
            this.name = foundMod.getName();
            this.numMC = foundMod.getNumMC();
            this.lectureHours = foundMod.getLectureHours();
            this.tutHours = foundMod.getTutHours();
            this.labHours = foundMod.getLabHours();
            this.projHours = foundMod.getProjHours();
            this.prepHours = foundMod.getPrepHours();
        } else {
            ErrorHandler.handleModuleDoesNotExist();
            // Set fields to null
            this.code = null;
            this.description = null;
            this.name = null;
            this.numMC = 0;
            this.lectureHours = 0;
            this.tutHours = 0;
            this.labHours = 0;
            this.projHours = 0;
            this.prepHours = 0;
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

    public double getLectureHours() { return lectureHours; }
    public double getTutHours() { return tutHours; }
    public double getLabHours() { return labHours; }
    public double getProjHours() { return projHours; }
    public double getPrepHours() { return prepHours; }

    public String toString() {
        return code + " | " + name + " | " + "(" + numMC + " MCs)";
    }
}

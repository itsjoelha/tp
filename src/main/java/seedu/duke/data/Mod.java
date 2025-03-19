package seedu.duke.data;

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
        this.name = "test name";
        this.description = "description 1";
        this.numMC = 4;
        this.code = code;
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
        return code + ": " + description + " (" + numMC + " MCs)" ;
    }
}

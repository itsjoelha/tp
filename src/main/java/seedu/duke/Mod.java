package seedu.duke;

public class Mod {
    private final String name;
    private final String description;
    private final int numMC;
    private final String code;

    /*public Mod(String name, String description, int numMC, String code) {
        this.name = name;
        this.description = description;
        this.numMC = numMC;
        this.code = code;
    }*/

    public Mod(String code) {
        Data datafile = new Data("./data/mod_data.txt");
        String[] parts = datafile.searchMod(code);
        this.name = parts[1];
        this.description = parts[3];
        this.numMC = Integer.parseInt(parts[2]);
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

    public void textWrapDescription() { // prints description to fit into the output window
        String[] words = description.split(" ");
        int wrapLength = 80;

        StringBuilder currentLine = new StringBuilder();
        for (String word : words) {
            if (currentLine.length() + word.length() + 1 > wrapLength) {
                System.out.println(currentLine);
                currentLine = new StringBuilder(word);
                currentLine.append(" ");
            } else {
                currentLine.append(word);
                currentLine.append(" ");
            }
        }
        if (!currentLine.isEmpty()) {
            System.out.println(currentLine);
        }

    }

    public String toString() {
        return code + " | " + name + " (" + numMC + " MCs)" + ":\n ";
    }
}
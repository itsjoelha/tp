package seedu.duke.command;
import seedu.duke.data.Mod;

public class DetailModules implements Command {
    private final String modCode;

    public DetailModules(String modCode) {
        this.modCode = modCode.toUpperCase();
    }

    public void textWrapDescription(String description) { // prints description to fit into the output window
        int wrapLength = 77;
        StringBuilder currentLine = new StringBuilder();
        String[] words = description.split(" ");

        for (String word : words) {
            // Handle words longer than wrapLength
            while (word.length() > wrapLength) {
                int breakIndex = word.lastIndexOf("/", wrapLength);
                if (breakIndex == -1) {
                    // No slash found, force split at wrapLength
                    System.out.printf("| %-78s |\n", word.substring(0, wrapLength));
                    word = word.substring(wrapLength);
                } else {
                    // Split at last slash within wrapLength
                    System.out.printf("| %-78s |\n", word.substring(0, breakIndex + 1));
                    word = word.substring(breakIndex + 1);
                }
            }

            // Move to a new line if adding word exceeds wrapLength
            if (currentLine.length() + word.length() + 1 > wrapLength) {
                System.out.printf("| %-78s |\n", currentLine.toString().trim());
                currentLine.setLength(0);
            }

            if (currentLine.length() == 0) {
                currentLine.append(" ");
            }
            currentLine.append(word);
        }

        // Print remaining line
        if (currentLine.length() == 0) {
            System.out.printf("| %-78s |\n", currentLine.toString().trim());
        }
    }

    public void execute() {
        Mod module = new Mod(this.modCode);
        if (module.getCode() != null) {
            int mcValue = module.getNumMC();
            String mcFormat = (mcValue < 10) ? "%1d MCs" : "%2d MCs";
            String spaceFormat = (mcValue < 10) ? "%-58s" : "%-57s";

            System.out.println("+--------------------------------------------------------------------------------+");
            System.out.printf("| %-9s | " + spaceFormat + " | " + mcFormat + " |\n", module.getCode(),
                    module.getName(), mcValue);
            System.out.println("+--------------------------------------------------------------------------------+");

            textWrapDescription(module.getDescription());
            System.out.println("+--------------------------------------------------------------------------------+");

            System.out.printf("| %-78s |\n", "Preclusions:");
            textWrapDescription(module.getPreclusion());
            System.out.println("+--------------------------------------------------------------------------------+");

            System.out.printf("| %-78s |\n", "Prerequisites:");
            textWrapDescription(module.getPrerequisites());
            System.out.println("+--------------------------------------------------------------------------------+");
        } else {
            System.out.println("Unable to retrieve module details.");
        }
    }
}

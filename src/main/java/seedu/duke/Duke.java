package seedu.duke;

import java.util.ArrayList;
import java.util.Scanner;

import seedu.duke.data.Mod;
import seedu.duke.command.*;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static ArrayList<Mod> moduleList = new ArrayList<>();
    public static int totalMCs = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Grand Rhombus");
        Scanner in = new Scanner(System.in);
        String modCode = in.nextLine();
        while (!modCode.equals("die")) {
            Command cmd = new AddModule(modCode);
            cmd.execute();
            cmd = new ListModules();
            cmd.execute();
            modCode = in.nextLine();
        }

    }
}

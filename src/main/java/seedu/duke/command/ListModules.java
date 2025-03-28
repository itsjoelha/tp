package seedu.duke.command;

import seedu.duke.data.UserMod;
import static seedu.duke.Duke.currentUser;

public class ListModules implements Command {
    public ListModules() {};


    @Override
    public void execute() {
        // Loop through semesters 1 - 8
        int totalSemesters = 8;
        for (int semester = 1; semester <= totalSemesters; semester++) {
            // Print Semester header
            System.out.print("=============== SEMESTER " + semester + " ===============\n");

            // Check if there are modules for the current semester
            if (currentUser.getSemesterModules().containsKey(semester)) {
                // Print all modules in that semester
                boolean hasModules = false;
                for (UserMod mod : currentUser.getSemesterModules().get(semester)) {
                    mod.print();
                    hasModules = true;
                }
                if (!hasModules) {
                    System.out.print("-------------------NULL-----------------\n");
                }
            } else {
                System.out.print("-------------------NULL-----------------\n");
            }
        }
    }
}

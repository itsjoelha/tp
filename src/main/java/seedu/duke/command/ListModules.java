package seedu.duke.command;

import seedu.duke.data.User;
import seedu.duke.data.UserMod;

public class ListModules implements Command {
    private final User user;
    private final int sem;

    public ListModules(User user) {
        this.user = user;
        this.sem = 0;
    }
    public ListModules(User user, String semester) {
        this.user = user;
        this.sem = Integer.parseInt(semester);
    }

    public void execute(int sem) {
        // Print Semester header
        System.out.print("=============== SEMESTER " + sem + " ===============\n");

        // Check if there are modules for the current semester
        if (user.getSemesterModules().containsKey(sem)) {
            // Print all modules in that semester.
            boolean hasModules = false;
            for (UserMod mod : user.getSemesterModules().get(sem)) {
                if (user.fulfillsModPrereq(mod, sem)) {
                    System.out.print("[O] ");
                } else {
                    System.out.print("[X] ");
                }
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


    @Override
    public void execute() {
        // Check if the user has specified a semester
        if (sem != 0) {
            execute(sem);
            return;
        }
        // Loop through semesters 1 - 8
        int totalSemesters = 8;
        for (int semester = 1; semester <= totalSemesters; semester++) {
            // Print Semester header
            System.out.print("=============== SEMESTER " + semester + " ===============\n");

            // Check if there are modules for the current semester
            if (user.getSemesterModules().containsKey(semester)) {
                // Print all modules in that semester.
                boolean hasModules = false;
                for (UserMod mod : user.getSemesterModules().get(semester)) {
                    if (user.fulfillsModPrereq(mod, semester)) {
                        System.out.print("[O] ");
                    } else {
                        System.out.print("[X] ");
                    }
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
        user.checkAllPrereqs();
    }
}

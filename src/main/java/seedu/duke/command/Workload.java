/**
 * The Workload class implements the Command interface and is responsible for displaying
 * the workload information of modules taken by the user.
 *
 * This class can display workload for all modules or for modules in a specific semester.
 * The workload includes lecture hours, tutorial hours, lab hours, project hours, and
 * preparation hours for each module.
 */
package seedu.duke.command;

import seedu.duke.data.Mod;
import seedu.duke.user.User;

public class Workload implements Command {
    private final User currentUser;
    private final int sem;

    /**
     * Constructs a Workload object that displays workload for all semesters.
     *
     * @param user The user whose module workload will be displayed
     */
    public Workload(User user) {
        this.currentUser = user;
        this.sem = 0;
    }

    /**
     * Constructs a Workload object that displays workload for a specific semester.
     *
     * @param user The user whose module workload will be displayed
     * @param semester The specific semester to display workload for (as a String)
     */
    public Workload(User user, int semester) {
        this.currentUser = user;
        this.sem = semester;
    }

    /**
     * Executes the workload command for a specific semester.
     * Displays a table of modules and their workload information for the specified semester.
     *
     * @param sem The semester number to display workload for
     */
    public void execute(int sem) {
        if (sem < 1 || sem > 8) {
            System.out.println("Invalid semester. Please choose a number between 1 and 8.");
            return;
        }

        if (currentUser.getSemesterModules().containsKey(sem)) {
            for (Mod m : currentUser.getSemesterModules().get(sem)) {
                System.out.printf("| %-9s | %-3d | %-3d | %-11.1f | %-7.1f | %-7.1f | %-8.1f | %-8.1f |\n",
                        m.getCode(), sem, m.getNumMC(), m.getLectureHours(), m.getTutHours(),
                        m.getLabHours(), m.getProjHours(), m.getPrepHours());
            }

            System.out.println("+-----------+-----+-----+-------------+---------+---------+----------+----------+");
        }
    }

    /**
     * Executes the workload command.
     * Displays workload information for all modules or for a specific semester if specified.
     * The workload includes lecture hours, tutorial hours, lab hours, project hours,
     * and preparation hours for each module in a formatted table.
     */
    @Override
    public void execute() {
        if (sem < 1 || sem > 8) {
            System.out.println("Invalid semester. Please choose a number between 1 and 8.");
            return;
        }

        if (currentUser.getAllModules().isEmpty()) {
            System.out.println("No modules in List");
            return;
        }
        
        System.out.println("+-----------+-----+-----+-------------+---------+---------+----------+----------+");
        System.out.println("| Code      | Sem | MCs | Lecture Hrs | Tut Hrs | Lab Hrs | Proj Hrs | Prep Hrs |");
        System.out.println("+-----------+-----+-----+-------------+---------+---------+----------+----------+");

        if (sem != 0) {
            execute(sem);
            return;
        }

        for (Mod m : currentUser.getAllModules()) {
            // Get the semester for each module
            int moduleSem = getSemesterForModule(m);
            System.out.printf("| %-9s | %-3d | %-3d | %-11.1f | %-7.1f | %-7.1f | %-8.1f | %-8.1f |\n",
                    m.getCode(), moduleSem, m.getNumMC(), m.getLectureHours(), m.getTutHours(),
                    m.getLabHours(), m.getProjHours(), m.getPrepHours());
        }

        System.out.println("+-----------+-----+-----+-------------+---------+---------+----------+----------+");
    }

    /**
     * Helper method to determine which semester a module belongs to.
     *
     * @param module The module to find the semester for
     * @return int The semester number the module belongs to, or 0 if not found
     */
    private int getSemesterForModule(Mod module) {
        for (int semester : currentUser.getSemesterModules().keySet()) {
            if (currentUser.getSemesterModules().get(semester).contains(module)) {
                return semester;
            }
        }
        return 0; // Default if not found
    }
}

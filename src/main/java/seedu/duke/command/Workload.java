package seedu.duke.command;

import seedu.duke.data.Mod;
import seedu.duke.data.User;

public class Workload implements Command {
    private final User currentUser;
    private final int sem;

    public Workload(User user) {
        this.currentUser = user;
        this.sem = 0;
    }

    public Workload(User user, String semester) {
        this.currentUser = user;
        this.sem = Integer.parseInt(semester);
    }

    public void execute(int sem) {

        if (currentUser.getSemesterModules().containsKey(sem)) {
            for (Mod m : currentUser.getSemesterModules().get(sem)) {
                System.out.printf("| %-9s | %-3d | %-3d | %-11.1f | %-7.1f | %-7.1f | %-8.1f | %-8.1f |\n",
                        m.getCode(), sem, m.getNumMC(), m.getLectureHours(), m.getTutHours(),
                        m.getLabHours(), m.getProjHours(), m.getPrepHours());
            }

            System.out.println("+-----------+-----+-----+-------------+---------+---------+----------+----------+");
        }
    }

    @Override
    public void execute() {
      
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

    // Helper method to get semester for a module
    private int getSemesterForModule(Mod module) {
        for (int semester : currentUser.getSemesterModules().keySet()) {
            if (currentUser.getSemesterModules().get(semester).contains(module)) {
                return semester;
            }
        }
        return 0; // Default if not found
    }
}
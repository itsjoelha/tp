package seedu.duke.command;

import static seedu.duke.Duke.currentUser;
import seedu.duke.data.Mod;

public class Workload implements Command {
    public Workload() {}

    public void execute() {
        if (currentUser.getAllModules().isEmpty()) {
            System.out.println("No modules in List");
            return;
        }

        System.out.println("+-----------+-----+-------------+---------+---------+----------+----------+");
        System.out.println("| Code      | MCs | Lecture Hrs | Tut Hrs | Lab Hrs | Proj Hrs | Prep Hrs |");
        System.out.println("+-----------+-----+-------------+---------+---------+----------+----------+");

        for (Mod m : currentUser.getAllModules()) {
            System.out.printf("| %-9s | %-3d | %-11.1f | %-7.1f | %-7.1f | %-8.1f | %-8.1f |\n",
                    m.getCode(), m.getNumMC(), m.getLectureHours(), m.getTutHours(),
                    m.getLabHours(), m.getProjHours(), m.getPrepHours());
        }

        System.out.println("+-----------+-----+-------------+---------+---------+----------+----------+");
    }
}

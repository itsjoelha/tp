package seedu.duke.command;


import java.util.ArrayList;

import seedu.duke.data.Mod;
import seedu.duke.data.User;
import seedu.duke.data.UserMod;

public class Workload implements Command {
    private final User user;
    
    public Workload(User user) {
        this.user = user;
    }

    public void execute() {
        ArrayList<UserMod> moduleList = user.getAllModules();
        if (moduleList.isEmpty()) {
            System.out.println("No modules in List");
            return;
        }

        System.out.println("+-----------+-----+-------------+---------+---------+----------+----------+");
        System.out.println("| Code      | MCs | Lecture Hrs | Tut Hrs | Lab Hrs | Proj Hrs | Prep Hrs |");
        System.out.println("+-----------+-----+-------------+---------+---------+----------+----------+");

        for (Mod m : moduleList) {
            System.out.printf("| %-9s | %-3d | %-11.1f | %-7.1f | %-7.1f | %-8.1f | %-8.1f |\n",
                    m.getCode(), m.getNumMC(), m.getLectureHours(), m.getTutHours(),
                    m.getLabHours(), m.getProjHours(), m.getPrepHours());
        }

        System.out.println("+-----------+-----+-------------+---------+---------+----------+----------+");
    }
}

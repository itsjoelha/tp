package seedu.duke.command;

import static seedu.duke.data.GradModuleList.YEAR1SEM1MODULES;
import static seedu.duke.data.GradModuleList.YEAR1SEM2MODULES;
import static seedu.duke.data.GradModuleList.YEAR2SEM1MODULES;
import static seedu.duke.data.GradModuleList.YEAR2SEM2MODULES;
import static seedu.duke.data.GradModuleList.YEAR3SEM1MODULES;
import static seedu.duke.data.GradModuleList.YEAR3SEM2MODULES;
import static seedu.duke.data.GradModuleList.YEAR4SEM1MODULES;
import static seedu.duke.data.GradModuleList.YEAR4SEM2MODULES;

import java.util.List;

import seedu.duke.data.Mod;


public class RecommendedSchedule implements Command {

    public void execute() {
        printSemester("Year 1 Semester 1", YEAR1SEM1MODULES);
        printSemester("Year 1 Semester 2", YEAR1SEM2MODULES);
        printSemester("Year 2 Semester 1", YEAR2SEM1MODULES);
        printSemester("Year 2 Semester 2", YEAR2SEM2MODULES);
        printSemester("Year 3 Semester 1", YEAR3SEM1MODULES);
        printSemester("Year 3 Semester 2", YEAR3SEM2MODULES);
        printSemester("Year 4 Semester 1", YEAR4SEM1MODULES);
        printSemester("Year 4 Semester 2", YEAR4SEM2MODULES);
    }

    private void printSemester(String title, List<Mod> semesterModules) {
        System.out.println("\n==== " + title + " ====");
        if (semesterModules.isEmpty()) {
            System.out.println("No modules found.");
            return;
        }
        for (Mod m : semesterModules) {
            System.out.println(m.getCode() + " - " + m.getName());
        }
    }

}

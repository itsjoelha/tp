package seedu.duke.command;

import seedu.duke.data.Mod;

import java.util.List;

//import static seedu.duke.Duke.moduleList; // to implement strikethrough if already in list
import static seedu.duke.data.GradModuleList.Year1Sem1Modules;
import static seedu.duke.data.GradModuleList.Year1Sem2Modules;
import static seedu.duke.data.GradModuleList.Year2Sem1Modules;
import static seedu.duke.data.GradModuleList.Year2Sem2Modules;
import static seedu.duke.data.GradModuleList.Year3Sem1Modules;
import static seedu.duke.data.GradModuleList.Year3Sem2Modules;
import static seedu.duke.data.GradModuleList.Year4Sem1Modules;
import static seedu.duke.data.GradModuleList.Year4Sem2Modules;



public class RecommendedSchedule implements Command {

    public void execute() {
        printSemester("Year 1 Semester 1", Year1Sem1Modules);
        printSemester("Year 1 Semester 2", Year1Sem2Modules);
        printSemester("Year 2 Semester 1", Year2Sem1Modules);
        printSemester("Year 2 Semester 2", Year2Sem2Modules);
        printSemester("Year 3 Semester 1", Year3Sem1Modules);
        printSemester("Year 3 Semester 2", Year3Sem2Modules);
        printSemester("Year 4 Semester 1", Year4Sem1Modules);
        printSemester("Year 4 Semester 2", Year4Sem2Modules);
    }

    private void printSemester(String title, List<Mod> semesterModules) {
        System.out.println("\n==== " + title + " ====");
        if (semesterModules.isEmpty()) {
            System.out.println("No modules found.");
            return;
        }
        for (Mod m : semesterModules) {
            System.out.println( m.getCode() + " - " + m.getName() );
        }
    }

}

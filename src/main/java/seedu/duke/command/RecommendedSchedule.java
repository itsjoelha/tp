package seedu.duke.command;

import static seedu.duke.storage.GradModuleList.YEAR1SEM1MODULES;
import static seedu.duke.storage.GradModuleList.YEAR1SEM2MODULES;
import static seedu.duke.storage.GradModuleList.YEAR2SEM1MODULES;
import static seedu.duke.storage.GradModuleList.YEAR2SEM2MODULES;
import static seedu.duke.storage.GradModuleList.YEAR3SEM1MODULES;
import static seedu.duke.storage.GradModuleList.YEAR3SEM2MODULES;
import static seedu.duke.storage.GradModuleList.YEAR4SEM1MODULES;
import static seedu.duke.storage.GradModuleList.YEAR4SEM2MODULES;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.duke.data.Mod;
import seedu.duke.errors.ModNotInDatabase;
import seedu.duke.storage.ModStorage;


public class RecommendedSchedule implements Command {
    private final String scheduleType;
    private final int TABLE_WIDTH = 70; // Total table width including borders

    public RecommendedSchedule(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public void execute() {
        if (scheduleType.equals("poly")) {
            executePolySchedule();
        } else {
            executeJcSchedule();
        }
    }

    private void executeJcSchedule() {
        // Define column header format for consistency
        String columnHeaderSeparator = "+---------------------------------------------------------------+";
        String semesterSeparator = "+------+-----+------------------+------+-----+------------------+";

        // Print top border using same separator as column headers
        System.out.println(columnHeaderSeparator);

        // Left align the title with exact width to match column format
        String title = "JC Schedule";
        System.out.println("| " + title + " ".repeat(semesterSeparator.length() -
                title.length() - 4) + " |");

        // Print separator after title
        System.out.println(semesterSeparator);

        // Header row
        System.out.println("| Year | Sem | Module Code      | Year | Sem | Module Code      |");
        System.out.println(semesterSeparator);

        // Print years
        printSemesterPair(1, 1, YEAR1SEM1MODULES, 1, 2, YEAR1SEM2MODULES);
        printSemesterPair(2, 1, YEAR2SEM1MODULES, 2, 2, YEAR2SEM2MODULES);
        printSemesterPair(3, 1, YEAR3SEM1MODULES, 3, 2, YEAR3SEM2MODULES);
        printSemesterPair(4, 1, YEAR4SEM1MODULES, 4, 2, YEAR4SEM2MODULES, false);

        System.out.println(semesterSeparator);
    }

    private void executePolySchedule() {
        try {
            // Year 1 Sem 1
            List<Mod> poly1Sem1 = new ArrayList<>(Arrays.asList(
                    ModStorage.findModuleByCode("CG1111A"),
                    ModStorage.findModuleByCode("CS1010"),
                    new Mod("Introductory Mathematics", "", 4, "MA1301",
                            3, 1, 0, 0, 6,
                            "Unconfirmed preclusions", "Unconfirmed prerequisites",
                            null, true),
                    new Mod("English for Academic Purposes", "", 4, "ES1103",
                            0, 4, 0, 3, 3,
                            "Unconfirmed preclusions", "Unconfirmed prerequisites",
                            null, true),
                    new Mod("Cultures and Connections", "", 4, "GEC1XXX",
                            0, 0, 0, 0, 0,
                            "Unconfirmed preclusions", "Unconfirmed prerequisites",
                            null, true)
            ));

            // Year 1 Sem 2
            List<Mod> poly1Sem2 = new ArrayList<>(Arrays.asList(
                    ModStorage.findModuleByCode("CG2111A"),
                    ModStorage.findModuleByCode("CS2040C"),
                    ModStorage.findModuleByCode("EE2026"),
                    ModStorage.findModuleByCode("GEA1000"),
                    ModStorage.findModuleByCode("MA1508E")
            ));

            // Year 2 Sem 1
            List<Mod> poly2Sem1 = new ArrayList<>(Arrays.asList(
                    ModStorage.findModuleByCode("CG2027"),
                    ModStorage.findModuleByCode("CG2028"),
                    ModStorage.findModuleByCode("CS2113"),
                    ModStorage.findModuleByCode("IE2141"),
                    ModStorage.findModuleByCode("ES2631"),
                    ModStorage.findModuleByCode("MA1511"),
                    ModStorage.findModuleByCode("MA1512")
            ));

            // Year 2 Sem 2
            List<Mod> poly2Sem2 = new ArrayList<>(Arrays.asList(
                    ModStorage.findModuleByCode("CG2023"),
                    ModStorage.findModuleByCode("CG2271"),
                    ModStorage.findModuleByCode("PF1101"),
                    ModStorage.findModuleByCode("EE2211"),
                    ModStorage.findModuleByCode("CDE2501")
            ));

            // Year 3 Sem 1
            List<Mod> poly3Sem1 = new ArrayList<>(Arrays.asList(
                    ModStorage.findModuleByCode("CG4002"),
                    ModStorage.findModuleByCode("CS1231"),
                    new Mod("Communities and Engagement", "", 4, "GEN1XXX",
                            0, 0, 0, 0, 0,
                            "Unconfirmed preclusions", "Unconfirmed prerequisites",
                            null, true),
                    generateUE(),
                    ModStorage.findModuleByCode("EG2401A")
            ));

            // Year 3 Sem 2
            List<Mod> poly3Sem2 = new ArrayList<>(Arrays.asList(
                    ModStorage.findModuleByCode("CDE2000"),
                    new Mod("Singapore Studies", "", 4, "GESS1XXX",
                            0, 0, 0, 0, 0,
                            "Unconfirmed preclusions", "Unconfirmed prerequisites",
                            null, true),
                    ModStorage.findModuleByCode("EE4204"),
                    generateUE(),
                    generateUE()
            ));

            // Define column header format for consistency
            String columnHeaderSeparator = "+---------------------------------------------------------------+";
            String semesterSeparator = "+------+-----+------------------+------+-----+------------------+";

            // Print top border using same separator as column headers
            System.out.println(columnHeaderSeparator);

            // Left align the title
            String title = "Poly Schedule";
            System.out.println("| " + title + " ".repeat(semesterSeparator.length()
                    - title.length() - 4) + " |");

            // Print separator after title
            System.out.println(semesterSeparator);

            // Header row
            System.out.println("| Year | Sem | Module Code      | Year | Sem | Module Code      |");
            System.out.println(semesterSeparator);

            // Print years
            printSemesterPair(1, 1, poly1Sem1, 1, 2, poly1Sem2);
            printSemesterPair(2, 1, poly2Sem1, 2, 2, poly2Sem2);
            printSemesterPair(3, 1, poly3Sem1, 3, 2, poly3Sem2, false);

            System.out.println(semesterSeparator);

        } catch (ModNotInDatabase e) {
            System.out.println("Fail to load Poly Module List");
            throw new RuntimeException(e);
        }
    }

    // Overloaded method with a printSeparator flag
    private void printSemesterPair(int year1, int sem1, List<Mod> modules1, int year2,
                                   int sem2, List<Mod> modules2) {
        printSemesterPair(year1, sem1, modules1, year2, sem2, modules2, true);
    }

    private void printSemesterPair(int year1, int sem1, List<Mod> modules1, int year2,
                                   int sem2, List<Mod> modules2,
                                   boolean printSeparator) {
        // Get the maximum number of modules between the two semesters
        int maxModules = Math.max(modules1.size(), modules2.size());

        // Print each module row
        for (int i = 0; i < maxModules; i++) {
            String moduleCode1 = i < modules1.size() ? modules1.get(i).getCode() : "";
            String moduleCode2 = i < modules2.size() ? modules2.get(i).getCode() : "";

            // For the first row, include year and semester
            if (i == 0) {
                System.out.printf("| %-4d | %-3d | %-16s | %-4d | %-3d | %-16s |\n",
                        year1, sem1, moduleCode1, year2, sem2, moduleCode2);
            } else {
                System.out.printf("|      |     | %-16s |      |     | %-16s |\n",
                        moduleCode1, moduleCode2);
            }
        }

        // Add a separator line after each year pair, except for the last pair
        if (printSeparator) {
            System.out.println("+------+-----+------------------+------+-----+------------------+");
        }
    }

    private Mod generateUE() {
        return new Mod("Unrestricted Elective", "", 4, "UE",
                0, 0, 0, 0, 0,
                "Unconfirmed preclusions",
                "Unconfirmed prerequisites", null, false);
    }
}

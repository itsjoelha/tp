package seedu.duke.command;

import static seedu.duke.data.GradModuleList.YEAR1SEM1MODULES;
import static seedu.duke.data.GradModuleList.YEAR1SEM2MODULES;
import static seedu.duke.data.GradModuleList.YEAR2SEM1MODULES;
import static seedu.duke.data.GradModuleList.YEAR2SEM2MODULES;
import static seedu.duke.data.GradModuleList.YEAR3SEM1MODULES;
import static seedu.duke.data.GradModuleList.YEAR3SEM2MODULES;
import static seedu.duke.data.GradModuleList.YEAR4SEM1MODULES;
import static seedu.duke.data.GradModuleList.YEAR4SEM2MODULES;

import java.util.ArrayList;
import java.util.List;

import seedu.duke.data.Mod;
import seedu.duke.data.User;


public class ViewGradRequirements implements Command {
    private final User user;

    public ViewGradRequirements(User user) {
        this.user = user;
    }

    public void execute() {
        System.out.println("+----------------------------------------------------------------------------------------" +
                "-------+");
        System.out.println("| Viewing Graduation Requirements                                                               |");
        System.out.println("+----------------------------------------------------------------------------------------" +
                "-------+");

        int totalMCs = user.getTotalMCs();
        System.out.println("| Current MCs: " + totalMCs + "                                                         " +
                "                       |");

        if (totalMCs >= 160) {
            System.out.println("| You have sufficient MCs to graduate!                                          " +
                    "     |");
        } else {
            System.out.println("| Missing MCs: " + (160 - totalMCs) + "                                      " +
                    "                                        |");
        }

        System.out.println("+------------------------------------------------------------------------------" +
                "-----------------+");
        System.out.println("| Modules Missing                              " +
                "                                                 |");

        List<Mod> missingModules = getMissingModules();

        if (missingModules.isEmpty()) {
            System.out.println("| You have completed all required modules!                                                 |");
            System.out.println("+-----------+-----------------------------------+-----------+----------------------------------+");
        } else {
            // Display missing modules in a table format with two columns
            System.out.println("+-----------+-----------------------------------+-----------+-----------------------------------+");
            System.out.println("| Mod Code  | Mod Name                          | Mod Code  | Mod Name                          |");
            System.out.println("+-----------+-----------------------------------+-----------+-----------------------------------+");

            for (int i = 0; i < missingModules.size(); i += 2) {
                String code1 = missingModules.get(i).getCode();
                String name1 = missingModules.get(i).getName();

                if (i + 1 < missingModules.size()) {
                    // Two modules per row
                    String code2 = missingModules.get(i + 1).getCode();
                    String name2 = missingModules.get(i + 1).getName();

                    // Truncate long module names
                    String truncatedName1 = name1.length() > 33 ? name1.substring(0, 30) + "..." : name1;
                    String truncatedName2 = name2.length() > 33 ? name2.substring(0, 30) + "..." : name2;

                    System.out.printf("| %-9s | %-33s | %-9s | %-33s |\n",
                            code1, truncatedName1, code2, truncatedName2);
                } else {
                    // Last row with only one module
                    // Truncate long module name
                    String truncatedName1 = name1.length() > 33 ? name1.substring(0, 30) + "..." : name1;

                    System.out.printf("| %-9s | %-33s | %-9s | %-33s |\n",
                            code1, truncatedName1, "", "");
                }
            }

            System.out.println("+-----------+-----------------------------------+-----------+---------------" +
                    "--------------------+");
        }
    }

    private List<Mod> getMissingModules() {
        List<Mod> allGradModules = new ArrayList<>();
        allGradModules.addAll(YEAR1SEM1MODULES);
        allGradModules.addAll(YEAR1SEM2MODULES);
        allGradModules.addAll(YEAR2SEM1MODULES);
        allGradModules.addAll(YEAR2SEM2MODULES);
        allGradModules.addAll(YEAR3SEM1MODULES);
        allGradModules.addAll(YEAR3SEM2MODULES);
        allGradModules.addAll(YEAR4SEM1MODULES);
        allGradModules.addAll(YEAR4SEM2MODULES);

        List<Mod> missingModules = new ArrayList<>();
        for (Mod m : allGradModules) {
            if (!user.hasModule(m.getCode())) {
                missingModules.add(m);
            }
        }
        return missingModules;
    }
}
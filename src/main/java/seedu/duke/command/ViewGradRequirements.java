package seedu.duke.command;

import seedu.duke.data.Mod;
import java.util.List;
import java.util.ArrayList;

import static seedu.duke.Duke.moduleList;
import static seedu.duke.Duke.totalMCs;
import static seedu.duke.data.GradModuleList.Year1Sem1Modules;
import static seedu.duke.data.GradModuleList.Year1Sem2Modules;
import static seedu.duke.data.GradModuleList.Year2Sem1Modules;
import static seedu.duke.data.GradModuleList.Year2Sem2Modules;
import static seedu.duke.data.GradModuleList.Year3Sem1Modules;
import static seedu.duke.data.GradModuleList.Year3Sem2Modules;
import static seedu.duke.data.GradModuleList.Year4Sem1Modules;
import static seedu.duke.data.GradModuleList.Year4Sem2Modules;





public class ViewGradRequirements implements Command {
    public void execute() {
        System.out.println("=== Viewing Graduation Requirements ===");
        System.out.println("Current MCs: " + totalMCs);

        if (totalMCs >= 160) {
            System.out.println("✅ You have sufficient MCs to graduate!");
        } else {
            System.out.println("⚠️ Missing MCs: " + (160 - totalMCs));
        }

        System.out.println("\n=== Modules Missing ===");
        List<Mod> missingModules = getMissingModules();

        if (missingModules.isEmpty()) {
            System.out.println("🎉 You have completed all required modules!");
        } else {
            for (Mod m : missingModules) {
                System.out.println("❌ " + m.getCode() + " - " + m.getName());
            }
        }
    }

    private List<Mod> getMissingModules() {
        List<Mod> allGradModules = new ArrayList<>();
        allGradModules.addAll(Year1Sem1Modules);
        allGradModules.addAll(Year1Sem2Modules);
        allGradModules.addAll(Year2Sem1Modules);
        allGradModules.addAll(Year2Sem2Modules);
        allGradModules.addAll(Year3Sem1Modules);
        allGradModules.addAll(Year3Sem2Modules);
        allGradModules.addAll(Year4Sem1Modules);
        allGradModules.addAll(Year4Sem2Modules);

        List<Mod> missingModules = new ArrayList<>();
        for (Mod m : allGradModules) {
            if (!hasModule(m)) {
                missingModules.add(m);
            }
        }
        return missingModules;
    }

    private boolean hasModule(Mod module) {
        for (Mod m : moduleList) {
            if (m.getCode().equals(module.getCode())) {
                return true;
            }
        }
        return false;
    }
}

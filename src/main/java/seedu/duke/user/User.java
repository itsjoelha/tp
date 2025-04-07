package seedu.duke.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import seedu.duke.Ui;
import seedu.duke.data.Grade;
import seedu.duke.data.Prereq;
import seedu.duke.data.UserMod;

public class User {
    private String name;
    private EducationLevel education;
    private double gpa;
    private int currentSemester;
    private Map<Integer, ArrayList<UserMod>> semesterModules;
    private Boolean isExemptedMA1301 = null;
    private Boolean isExemptedPC1101 = null;
    private Boolean isExemptedEnglish = null;

    public User() {
        // Default constructor initializes with empty values
        this.name = "";
        this.education = null;
        this.gpa = 0.0;
        this.currentSemester = -1;
        this.semesterModules = new HashMap<>();
    }

    public User(String name, EducationLevel education, int currentSemester) {
        this.name = name;
        this.education = education;
        this.currentSemester = currentSemester;
        this.gpa = 0.0;
        this.semesterModules = new HashMap<>();
    }

    public Map<Integer, ArrayList<UserMod>> getSemesterModules() {
        return semesterModules;
    }

    public void setSemesterModules(Map<Integer, ArrayList<UserMod>> semesterModules) {
        this.semesterModules = semesterModules;
    }

    public double getGPA() {
        updateGPA();
        return gpa;
    }

    public int getTotalMCs() {
        int totalMCs = 0;
        for (ArrayList<UserMod> mods : semesterModules.values()) {
            for (UserMod mod : mods) {
                int modMC = mod.getNumMC();
                totalMCs += modMC;
            }
        }
        return totalMCs;
    }

    public int getGradedMCs() {
        int totalMCs = 0;
        for (ArrayList<UserMod> mods : semesterModules.values()) {
            for (UserMod mod : mods) {
                if (mod.getGrade() != null && !mod.isSU()) {
                    int modMC = mod.getNumMC();
                    totalMCs += modMC;
                }
            }
        }
        return totalMCs;
    }

    public void updateGPA() {
        int totalMCs = getGradedMCs();
        if (totalMCs == 0) {
            this.gpa = 0.0;
            return;
        }

        double totalGradePoints = 0;
        for (ArrayList<UserMod> mods : semesterModules.values()) {
            for (UserMod mod : mods) {
                Grade moduleGrade = mod.getGrade();
                int modMC = mod.getNumMC();

                if (moduleGrade != null && !mod.isSU()) {
                    totalGradePoints += moduleGrade.getGradePoint() * modMC;
                }
            }
        }

        //calculates GPA to 2dp
        this.gpa = Math.floor(totalGradePoints / totalMCs * 100) / 100;
    }


    public boolean hasModule(String code) {
        return getModule(code) != null;
    }

    public void clearModules() {
        semesterModules.clear();
    }

    public UserMod getModule(String code) {
        for (ArrayList<UserMod> mods : semesterModules.values()) {
            for (UserMod mod : mods) {
                if (mod.getCode() != null && mod.getCode().equalsIgnoreCase(code)) {
                    return mod;
                }
            }
        }
        return null;
    }


    public void checkAllPrereqs() {
        int semester = 0;
        StringBuilder missingMods = new StringBuilder();
        for (ArrayList<UserMod> mods : semesterModules.values()) {
            for (UserMod mod : mods) {
                if (!fulfillsModPrereq(mod, semester)) {
                    missingMods.append(mod.getCode()).append(", ");
                }
            }
            semester++;
        }
        if (missingMods.length() == 0) {
            return;
        }
        assert missingMods.charAt(missingMods.length() - 1) == ' '
                && missingMods.charAt(missingMods.length() - 2) == ',';

        missingMods.deleteCharAt(missingMods.length() - 2); //remove last comma
        missingMods.append("missing prerequisites");
        System.out.println(missingMods);
    }

    public boolean fulfillsModPrereq(UserMod mod, int semester) {
        Prereq prereqTree = mod.getPrereqTree();
        if (prereqTree == null) {
            return true;
        }
        ArrayList<UserMod> modules = getAllModulesTilSemester(semester);
        if (isExemptedMA1301) {
            modules.add(new UserMod("MA1301", 0, "Exempted MA1301"));
        }
        if (isExemptedPC1101) {
            modules.add(new UserMod("PC1101", 0, "Exempted PC1101"));
        }
        if (isExemptedEnglish) {
            modules.add(new UserMod("ES1000", 0, "Exempted English"));
            modules.add(new UserMod("ES1103", 0, "Exempted English"));
        }
        return prereqTree.fulfillsPrereq(modules);
    }


    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EducationLevel getEducation() {
        return education;
    }

    public void setEducation(EducationLevel education) {
        this.education = education;
    }

    public boolean isExemptedMA1301() {
        return isExemptedMA1301;
    }

    public void setExemptedMA1301(boolean exemptedMA1301) {
        isExemptedMA1301 = exemptedMA1301;
    }

    public boolean isExemptedPC1101() {
        return isExemptedPC1101;
    }

    public void setExemptedPC1101(boolean exemptedPC1101) {
        isExemptedPC1101 = exemptedPC1101;
    }

    public boolean isExemptedEnglish() {
        return isExemptedEnglish;
    }

    public void setExemptedEnglish(boolean exemptedEnglish) {
        isExemptedEnglish = exemptedEnglish;
    }

    public ArrayList<UserMod> getAllModules() {
        return semesterModules.values()
                .stream()
                .flatMap(ArrayList::stream)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<UserMod> getAllModulesTilSemester(int semester) {
        return semesterModules.values()
                .stream()
                .limit(semester)
                .flatMap(ArrayList::stream)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public boolean initialiseUser() {
        if (getName().isEmpty()) {
            if (!initialiseName()) { //user exit
                return false;
            }
        }

        if (getEducation() == null) {
            if (!initialiseEducation()) { //user exit
                return false;
            }
        }

        if (getCurrentSemester() == -1) {
            if (!initialiseSemester()) { //user exit
                return false;
            }
        }

        if (isExemptedEnglish == null || isExemptedPC1101 == null || isExemptedMA1301 == null) {
            bridgingCourseCheck();
        }

        System.out.println("You're all set!");
        return true;
    }

    private boolean initialiseSemester() {
        System.out.println("Please enter current semester: (1-8)");
        while (getCurrentSemester() == -1) { // semester is uninitialised
            try {
                String userInput = Ui.readInput();
                if (userInput.equals("/exit")) {
                    return false;
                }
                int semester = Integer.parseInt(userInput);
                if (Ui.isValidSem(semester)) {
                    setCurrentSemester(semester);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number from 1-8");
            }
        }
        return true;
    }

    private boolean initialiseEducation() {
        System.out.println("Are you from JC or Poly? (jc/poly)");
        while (getEducation() == null) {
            String userInput = Ui.readInput();
            if (userInput.equals("/exit")) {
                return false;
            }
            if (userInput.equalsIgnoreCase("jc")) {
                setEducation(EducationLevel.JC);
            } else if (userInput.equalsIgnoreCase("poly")) {
                setEducation(EducationLevel.POLY);
            } else {
                System.out.println("Please enter either 'jc' or 'poly'");
            }
        }
        return true;
    }

    private boolean initialiseName() {

        while (getName().isBlank()) {
            System.out.println("Please enter your name:");
            String userInput = Ui.readInput();
            if (userInput.equals("/exit")) {
                return false;
            }
            setName(userInput);
        }
        return true;
    }

    private boolean bridgingCourseCheck() {
        System.out.println("Some courses in NUS require bridging courses:");
        Boolean result;

        if (isExemptedMA1301 == null) {
            System.out.println("Are you exempted from MA1301? (y/n)");
            result = Ui.askYesNo();
            if (result == null) {
                return false;
            }
            setExemptedMA1301(Boolean.TRUE.equals(result));
        }

        if (isExemptedPC1101 == null) {
            System.out.println("Are you exempted from PC1101? (y/n)");
            result = Ui.askYesNo();
            if (result == null) {
                return false;
            }
            setExemptedPC1101(Boolean.TRUE.equals(result));
        }

        if (isExemptedEnglish == null) {
            System.out.println("Are you exempted from ES1000 & ES1103? (y/n)");
            result = Ui.askYesNo();
            if (result == null) {
                return false;
            }
            setExemptedEnglish(Boolean.TRUE.equals(result));
        }

        return true;
    }

    /**
     * Sets all Exemptions to false
     */
    public void clearExemptions() {
        setExemptedMA1301(false);
        setExemptedPC1101(false);
        setExemptedEnglish(false);
    }

    public void resetUser() {
        clearModules();
        clearExemptions();
    }
}


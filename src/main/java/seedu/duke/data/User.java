package seedu.duke.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import seedu.duke.errors.ModNotInDatabase;

public class User {
    private String name;
    private EducationLevel education;
    private double gpa;
    private int currentSemester;
    private final Map<Integer, ArrayList<UserMod>> semesterModules;

    public User() {
        // Default constructor initializes with empty values

        this.name = "";
        this.education = null;
        this.gpa = 0.0;
        this.currentSemester = 1;
        this.semesterModules = new HashMap<>();

    }

    public User(String name, EducationLevel education) {
        this.name = name;
        this.education = education;
        this.gpa = 0.0;
        this.currentSemester = 1;
        this.semesterModules = new HashMap<>();
    }


    public Map<Integer, ArrayList<UserMod>> getSemesterModules() {
        return semesterModules;
    }

    public double getGPA() {
        updateGPA();
        return gpa;
    }

    private void updateGPA() {
        double totalGradePoints = 0;
        int totalMCs = 0;

        for (ArrayList<UserMod> mods : semesterModules.values()) {
            for (UserMod mod : mods) {
                Grade moduleGrade = mod.getGrade();
                int modMC = mod.getNumMC();

                if (moduleGrade != null && !mod.isSU()) {
                    totalGradePoints += moduleGrade.getGradePoint() * modMC;
                    totalMCs += modMC;
                }
            }
        }

        this.gpa = totalMCs > 0 ? totalGradePoints / totalMCs : 0.0;
    }

    public boolean updateModuleGPA(String code, Grade grade) {
        for (ArrayList<UserMod> mods : semesterModules.values()) {
            for (UserMod mod : mods) {
                if (mod.getCode() != null && mod.getCode().equalsIgnoreCase(code)) {
                    mod.setGrade(grade);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addModule(String code, int semester) {
        if (semester < 1 || semester > 8) {
            return false; // Invalid semester
        }

        try {
            UserMod newMod = new UserMod(code);

            semesterModules.putIfAbsent(semester, new ArrayList<>());
            if (semesterModules.get(semester).contains(newMod)) {
                return false; // Module already exists
            }

            semesterModules.get(semester).add(newMod);
            updateGPA(); // Recalculate GPA
            if (!fulfillsModPrereq(newMod, semester)) {
                System.out.println("WARNING: " + code + " missing prerequisites");
            }
            return true;

        } catch (ModNotInDatabase e) {
            System.out.println(code + " not in database. /addCustom to add custom modules");
            return false;
        }
    }

    public boolean removeModule(String code) {
        for (int semester : semesterModules.keySet()) {
            if (semesterModules.get(semester).removeIf(UserMod ->
                    UserMod.getCode().equals(code.toUpperCase()))) {
                updateGPA(); // Recalculate GPA after removal
                checkAllPrereqs();
                return true;
            }
        }
        return false; // Module not found in any semester
    }

    public boolean suModule(String code) {
        for (ArrayList<UserMod> mods : semesterModules.values()) {
            for (UserMod mod : mods) {
                if (mod.getCode().equalsIgnoreCase(code)) {
                    mod.setSU(true);
                    updateGPA(); // Recalculate GPA after SU
                    return true;
                }
            }
        }
        return false; // Module not found
    }

    public boolean hasModule(String code) {
        for (ArrayList<UserMod> mods : semesterModules.values()) {
            for (UserMod mod : mods) {
                if (mod.getCode() != null && mod.getCode().equalsIgnoreCase(code)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearModules() {
        semesterModules.clear();
        updateGPA(); // Reset GPA after clearing modules
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
        return prereqTree.fulfillsPrereq(getAllModulesTilSemester(semester));
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
}


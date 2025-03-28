package seedu.duke.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private EducationLevel education;
    private double gpa;
    private int currentSemester;
    private Map<Integer, ArrayList<UserMod>> semesterModules;

    public User() {
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
                if ( mod.getCode() != null && mod.getCode().equalsIgnoreCase(code)) {
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

        UserMod newMod = new UserMod(code);

        semesterModules.putIfAbsent(semester, new ArrayList<>());
        if (semesterModules.get(semester).contains(newMod)) {
            return false; // Module already exists
        }

        semesterModules.get(semester).add(newMod);
        updateGPA(); // Recalculate GPA
        return true;
    }

    public boolean removeModule(String code) {
        for (int semester : semesterModules.keySet()) {
            if (semesterModules.get(semester).removeIf(UserMod ->
                    UserMod.getCode().equals(code.toUpperCase()))) {
                updateGPA(); // Recalculate GPA after removal
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
                if ( mod.getCode() != null && mod.getCode().equalsIgnoreCase(code)) {
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
}


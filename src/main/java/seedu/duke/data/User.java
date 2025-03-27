package seedu.duke.data;

import seedu.duke.data.EducationLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class User {
    private String name;
    private EducationLevel education;
    private double GPA;
    private int currentSemester;
    private Map<Integer, ArrayList<UserMod>> semesterModules;

    public User() {
        this.name = "";
        this.education = null;
        this.GPA = 0.0;
        this.currentSemester = 1;
        this.semesterModules = new HashMap<>();
    }

    public User(String name, EducationLevel education) {
        this.name = name;
        this.education = education;
        this.GPA = 0.0;
        this.currentSemester = 1;
        this.semesterModules = new HashMap<>();
    }


    public Map<Integer, ArrayList<UserMod>> getSemesterModules() {
        return semesterModules;
    }

    public double getGPA() {
        return GPA;
    }

    private void updateGPA() {
        double totalGradePoints = 0;
        int totalMCs = 0;

        for (ArrayList<UserMod> mods : semesterModules.values()) {
            for (UserMod mod : mods) {
                Grade grade = mod.getGrade();
                int modMC = mod.getNumMC();

                if (grade != null) {
                    totalGradePoints += getGradePoint(grade) * modMC;
                    totalMCs += modMC;
                }
            }
        }

        GPA = totalMCs > 0 ? totalGradePoints / totalMCs : 0.0;
    }

    private double getGradePoint(Grade grade) {
        switch (grade) {
            case A: return 5.0;
            case B: return 4.0;
            case C: return 3.0;
            case D: return 2.0;
            case E: return 1.0;
            case F: return 0.0;
            default: return 0.0;
        }
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
            if (semesterModules.get(semester).removeIf(UserMod -> UserMod.getCode().equals(code.toUpperCase()))) {
                updateGPA(); // Recalculate GPA after removal
                return true;
            }
        }
        return false; // Module not found in any semester
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


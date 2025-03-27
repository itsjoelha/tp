package seedu.duke.data;

import seedu.duke.command.UserCommands;

import java.util.ArrayList;

public class User {
    private String name;
    private Education education;
    private double GPA;
    private ArrayList<UserMod> modulesTaken;

    public User(String name, Education education) {
        this.name = name;
        this.education = education;
        this.modulesTaken = new ArrayList<>();
        this.GPA = 0.0; // Default GPA
    }

    public void addModule(String code) {
        UserMod newMod = UserCommands.addUserMod(this, code);
        if (newMod != null) {
            modulesTaken.add(newMod);
            updateGPA();
        }
    }

    public void removeModule(String code) {
        boolean removed = UserCommands.removeUserMod(this, code);
        if (removed) {
            modulesTaken.removeIf(mod -> mod.getCode().equals(code));
            updateGPA();
        }
    }

    public ArrayList<UserMod> getModulesTaken() {
        return modulesTaken;
    }

    public double getGPA() {
        return GPA;
    }

    private void updateGPA() {
        if (modulesTaken.isEmpty()) {
            GPA = 0.0;
            return;
        }

        double totalGradePoints = 0;
        int totalMCs = 0;

        for (UserMod mod : modulesTaken) {
            Grade grade = mod.getGrade();
            int modMC = mod.getNumMC(); // Assuming Mod class has a method getNumMC()

            if (grade != null) {
                totalGradePoints += getGradePoint(grade) * modMC;
                totalMCs += modMC;
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
}

enum Education {
    JC, POLY
}

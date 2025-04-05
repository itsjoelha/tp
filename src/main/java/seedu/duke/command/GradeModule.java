package seedu.duke.command;

import java.util.ArrayList;
import java.util.Map;

import seedu.duke.data.Grade;
import seedu.duke.data.User;
import seedu.duke.data.UserMod;

public class GradeModule implements Command {
    private final String moduleCode;
    private final User user;
    private Grade grade;

    public GradeModule(User user, String moduleCode, String grade) {
        this.moduleCode = moduleCode;
        this.user = user;
        try {
            this.grade = Grade.fromString(grade);
        } catch (IllegalArgumentException e) {
            this.grade = null;
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void execute() {
        String errorMsg = "Grading unsuccessful";
        if (grade == null) {
            System.out.println(errorMsg);
            return;
        }
        Map<Integer, ArrayList<UserMod>> semesterModules = user.getSemesterModules();
        for (ArrayList<UserMod> mods : semesterModules.values()) {
            for (UserMod mod : mods) {
                if (mod.getCode() != null && mod.getCode().equalsIgnoreCase(moduleCode)) {
                    mod.setGrade(grade);
                    System.out.println("Module " + moduleCode.toUpperCase() + " successfully graded as " +
                            grade.getLabel());
                    return;
                }
            }
        }
        System.out.println(errorMsg);
    }
}

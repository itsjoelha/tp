package seedu.duke.command;

import seedu.duke.data.Grade;
import seedu.duke.data.User;

public class GradeModule implements Command {
    private String moduleCode;
    private Grade grade;
    private User user;

    public GradeModule(User user, String moduleCode, String grade) {
        this.moduleCode = moduleCode;
        this.user = user;
        this.grade = Grade.fromString(grade);
    }

    @Override
    public void execute() {
        boolean updated = user.updateModuleGPA(moduleCode, grade);
        if (updated) {
            System.out.println("Module " + moduleCode + " successfully graded as " + grade.getLabel());
        } else {
            System.out.println("Grading unsuccessful");
        }
    }
}

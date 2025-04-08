package seedu.duke.command;

import seedu.duke.user.User;

public class GetUserGPA implements Command {
    private final User user;
    private double gpa;

    public GetUserGPA(User user) {
        this.user = user;
    }

    @Override
    public void execute() {
        gpa = user.getGPA();
        System.out.println("Your Current GPA: " + gpa);
    }
}

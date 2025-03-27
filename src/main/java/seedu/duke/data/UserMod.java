package seedu.duke.data;

public class UserMod extends Mod {
    private Grade grade;
    private boolean SU;


    public UserMod(String name, String description, int numMC, String code, double lectureHours, double tutHours,
                   double labHours, double projHours, double prepHours, String preclusion, String prerequisites) {
        super(name, description, numMC, code, lectureHours, tutHours, labHours, projHours, prepHours,
                preclusion, prerequisites);
    }

    public UserMod(String code, Grade grade, boolean SU) {
        super(code);
        this.grade = grade;
        this.SU = SU;
    }

    public UserMod(String code){
        super(code);
        this.grade = null;
        this.SU = false;
    }


    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public boolean isSU() {
        return SU;
    }

    public void setSU(boolean SU) {
        this.SU = SU;
    }

}


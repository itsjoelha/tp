package seedu.duke.data;

public class UserMod extends Mod {
    private Grade grade;
    private boolean su;


    public UserMod(String name, String description, int numMC, String code, double lectureHours, double tutHours,
                   double labHours, double projHours, double prepHours, String preclusion, String prerequisites) {
        super(name, description, numMC, code, lectureHours, tutHours, labHours, projHours, prepHours,
                preclusion, prerequisites);
    }

    public UserMod(String code, Grade grade, boolean su) {
        super(code);
        this.grade = grade;
        this.su = su;
    }

    public UserMod(String code){
        super(code);
        this.grade = null;
        this.su = false;
    }


    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public boolean isSU() {
        return su;
    }

    public void setSU(boolean su) {
        this.su = su;
    }

    public void print() {
        if (grade != null) {
            System.out.println(super.toString() + " | Grade: " + grade.getLabel() + " | SU: " + su + " |");

        } else {
            System.out.println(super.toString() + " | Grade: " + "null" + " | SU: " + su + " |");
        }
    }

}


package seedu.duke.data;

import java.util.ArrayList;

// Represents a single mod as a prereq
public class ModPrereq extends Prereq {
    private final String modCode;
    private final Grade minGrade;

    public ModPrereq(String[] req) {
        this.modCode = req[0];
        this.minGrade = Grade.valueOf(req[1]);
    }

    public String getModCode() {
        return modCode;
    }

    public Grade getMinGrade() {
        return minGrade;
    }

    @Override
    public String toString() {
        return modCode + ":" + minGrade;
    }

    public boolean fulfillsPrereq(ArrayList<UserMod> modules) {
        for (UserMod module : modules) {
            Grade modGrade = module.getGrade();
            if (module.getCode().equals(modCode) &&
                    (modGrade == null || Grade.isHigherOrEqual(modGrade, minGrade))) {
                return true;  // Found a match with required modCode and grade
            }
        }
        return false;  // No match found
    }

}

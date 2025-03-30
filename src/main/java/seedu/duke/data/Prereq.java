package seedu.duke.data;

import java.util.ArrayList;
import java.util.List;

// Abstract base class for all prereq types
public abstract class Prereq {
    public abstract boolean fulfillsPrereq(ArrayList<UserMod> modules);
}

// Represents a single mod as a prereq
class ModPrereq extends Prereq {
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

// Represents an "AND" prereq (all conditions must be met)
class AndPrereq extends Prereq {
    private final List<Prereq> prereqs;

    public AndPrereq(List<Prereq> prereqs) {
        this.prereqs = prereqs;
    }

    public List<Prereq> getPrereqs() {
        return prereqs;
    }

    @Override
    public String toString() {
        return "AND " + prereqs;
    }

    public boolean fulfillsPrereq(ArrayList<UserMod> modules) {
        return prereqs.stream()
                .allMatch(prereq -> prereq.fulfillsPrereq(modules));
    }
}

// Represents an "OR" prereq (at least one condition must be met)
class OrPrereq extends Prereq {
    private final List<Prereq> prereqs;

    public OrPrereq(List<Prereq> prereqs) {
        this.prereqs = prereqs;
    }

    public List<Prereq> getPrereqs() {
        return prereqs;
    }

    @Override
    public String toString() {
        return "OR " + prereqs;
    }

    public boolean fulfillsPrereq(ArrayList<UserMod> modules) {
        return prereqs.stream()
                .anyMatch(prereq -> prereq.fulfillsPrereq(modules));
    }
}

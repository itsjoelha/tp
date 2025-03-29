package seedu.duke.data;

import java.util.List;

// Abstract base class for all prereq types
public abstract class Prereq {}

// Represents a single mod as a prereq
class ModPrereq extends Prereq {
    private final String modCode;
    private final String grade;

    public ModPrereq(String[] req) {
        this.modCode = req[0];
        this.grade = req[1];
    }

    public String getModCode() {
        return modCode;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return modCode  + ":" + grade;
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
}

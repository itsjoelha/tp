package seedu.duke.data;

import java.util.ArrayList;
import java.util.List;

// Represents an "AND" prereq (all conditions must be met)
public class AndPrereq extends Prereq {
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

package seedu.duke.data;

import java.util.ArrayList;
import java.util.List;

// Represents an "OR" prereq (at least one condition must be met)
public class OrPrereq extends Prereq {
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

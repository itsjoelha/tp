package seedu.duke.data;

import java.util.ArrayList;

// Abstract base class for all prereq types
public abstract class Prereq {
    public abstract boolean fulfillsPrereq(ArrayList<UserMod> modules);
}


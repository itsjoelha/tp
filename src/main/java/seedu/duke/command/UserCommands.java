package seedu.duke.command;

import seedu.duke.data.User;
import seedu.duke.data.UserMod;
import seedu.duke.data.Grade;

import java.util.ArrayList;

public class UserCommands {
    private User user;

    public UserCommands(User user) {
        this.user = user;
    }

    public static UserMod addUserMod(User user, String code) {
        ArrayList<UserMod> modulesTaken = user.getModulesTaken();

        // Prevent duplicate module entries
        for (UserMod mod : modulesTaken) {
            if (mod.getCode().equals(code)) {
                System.out.println("Module " + code + " already added!");
                return null;
            }
        }

        // Create a new UserMod (default grade is null, default SU is false)
        UserMod newMod = new UserMod(code, null, false);
        modulesTaken.add(newMod);
        System.out.println("Added module: " + code);

        return newMod;
    }

    public static boolean removeUserMod(User user, String code) {
        ArrayList<UserMod> modulesTaken = user.getModulesTaken();

        for (UserMod mod : modulesTaken) {
            if (mod.getCode().equals(code)) {
                modulesTaken.remove(mod);
                System.out.println("Removed module: " + code);
                return true;
            }
        }

        System.out.println("Module " + code + " not found!");
        return false;
    }
}

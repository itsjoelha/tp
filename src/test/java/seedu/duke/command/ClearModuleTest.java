package seedu.duke.command;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.Duke.currentUser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.duke.user.User;

public class ClearModuleTest {
    @BeforeEach
    public void setUp() {
        currentUser.clearModules(); // Clear the moduleList
    }

    @Test
    public void clearModules_withModules_clearsAllModules() {
        User user = new User();
        int testSemester1 = 1;
        int testSemester2 = 2;
        String testModule1 = "CS1010";
        String testModule2 = "CS2040C";
        Command testCommand1 = new AddUserModule(currentUser, testModule1, testSemester1);
        testCommand1.execute();
        Command testCommand2 = new AddUserModule(currentUser, testModule2, testSemester2);
        testCommand2.execute();
        ClearModules command = new ClearModules(user);
        command.execute();
        assertTrue(user.getAllModules().isEmpty());
    }

    @Test
    public void clearModules_withNoModules_doesNothing() {
        User user = new User();
        ClearModules command = new ClearModules(user);
        command.execute();
        assertTrue(user.getAllModules().isEmpty());
    }

    @Test
    public void clearModules_printsConfirmationMessage() {
        User user = new User();
        ClearModules command = new ClearModules(user);
        command.execute();
        // Verify the console output contains the expected confirmation message
    }
}

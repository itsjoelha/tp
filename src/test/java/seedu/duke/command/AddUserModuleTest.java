package seedu.duke.command;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.Duke.currentUser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AddUserModuleTest {
    @BeforeEach
    public void setUp() {
        currentUser.resetUser(); // Clear and set all exemptions to false
    }

    @Test
    public void testAddUserModule() {
        int testSemester1 = 3;
        int testSemester2 = 4;
        String testModule1 = "CS2113";
        String testModule2 = "CS2040C";

        Command testCommand1 = new AddUserModule(currentUser, testModule1, testSemester1);
        testCommand1.execute();
        Command testCommand2 = new AddUserModule(currentUser, testModule2,testSemester2);
        testCommand2.execute();

        assertTrue(currentUser.hasModule(testModule1));
        assertTrue(currentUser.hasModule(testModule2));
    }

    @Test public void testAddUserModuleDoesNotExist() {
        int testSemester1 = 3;
        int testSemester2 = 4;
        String testModule1 = "CS2223";
        String testModule2 = "CS2010C";

        Command testCommand1 = new AddUserModule(currentUser, testModule1, testSemester1);
        testCommand1.execute();
        Command testCommand2 = new AddUserModule(currentUser, testModule2, testSemester2);
        testCommand2.execute();

        assertFalse(currentUser.hasModule(testModule1));
        assertFalse(currentUser.hasModule(testModule2));
        assertTrue(currentUser.getAllModules().isEmpty());
    }
}

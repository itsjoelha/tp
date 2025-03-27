package seedu.duke.command;
import static org.junit.jupiter.api.Assertions.*;
import static seedu.duke.Duke.current_user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AddUserModuleTest {
    @BeforeEach
    public void setUp() {
        current_user.clearModules(); // Clear the moduleList
    }

    @Test
    public void testAddUserModule() {
        int testSemester1 = 3;
        int testSemester2 = 4;
        String testModule1 = "CS2113";
        String testModule2 = "CS2040C";

        Command test_command_1 = new AddUserModule(current_user, testModule1, testSemester1);
        test_command_1.execute();
        Command test_command_2 = new AddUserModule(current_user, testModule2,testSemester2);
        test_command_2.execute();

        assertTrue(current_user.hasModule(testModule1));
        assertTrue(current_user.hasModule(testModule2));
    }

    @Test public void testAddUserModuleDoesNotExist() {
        int testSemester1 = 3;
        int testSemester2 = 4;
        String testModule1 = "CS2223";
        String testModule2 = "CS2010C";

        Command test_command_1 = new AddUserModule(current_user, testModule1, testSemester1);
        test_command_1.execute();
        Command test_command_2 = new AddUserModule(current_user, testModule2, testSemester2);
        test_command_2.execute();

        assertFalse(current_user.hasModule(testModule1));
        assertFalse(current_user.hasModule(testModule2));
    }
}

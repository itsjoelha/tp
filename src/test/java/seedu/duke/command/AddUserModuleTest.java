package seedu.duke.command;
import static org.junit.jupiter.api.Assertions.*;
import static seedu.duke.Duke.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AddUserModuleTest {
    @BeforeEach
    public void setUp() {
        current_user.clearModules(); // Clear the moduleList
    }

    @Test
    public void testAddUserModule() {
        int test_semester_1 = 3;
        int test_semester_2 = 4;
        String test_module_1 = "CS2113";
        String test_module_2 = "CS2040C";

        Command test_command_1 = new AddUserModule(current_user, test_module_1, test_semester_1);
        test_command_1.execute();
        Command test_command_2 = new AddUserModule(current_user, test_module_2,test_semester_2);
        test_command_2.execute();

        assertTrue(current_user.hasModule(test_module_1));
        assertTrue(current_user.hasModule(test_module_2));
    }

    @Test public void testAddUserModuleDoesNotExist() {
        int test_semester_1 = 3;
        int test_semester_2 = 4;
        String test_module_1 = "CS2223";
        String test_module_2 = "CS2010C";

        Command test_command_1 = new AddUserModule(current_user, test_module_1, test_semester_1);
        test_command_1.execute();
        Command test_command_2 = new AddUserModule(current_user, test_module_2, test_semester_2);
        test_command_2.execute();

        assertFalse(current_user.hasModule(test_module_1));
        assertFalse(current_user.hasModule(test_module_2));
    }
}

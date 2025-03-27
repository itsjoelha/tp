package seedu.duke.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.Duke.*;

public class DeleteUserModuleTest {
    private final String test_modCode1 = "CS1010";
    private final String test_modCode2 = "CS2040C";
    private final int test_semester_1 = 3;
    private final int test_semester_2 = 4;

    @BeforeEach
    void setUp() {
        current_user.clearModules();
        Command test_add_1 = new AddUserModule(current_user, test_modCode1, test_semester_1);
        test_add_1.execute();
        Command test_add_2 = new AddUserModule(current_user, test_modCode2, test_semester_2);
        test_add_2.execute();
    }

    @Test
    void deleteUserModule() {
        Command test_delete_1 = new DeleteUserModule(current_user, test_modCode1);
        test_delete_1.execute();


        assertFalse(current_user.hasModule(test_modCode1));
        assertTrue(current_user.hasModule(test_modCode2));
    }

    @Test void deleteUserModuleDoesNotExist() {
        Command test_delete_1 = new DeleteUserModule(current_user, "CDE3301");
        test_delete_1.execute();

        assertTrue(current_user.hasModule(test_modCode1));
        assertTrue(current_user.hasModule(test_modCode2));
    }
}

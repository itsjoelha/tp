package seedu.duke.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.Duke.current_user;

public class DeleteUserModuleTest {
    private final String testModCode1 = "CS1010";
    private final String testModCode2 = "CS2040C";
    private final int testSemester1 = 3;
    private final int testSemester2 = 4;

    @BeforeEach
    void setUp() {
        current_user.clearModules();
        Command test_add_1 = new AddUserModule(current_user, testModCode1, testSemester1);
        test_add_1.execute();
        Command test_add_2 = new AddUserModule(current_user, testModCode2, testSemester2);
        test_add_2.execute();
    }

    @Test
    void deleteUserModule() {
        Command test_delete_1 = new DeleteUserModule(current_user, testModCode1);
        test_delete_1.execute();


        assertFalse(current_user.hasModule(testModCode1));
        assertTrue(current_user.hasModule(testModCode2));
    }

    @Test void deleteUserModuleDoesNotExist() {
        Command test_delete_1 = new DeleteUserModule(current_user, "CDE3301");
        test_delete_1.execute();

        assertTrue(current_user.hasModule(testModCode1));
        assertTrue(current_user.hasModule(testModCode2));
    }
}

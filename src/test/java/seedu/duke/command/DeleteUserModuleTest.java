package seedu.duke.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.Duke.currentUser;

public class DeleteUserModuleTest {
    private final String testModCode1 = "CS1010";
    private final String testModCode2 = "CS2040C";
    private final int testSemester1 = 3;
    private final int testSemester2 = 4;

    @BeforeEach
    void setUp() {
        currentUser.resetUser(); // Clear and set all exemptions to false
        Command testAdd1 = new AddUserModule(currentUser, testModCode1, testSemester1);
        testAdd1.execute();
        Command testAdd2 = new AddUserModule(currentUser, testModCode2, testSemester2);
        testAdd2.execute();
    }

    @Test
    void deleteUserModule() {
        Command testDelete1 = new DeleteUserModule(currentUser, testModCode1);
        testDelete1.execute();


        assertFalse(currentUser.hasModule(testModCode1));
        assertTrue(currentUser.hasModule(testModCode2));
    }

    @Test
    void deleteUserModuleDoesNotExist() {
        Command testDelete1 = new DeleteUserModule(currentUser, "CDE3301");
        testDelete1.execute();

        assertTrue(currentUser.hasModule(testModCode1));
        assertTrue(currentUser.hasModule(testModCode2));
    }
}

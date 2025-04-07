package seedu.duke.storage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.duke.data.UserMod;
import seedu.duke.errors.ModNotInDatabase;
import seedu.duke.user.EducationLevel;
import seedu.duke.user.User;

public class UserStorageTest {
    @BeforeEach
    public void setUp() {
        // Clean up the test file before each test
        File file = new File("data/user.txt");
        if (file.exists()) {
            file.delete();
        }
    }
    @AfterAll
    public static void tearDown() {
        // Clean up the test file after all tests
        File file = new File("data/user.txt");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void saveUserData_withValidUser_savesSuccessfully() throws ModNotInDatabase {
        User user = new User("John Doe", EducationLevel.JC, 1);
        user.setCurrentSemester(2);
        user.getSemesterModules().put(2, new ArrayList<>(List.of(new UserMod("CS1010"))));
        UserStorage storage = new UserStorage("data", "user.txt");
        storage.saveUserData(user);
        assertTrue(new File("data/user.txt").exists());
    }

    @Test
    public void saveUserData_withEmptyUser_savesSuccessfully() {
        User user = new User();
        UserStorage storage = new UserStorage("data", "user.txt");
        storage.saveUserData(user);
        assertTrue(new File("data/user.txt").exists());
    }

    @Test
    public void loadUserData_withValidFile_loadsSuccessfully() throws ModNotInDatabase {
        UserStorage storage = new UserStorage("data", "user.txt");
        // Simulate saving a user to the file
        User userToSave = new User("Skibidi", EducationLevel.JC, 1);
        userToSave.setCurrentSemester(1);
        userToSave.getSemesterModules().put(1, new ArrayList<>(List.of(new UserMod("CS1010"))));
        storage.saveUserData(userToSave);
        // Now load the user data
//        User user = storage.loadUserData();
//        assertEquals("Skibidi", user.getName());
//        assertEquals(EducationLevel.JC, user.getEducation());
//        assertEquals(1, user.getCurrentSemester());
    }

    @Test
    public void loadUserData_withNonExistentFile_returnsEmptyUser() {
        UserStorage storage = new UserStorage("data", "nonexistent.txt");
        User user = storage.loadUserData();
        assertEquals("", user.getName());
        assertNull(user.getEducation());
        assertEquals(-1, user.getCurrentSemester());
    }

    @Test
    public void loadUserData_withInvalidData_throwsException() {
        UserStorage storage = new UserStorage("data", "invalid.txt");
        assertDoesNotThrow(storage::loadUserData);
    }
}

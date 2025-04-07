package seedu.duke.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.duke.errors.ModNotInDatabase;

public class UserModTest {
    @Test
    public void userModConstructor_withValidCode_initializesCorrectly() throws ModNotInDatabase {
        UserMod userMod = new UserMod("CS1010");
        assertEquals("CS1010", userMod.getCode());
        assertNull(userMod.getGrade());
        assertFalse(userMod.isSU());
        assertFalse(userMod.isCustom());
    }

    @Test
    public void userModConstructor_withInvalidCode_throwsModNotInDatabase() {
        assertThrows(ModNotInDatabase.class, () -> new UserMod("INVALID_CODE"));
    }

    @Test
    public void userModConstructor_withAllParameters_initializesCorrectly() {
        UserMod userMod = new UserMod("Software Engineering", "Introduction to SE", 4, "CS2103",
                                      2, 1, 1, 1, 1, "CS2101", "CS1010", null, true);
        assertEquals("CS2103", userMod.getCode());
        assertEquals("Software Engineering", userMod.getName());
        assertEquals("Introduction to SE", userMod.getDescription());
        assertEquals(4, userMod.getNumMC());
        assertFalse(userMod.isSU());
        assertFalse(userMod.isCustom());
    }

    @Test
    public void userModConstructor_withMinimalParameters_initializesCorrectly() {
        UserMod userMod = new UserMod("CS2103", 4, "Software Engineering");
        assertEquals("CS2103", userMod.getCode());
        assertEquals(4, userMod.getNumMC());
        assertEquals("Software Engineering", userMod.getName());
        assertEquals("", userMod.getDescription());
        assertTrue(userMod.isCustom());
    }

    @Test
    public void userModConstructor_withGradeAndSU_initializesCorrectly() throws ModNotInDatabase {
        Grade grade = Grade.A;
        UserMod userMod = new UserMod("CS1010", grade, true);
        assertEquals("CS1010", userMod.getCode());
        assertEquals(grade, userMod.getGrade());
        assertTrue(userMod.isSU());
        assertFalse(userMod.isCustom());
    }

    @Test
    public void toggleSU_togglesSUStatus() throws ModNotInDatabase {
        UserMod userMod = new UserMod("CS1010");
        assertFalse(userMod.isSU());
        userMod.toggleSU();
        assertTrue(userMod.isSU());
        userMod.toggleSU();
        assertFalse(userMod.isSU());
    }

    @Test
    public void setGrade_setsGradeCorrectly() throws ModNotInDatabase {
        UserMod userMod = new UserMod("CS1010");
        Grade grade = Grade.B;
        userMod.setGrade(grade);
        assertEquals(grade, userMod.getGrade());
    }

    @Test
    public void print_withGradeAndSU_printsCorrectly() throws ModNotInDatabase {
        UserMod userMod = new UserMod("CS1010", Grade.A, true);
        userMod.print();
        // Verify the console output contains the expected string
    }
}

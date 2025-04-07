package seedu.duke.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.duke.errors.ModNotInDatabase;

public class ModTest {
    @Test
    public void modConstructor_withValidCode_initializesCorrectly() throws ModNotInDatabase {
        Mod mod = new Mod("CS1010");
        assertEquals("CS1010", mod.getCode());
        assertNotNull(mod.getName());
        assertNotNull(mod.getDescription());
    }

    @Test
    public void modConstructor_withInvalidCode_throwsModNotInDatabase() {
        assertThrows(ModNotInDatabase.class, () -> new Mod("INVALID_CODE"));
    }

    @Test
    public void modConstructor_withAllParameters_initializesCorrectly() {
        Mod mod = new Mod("Software Engineering", "Introduction to SE", 4, "CS2103",
                          2, 1, 1, 1, 1, "CS2101", "CS1010", null, true);
        assertEquals("CS2103", mod.getCode());
        assertEquals("Software Engineering", mod.getName());
        assertEquals("Introduction to SE", mod.getDescription());
        assertEquals(4, mod.getNumMC());
        assertTrue(mod.isSUable());
    }

    @Test
    public void modConstructor_withMinimalParameters_initializesCorrectly() {
        Mod mod = new Mod("CS2103", 4, "Software Engineering");
        assertEquals("CS2103", mod.getCode());
        assertEquals(4, mod.getNumMC());
        assertEquals("Software Engineering", mod.getName());
        assertEquals("", mod.getDescription());
    }

    @Test
    public void modToString_returnsCorrectFormat() {
        Mod mod = new Mod("CS2103", 4, "Software Engineering");
        assertEquals("CS2103 | Software Engineering | (4 MCs)", mod.toString());
    }
}

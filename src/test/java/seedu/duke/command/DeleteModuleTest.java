package seedu.duke.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.duke.Duke.moduleList;
import static seedu.duke.Duke.totalMCs;

class DeleteModuleTest {
    private final String modCode1 = "CS1010";
    private final String modCode2 = "CS2040C";

    @BeforeEach
    void setUp() {
        // Use AddModule command to add modules
        System.out.println("Reset moduleList");
        moduleList.clear();
        totalMCs = 0;
        Command add1 = new AddMod(modCode1);
        add1.execute();
        Command add2 = new AddMod(modCode2);
        add2.execute();
    }

    @Test
    void execute_validModule_moduleDeleted() {
        Command deleteModule = new DeleteMod(modCode1);
        deleteModule.execute();

        assertEquals(1, moduleList.size());
        assertEquals(4, totalMCs);
        assertFalse(moduleList.stream().anyMatch(m -> m.getCode().equals(modCode1)));

        deleteModule = new DeleteMod(modCode2);
        deleteModule.execute();
        assertEquals(0, moduleList.size());
        assertEquals(0, totalMCs);
    }

    @Test
    void execute_invalidModule_noDeletion() {
        DeleteMod deleteModule = new DeleteMod("CS2030");
        deleteModule.execute();

        assertEquals(2, moduleList.size());
        assertEquals(8, totalMCs);
    }
}

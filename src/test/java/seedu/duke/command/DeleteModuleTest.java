package seedu.duke.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.duke.Duke.moduleList;
import static seedu.duke.Duke.totalMCs;

class DeleteModuleTest {
    private final String modCode1 = "CS1010";
    private final String modCode2 = "MA1521";

    @BeforeEach
    void setUp() {
        // Use AddModule command to add modules
        System.out.println("Reset moduleList");
        moduleList.clear();
        totalMCs = 0;
        new AddModule(modCode1).execute();
        new AddModule(modCode2).execute();
    }

    @Test
    void execute_validModule_moduleDeleted() {
        Command deleteModule = new DeleteModule(modCode1);
        deleteModule.execute();

        assertEquals(1, moduleList.size());
        assertEquals(4, totalMCs);
        assertFalse(moduleList.stream().anyMatch(m -> m.getCode().equals(modCode1)));

        deleteModule = new DeleteModule(modCode2);
        deleteModule.execute();
        assertEquals(0, moduleList.size());
        assertEquals(0, totalMCs);
    }

    @Test
    void execute_invalidModule_noDeletion() {
        DeleteModule deleteModule = new DeleteModule("CS2030");
        deleteModule.execute();

        assertEquals(2, moduleList.size());
        assertEquals(8, totalMCs);
    }
}

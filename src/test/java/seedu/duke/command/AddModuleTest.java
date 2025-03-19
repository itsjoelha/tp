package seedu.duke.command;

import static seedu.duke.Duke.moduleList;
import static seedu.duke.Duke.totalMCs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddModuleTest {
    @Test
    public void execute_success() throws Exception {
        String modCode1 = "CS2113";
        Command cmd = new AddModule(modCode1);
        cmd.execute();

        String modCode2 = "CS2040C";
        cmd = new AddModule(modCode2);
        cmd.execute();

        assertEquals(modCode1, moduleList.get(0).getCode());
        assertEquals(4, totalMCs);

        assertEquals(modCode2, moduleList.get(1).getCode());
        assertEquals(8, totalMCs);
    }
}

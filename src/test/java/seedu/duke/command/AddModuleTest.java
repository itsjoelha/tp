//package seedu.duke.command;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static seedu.duke.Duke.moduleList;
//import static seedu.duke.Duke.totalMCs;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class AddModuleTest {
//    @BeforeEach
//    public void setUp() {
//        moduleList.clear(); // Clear the moduleList
//        totalMCs = 0; // Reset totalMCs
//    }
//
//    @Test
//    public void execute_success() throws Exception {
//        String modCode1 = "CS2113";
//        Command cmd = new AddMod(modCode1);
//        cmd.execute();
//
//        String modCode2 = "CS2040C";
//        cmd = new AddMod(modCode2);
//        cmd.execute();
//
//        assertEquals(modCode1, moduleList.get(0).getCode());
//
//        assertEquals(modCode2, moduleList.get(1).getCode());
//        assertEquals(8, totalMCs);
//    }
//}

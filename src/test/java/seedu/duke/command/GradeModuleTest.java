package seedu.duke.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.Duke.currentUser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.duke.data.UserMod;

public class GradeModuleTest {

    @BeforeEach
    public void setUp() {
        currentUser.clearModules(); // Clear the moduleList

    }

    @Test
    public void validGrade() {
        String grade1 = "A";
        String moduleCode1 = "CG2028";
        int semester1 = 3;
        double expected_grade1 = 5.0;

        String grade2 = "D";
        String moduleCode2 = "CG2027";
        int semester2 = 3;
        double expected_grade2 = 1.0;

        Command addModule1 = new AddUserModule(currentUser, moduleCode1, semester1);
        addModule1.execute();
        assertTrue(currentUser.hasModule(moduleCode1));

        Command testCommand1 = new GradeModule(currentUser, moduleCode1, grade1);
        testCommand1.execute();
        UserMod userMod1 = currentUser.getModule(moduleCode1);
        assertEquals(expected_grade1, userMod1.getGrade().getGradePoint());

        Command addModule2 = new AddUserModule(currentUser, moduleCode2, semester2);
        addModule2.execute();
        assertTrue(currentUser.hasModule(moduleCode2));

        Command testCommand2 = new GradeModule(currentUser, moduleCode2, grade2);
        testCommand2.execute();
        UserMod userMod2 = currentUser.getModule(moduleCode2);
        assertEquals(expected_grade2, userMod2.getGrade().getGradePoint());
    }

    @Test
    public void validGradeCustomMod() {
        String grade1 = "A-";
        String moduleCode1 = "CG3207";
        String name1 = "Computer Architecture";
        int semester1 = 1;
        int numMC1 = 4;
        double expectedGrade1 = 4.5;

        String grade2 = "C+";
        String moduleCode2 = "GEN2050Y";
        String name2 = "Teach SG";
        int semester2 = 2;
        int numMC2 = 4;
        double expectedGrade2 = 2.5;

        Command addModule1 = new AddCustomModule(currentUser, moduleCode1, semester1, numMC1, name1);
        addModule1.execute();
        Command addModule2 = new AddCustomModule(currentUser, moduleCode2, semester2, numMC2, name2);
        addModule2.execute();
        Command testCommand1 = new GradeModule(currentUser, moduleCode1, grade1);
        testCommand1.execute();
        Command testCommand2 = new GradeModule(currentUser, moduleCode2, grade2);
        testCommand2.execute();

        assertTrue(currentUser.hasModule(moduleCode1));
        UserMod userMod1 = currentUser.getModule(moduleCode1);
        assertEquals(expectedGrade1, userMod1.getGrade().getGradePoint());

        assertTrue(currentUser.hasModule(moduleCode2));
        UserMod userMod2 = currentUser.getModule(moduleCode2);
        assertEquals(expectedGrade2, userMod2.getGrade().getGradePoint());

    }


    @Test
    public void invalidGrade() {
        String grade1 = "G";
        String moduleCode1 = "CG2028";
        int semester1 = 3;

        Command addModule1 = new AddUserModule(currentUser, moduleCode1, semester1);
        addModule1.execute();
        assertTrue(currentUser.hasModule(moduleCode1));

        Command testCommand1 = new GradeModule(currentUser, moduleCode1, grade1);
        testCommand1.execute();
        UserMod userMod1 = currentUser.getModule(moduleCode1);
        assertNull(userMod1.getGrade());
    }


}

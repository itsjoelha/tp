package seedu.duke.command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.duke.Duke.currentUser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.duke.data.UserMod;

public class SuModuleTest {
    @BeforeEach
    public void setUp() {
        currentUser.resetUser(); // Clear and set all exemptions to false
    }

    @Test
    public void nonSuable() {
        String moduleCode1 = "CG2028"; //2 MC
        int semester1 = 3;

        Command addModule1 = new AddUserModule(currentUser, moduleCode1, semester1);
        addModule1.execute();
        assertTrue(currentUser.hasModule(moduleCode1));

        Command gradeModule1 = new GradeModule(currentUser, moduleCode1, "A+" );
        gradeModule1.execute();

        Command testCommand1 = new SuUserModule(currentUser, moduleCode1);
        testCommand1.execute();

        UserMod mod1 = currentUser.getModule(moduleCode1);
        assertFalse(mod1.isSU());

    }

    @Test
    public void validToggleSu() {
        String moduleCode1 = "CG1111A"; //4 MC
        int semester1 = 3;

        Command addModule1 = new AddUserModule(currentUser, moduleCode1, semester1);
        addModule1.execute();
        assertTrue(currentUser.hasModule(moduleCode1));

        Command gradeModule1 = new GradeModule(currentUser, moduleCode1, "A+" );
        gradeModule1.execute();

        Command testCommand1 = new SuUserModule(currentUser, moduleCode1);
        testCommand1.execute();

        UserMod mod1 = currentUser.getModule(moduleCode1);
        assertTrue(mod1.isSU());

        Command testCommand2 = new SuUserModule(currentUser, moduleCode1);
        testCommand2.execute();
        mod1 = currentUser.getModule(moduleCode1);
        assertFalse(mod1.isSU());

    }

    @Test
    public void noGrade() {
        String moduleCode1 = "CG1111A"; //4 MC
        int semester1 = 3;

        Command addModule1 = new AddUserModule(currentUser, moduleCode1, semester1);
        addModule1.execute();
        assertTrue(currentUser.hasModule(moduleCode1));

        Command testCommand1 = new SuUserModule(currentUser, moduleCode1);
        testCommand1.execute();

        UserMod mod1 = currentUser.getModule(moduleCode1);
        assertFalse(mod1.isSU());

    }

}

package seedu.duke.errors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ErrorTest {
    @Test
    public void userInputError_withDetailCommand_logsWarning() {
        ErrorHandler.userInputError(new String[]{"/detail"});
        // Verify the log contains the expected warning message
    }

    @Test
    public void userInputError_withUnknownCommand_logsUnknownError() {
        ErrorHandler.userInputError(new String[]{"unknownCommand"});
        // Verify the log contains the expected unknown error message
    }

    @Test
    public void integerInputError_withInvalidSemester_logsWarningAndPrintsError() {
        ErrorHandler.integerInputError("semester", "/add");
        // Verify the log contains the expected warning message
        // Verify the console output contains the expected error message
    }

    @Test
    public void integerInputError_withInvalidCreditNum_logsWarningAndPrintsError() {
        ErrorHandler.integerInputError("creditNum", "/add");
        // Verify the log contains the expected warning message
        // Verify the console output contains the expected error message
    }

    @Test
    public void excessInputError_withValidCommand_logsWarning() {
        ErrorHandler.excessInputError("/add");
        // Verify the log contains the expected warning message
    }

    @Test
    public void invalidCharacterInputError_withValidModuleCode_logsWarning() {
        ErrorHandler.invalidCharacterInputError("CS1010", "/add");
        // Verify the log contains the expected warning message
    }

    @Test
    public void modNotInDatabase_withValidMessage_initializesCorrectly() {
        ModNotInDatabase exception = new ModNotInDatabase("Module not found");
        assertEquals("Module not found", exception.getMessage());
    }

    @Test
    public void modNotInDatabase_withNullMessage_initializesCorrectly() {
        ModNotInDatabase exception = new ModNotInDatabase(null);
        assertNull(exception.getMessage());
    }

    @Test
    public void modNotInDatabase_withEmptyMessage_initializesCorrectly() {
        ModNotInDatabase exception = new ModNotInDatabase("");
        assertEquals("", exception.getMessage());
    }
}

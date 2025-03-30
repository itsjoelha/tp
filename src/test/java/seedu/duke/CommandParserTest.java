package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.ListModules;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CommandParserTest {
    @Test
    public void parseCommand_validCommands() {
        CommandParser parser = new CommandParser();
        assertDoesNotThrow(() -> parser.parseCommand("/view"));
        assertDoesNotThrow(() -> parser.parseCommand("/detail CS2113"));
        assertDoesNotThrow(() -> parser.parseCommand("/grad"));
        assertDoesNotThrow(() -> parser.parseCommand("/add CS2113"));
        assertDoesNotThrow(() -> parser.parseCommand("/workload"));
        assertDoesNotThrow(() -> parser.parseCommand("/help"));
        assertDoesNotThrow(() -> parser.parseCommand("/view"));
        assertDoesNotThrow(() -> parser.parseCommand("/schedule"));
        assertDoesNotThrow(() -> parser.parseCommand("/specialisation"));
        assertDoesNotThrow(() -> parser.parseCommand("/delete CS2113"));
    }

    @Test
    public void parseCommand_unknownCommand() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream(); // Capture output
        System.setOut(new PrintStream(out)); // Redirect to out

        parser.parseCommand("/randomcommand");
        System.setOut(System.out); // Reset System.out

        assertEquals("Unknown command. Type '/help' for a list of commands.", out.toString().trim());
    }

    @Test
    public void parseCommand_invalidCommand() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        parser.parseCommand("/add");
        parser.parseCommand("/delete");
        System.setOut(System.out); // Reset System.out

        String expectedOutput = "Error: Please specify a module code to add."
                + System.lineSeparator() + "Usage: /add MODULE_CODE SEMESTER"
                + System.lineSeparator() + "Error: Please specify a module code to delete.";
        assertEquals(expectedOutput, out.toString().trim());
    }

    @Test
    public void parseCommand_addAndDeleteModule() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        parser.parseCommand("/add EG1311 2");  // Add module
        parser.parseCommand("/delete EG1311");  // Delete module
        System.setOut(System.out); // Reset System.out
        String output = out.toString().trim();

        assertTrue(output.contains("Module EG1311 successfully added to Semester 2"));
        assertTrue(output.contains("Module EG1311 successfully removed."));
    }

    @Test
    public void execute_noModulesInList() {
        // Capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Ensure the module list is empty before executing
            ListModules listModules = new ListModules();
            listModules.execute();
            assertEquals("=============== SEMESTER 1 ===============\n" +
                    "-------------------NULL-----------------\n" +
                    "=============== SEMESTER 2 ===============\n" +
                    "-------------------NULL-----------------\n" +
                    "=============== SEMESTER 3 ===============\n" +
                    "-------------------NULL-----------------\n" +
                    "=============== SEMESTER 4 ===============\n" +
                    "-------------------NULL-----------------\n" +
                    "=============== SEMESTER 5 ===============\n" +
                    "-------------------NULL-----------------\n" +
                    "=============== SEMESTER 6 ===============\n" +
                    "-------------------NULL-----------------\n" +
                    "=============== SEMESTER 7 ===============\n" +
                    "-------------------NULL-----------------\n" +
                    "=============== SEMESTER 8 ===============\n" +
                    "-------------------NULL-----------------", out.toString().trim());
        } finally {
            System.setOut(originalOut); // Always reset System.out
        }
    }

    @Test
    public void parseCommand_workloadEmptyList() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        parser.parseCommand("/workload");
        System.setOut(System.out); // Reset System.out

        assertEquals("No modules in List", out.toString().trim());
    }
}

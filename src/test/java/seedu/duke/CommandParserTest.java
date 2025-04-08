package seedu.duke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.command.ListModules;
import seedu.duke.user.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static seedu.duke.Duke.currentUser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CommandParserTest {
    @BeforeEach
    public void setUp() {
        currentUser.resetUser(); // Clear and set all exemptions to false
    }


    @Test
    public void parseCommand_unknownCommand() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream(); // Capture output
        System.setOut(new PrintStream(out)); // Redirect to out
        String[] testCommands = {"/randomCommand"};

        parser.callCommand(testCommands);
        System.setOut(System.out); // Reset System.out

        assertEquals("Unknown command. Type '/help' for a list of commands.", out.toString().trim());
    }

    @Test
    public void parseCommand_invalidCommand() {
        CommandParser parser = new CommandParser();
        String[] testCommand1 = {"/add", "9"};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> parser.callCommand(testCommand1));
    }

    @Test
    public void parseCommand_invalidCommand2() {
        CommandParser parser = new CommandParser();
        String[] testCommand2 = {"/delete"};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> parser.callCommand(testCommand2));
    }

    @Test
    public void parseCommand_addAndDeleteModule() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] testCommand1 = {"/add", "EG1311", "2"};
        String[] testCommand2 = {"/delete", "EG1311"};

        parser.callCommand(testCommand1);  // Add module
        parser.callCommand(testCommand2);  // Delete module
        System.setOut(System.out); // Reset System.out
        String output = out.toString().trim();

        assertTrue(output.contains("Module EG1311 successfully added to Semester 2"));
        assertTrue(output.contains("Module EG1311 successfully removed."));
    }

    @Test
    public void parseCommand_addCustomModule() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] testCommand1 = {"/addCustom", "PL1101E", "2", "4", "Intro to Psychology"};

        parser.callCommand(testCommand1);
        assertTrue(currentUser.hasModule("PL1101E"));

        System.setOut(System.out);
        String output = out.toString().trim();
        assertTrue(output.contains("Module PL1101E successfully added to Semester 2 as a Custom Module."));
    }

    @Test
    public void parseCommand_addCustomModuleInsufficientArguments() {
        CommandParser parser = new CommandParser();
        String[] testCommand = {"/addCustom", "PL1101E", "3"};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> parser.callCommand(testCommand));
        assertFalse(currentUser.hasModule("PL1101E"));
    }

    @Test
    public void parseCommand_addCustomModuleIncorrectArguments() {
        CommandParser parser = new CommandParser();
        String[] testCommand = {"/addCustom", "PL1101E", "this", "this", "this"};

        assertThrows(NumberFormatException.class, () -> parser.callCommand(testCommand));
        assertFalse(currentUser.hasModule("PL1101E"));

    }

    @Test
    public void parseCommand_addCustomModuleIncorrectArguments1() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));
        CommandParser parser = new CommandParser();
        String[] testCommand1 = {"/addCustom", "PL1101E", "4", "this", "this"};

        parser.callCommand(testCommand1);
        System.setOut(System.out);

        assertEquals("Error: Credit number must be a positive integer.", out.toString().trim());
    }

    @Test
    public void parseCommand_addCustomModuleInvalidInput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));
        CommandParser parser = new CommandParser();
        String[] testCommand = {"/addCustom", "||cs1010", "4", "4", "Programming Methodology"};

        parser.callCommand(testCommand);
        System.setOut(originalOut);

        assertEquals("Invalid characters found in /addCustom. Only alphanumeric characters are allowed.",
                out.toString().trim());

    }


    @Test
    public void execute_noModulesInList() {
        // Capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));
        User testUser = new User();

        try {
            // Ensure the module list is empty before executing
            ListModules listModules = new ListModules(testUser);
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
        currentUser.clearModules();
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] testCommand = {"/workload"};

        parser.callCommand(testCommand);
        System.setOut(System.out); // Reset System.out

        assertEquals("No modules in List", out.toString().trim());
    }

    @Test
    public void parseCommand_helpWithValidArg() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream(); // Capture output
        System.setOut(new PrintStream(out)); // Redirect to out
        String[] testCommands = {"/help", "grade"};

        parser.callCommand(testCommands);
        System.setOut(System.out); // Reset System.out

        String output = out.toString().trim();
        assertTrue(output.contains("Usage: /grade <module code> <grade>"));
        assertTrue(output.contains("Description: Set a module's grade."));
        assertFalse(output.contains("| Command                        | Description                          |"));
    }

    @Test
    public void parseCommand_gradExecutesSuccessfully() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] testCommand = {"/grad"};

        parser.callCommand(testCommand);
        System.setOut(System.out);

        String output = out.toString().trim();
        assertTrue(output.contains("Viewing Graduation Requirements"));
        assertTrue(output.contains("Current MCs:"));
    }

    @Test
    public void parseCommand_specExecutesSuccessfully() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] testCommand = {"/spec"};

        parser.callCommand(testCommand);
        System.setOut(System.out);

        String output = out.toString().trim();
        assertTrue(output.contains("SPECIALISATIONS"));
        assertTrue(output.contains("ADVANCED ELECTRONICS"));
    }

    @Test
    public void parseCommand_extraArgumentsFails() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] testCommand = {"/spec", "extraArg"};
        String[] testCommand1= {"/gpa", "extraArg"};
        String[] testCommand3 = {"/grad", "extraArg"};

        parser.callCommand(testCommand);
        parser.callCommand(testCommand1);
        parser.callCommand(testCommand3);
        System.setOut(System.out);

        String output = out.toString().trim();
        assertFalse(output.contains("SPECIALISATIONS"));
        assertTrue(output.contains("Error: The '/spec' command has too many arguments."));
        assertTrue(output.contains("Error: The '/gpa' command has too many arguments."));
        assertTrue(output.contains("Error: The '/grad' command has too many arguments."));
    }

    @Test
    public void parseCommand_detailExecutesSuccessfully() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] testCommand = {"/detail", "CS1010"};

        parser.callCommand(testCommand);
        System.setOut(System.out);

        String output = out.toString().trim();
        assertTrue(output.contains("CS1010"));
        assertTrue(output.contains("Prerequisites:"));
        assertTrue(output.contains("Preclusions:"));
    }

    @Test
    public void parseCommand_detailWithoutArgumentsFails() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] testCommand = {"/detail"};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> parser.callCommand(testCommand));
    }

    @Test
    public void parseCommand_viewExecutesSuccessfully() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] testCommand = {"/view"};

        parser.callCommand(testCommand);
        System.setOut(System.out);

        String output = out.toString().trim();
        assertTrue(output.contains("SEMESTER 1"));
        assertTrue(output.contains("SEMESTER 8"));
    }

    @Test
    public void parseCommand_viewWithSemesterExecutesSuccessfully() {
        CommandParser parser = new CommandParser();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] testCommand = {"/view", "3"};  // View modules in semester 3

        parser.callCommand(testCommand);
        System.setOut(System.out);

        String output = out.toString().trim();
        assertTrue(output.contains("SEMESTER 3"));
        assertFalse(output.contains("SEMESTER 1"));  // Should only show semester 3
    }
}


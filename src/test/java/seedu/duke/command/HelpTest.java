package seedu.duke.command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelpTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testHelpWithNoArguments() {
        Command help = new Help();
        help.execute();

        String output = outContent.toString();

        // Check for table headers
        assertTrue(output.contains("| Command                        | Description                          |"));

        // Check for some specific commands in the help menu
        assertTrue(output.contains("/view"));
        assertTrue(output.contains("/add <module code>"));
        assertTrue(output.contains("/gpa"));
        assertTrue(output.contains("/exit"));

        // Check for footer message
        assertTrue(output.contains("Type /help <command> for more information on a specific command."));
    }

    @Test
    void testHelpWithValidCommand() {
        Command helpView = new Help("view");
        helpView.execute();

        String output = outContent.toString();

        // Clear output for next test
        outContent.reset();

        // Check for view command help
        assertTrue(output.contains("Usage: /view"));
        assertTrue(output.contains("Description: View all modules."));
        assertTrue(output.contains("Usage: /view <semester>"));

        Command helpGrade = new Help("grade");
        helpGrade.execute();

        output = outContent.toString();

        // Check for grade command help
        assertTrue(output.contains("Usage: /grade <module code> <grade>"));
        assertTrue(output.contains("Description: Set a module's grade."));
    }

    @Test
    void testHelpWithInvalidCommand() {
        Command helpInvalid = new Help("invalidCommand");
        helpInvalid.execute();

        String output = outContent.toString();

        // Check for invalid command message
        assertTrue(output.contains("Unknown command. Type '/help' for a list of commands."));
    }

    @Test
    void testAllSpecificCommands() {
        // Array of all valid commands based on the switch case in Help.java
        String[] commands = {"view", "add", "addCustom", "su", "gpa", "grade", "delete", "detail", "grad",
                "schedule", "spec", "workload", "help", "exit"};

        for (String cmd : commands) {
            outContent.reset();

            Command helpCmd = new Help(cmd);
            helpCmd.execute();

            String output = outContent.toString();

            // Each command's help should contain its usage
            assertTrue(output.contains("Usage: /" + cmd),
                    "Help for '" + cmd + "' should contain its usage information");

            // Each command's help should contain its description
            assertTrue(output.contains("Description: "),
                    "Help for '" + cmd + "' should contain its description");
        }
    }

    @Test
    void testCommandsWithMultipleUsages() {
        // Test commands that have multiple usage patterns
        Command helpView = new Help("view");
        helpView.execute();

        String output = outContent.toString();
        assertTrue(output.contains("Usage: /view"));
        assertTrue(output.contains("Usage: /view <semester>"));

        outContent.reset();

        Command helpWorkload = new Help("workload");
        helpWorkload.execute();

        output = outContent.toString();
        assertTrue(output.contains("Usage: /workload"));
        assertTrue(output.contains("Usage: /workload <semester>"));
    }
}

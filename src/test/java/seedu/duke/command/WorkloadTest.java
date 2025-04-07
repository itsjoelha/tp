package seedu.duke.command;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.duke.Duke.currentUser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WorkloadTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        currentUser.clearModules(); // Clear the moduleList
        System.setOut(new PrintStream(outContent));

        // Add some test modules
        Command addCS2113 = new AddUserModule(currentUser, "CS2113", 3);
        addCS2113.execute();

        Command addCS2040C = new AddUserModule(currentUser, "CS2040C", 4);
        addCS2040C.execute();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testWorkloadAllSemesters() {
        // Test workload for all semesters
        Command workloadCommand = new Workload(currentUser);
        workloadCommand.execute();

        String output = outContent.toString();

        // Verify table headers are present
        assertTrue(output.contains("| Code      | Sem | MCs | Lecture Hrs | Tut Hrs | Lab Hrs | Proj Hrs | Prep Hrs |"));

        // Verify both modules' information is displayed
        assertTrue(output.contains("CS2113"));
        assertTrue(output.contains("CS2040C"));

        assertTrue(output.contains("| CS2113    | 3   |"));
        assertTrue(output.contains("| CS2040C   | 4   |"));
    }

    @Test
    public void testWorkloadSpecificSemester() {
        // Clear output from setup
        outContent.reset();

        // Test workload for semester 3 only
        Command workloadCommand = new Workload(currentUser, 3);
        workloadCommand.execute();

        String output = outContent.toString();

        // Verify CS2113 information is displayed
        assertTrue(output.contains("CS2113"));
        assertTrue(output.contains("2.0"));  // Lecture hours
        assertTrue(output.contains("1.0"));  // Tutorial hours

        // Verify CS2040C information is NOT displayed
        assertFalse(output.contains("CS2040C"));
    }

    @Test
    public void testWorkloadEmptyModuleList() {
        // Clear all modules
        currentUser.clearModules();
        outContent.reset();

        // Test workload for empty module list
        Command workloadCommand = new Workload(currentUser);
        workloadCommand.execute();

        String output = outContent.toString();

        // Verify appropriate message is displayed
        assertTrue(output.contains("No modules in List"));
    }

    @Test
    public void testWorkloadInvalidSemester() {
        outContent.reset();

        // Test workload for invalid semester (9 is outside valid range 1-8)
        Command workloadCommand = new Workload(currentUser, 9);
        workloadCommand.execute();

        String output = outContent.toString();

        // Verify error message is displayed
        assertTrue(output.contains("Invalid semester. Please choose a number between 1 and 8."));
    }

    @Test
    public void testWorkloadNonExistentSemester() {
        outContent.reset();

        // Test workload for a semester that exists but has no modules (e.g., semester 5)
        Command workloadCommand = new Workload(currentUser, 5);
        workloadCommand.execute();

        String output = outContent.toString();

        // Verify table header is displayed but no module information
        assertTrue(output.contains("| Code      | Sem | MCs | Lecture Hrs | Tut Hrs | Lab Hrs | Proj Hrs | Prep Hrs |"));
        assertFalse(output.contains("| CS2113"));
        assertFalse(output.contains("| CS2040C"));
    }
}

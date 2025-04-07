package seedu.duke.command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScheduleTest {
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
    void testJcSchedule() {
        Command scheduleJc = new RecommendedSchedule("jc");
        scheduleJc.execute();

        String output = outContent.toString();

        // Check for table formatting
        assertTrue(output.contains("+---------------------------------------------------------------+"));
        assertTrue(output.contains("| JC Schedule"));
        assertTrue(output.contains("+------+-----+------------------+------+-----+------------------+"));

        // Check for header row
        assertTrue(output.contains("| Year | Sem | Module Code      | Year | Sem | Module Code      |"));

        // Check for year and semester information
        assertTrue(output.contains("| 1    | 1   |"));
        assertTrue(output.contains("| 1    | 2   |"));
        assertTrue(output.contains("| 2    | 1   |"));
        assertTrue(output.contains("| 2    | 2   |"));
        assertTrue(output.contains("| 3    | 1   |"));
        assertTrue(output.contains("| 3    | 2   |"));
        assertTrue(output.contains("| 4    | 1   |"));
        assertTrue(output.contains("| 4    | 2   |"));

        // Check the formatting is correct and there exists some content in these positions
        assertTrue(output.matches("(?s).*\\| 2    \\| 1   \\| [A-Z0-9]{1,16}\\s*\\|.*"));
        assertTrue(output.matches("(?s).*\\| 4    \\| 1   \\| [A-Z0-9]{1,16}\\s*\\|.*"));
    }

    @Test
    void testPolySchedule() {
        Command schedulePoly = new RecommendedSchedule("poly");
        schedulePoly.execute();

        String output = outContent.toString();

        // Check for table formatting
        assertTrue(output.contains("+---------------------------------------------------------------+"));
        assertTrue(output.contains("| Poly Schedule"));
        assertTrue(output.contains("+------+-----+------------------+------+-----+------------------+"));

        // Check for header row
        assertTrue(output.contains("| Year | Sem | Module Code      | Year | Sem | Module Code      |"));

        // Check for year and semester information
        assertTrue(output.contains("| 1    | 1   |"));
        assertTrue(output.contains("| 1    | 2   |"));
        assertTrue(output.contains("| 2    | 1   |"));
        assertTrue(output.contains("| 2    | 2   |"));
        assertTrue(output.contains("| 3    | 1   |"));
        assertTrue(output.contains("| 3    | 2   |"));

        // Check for specific modules that should appear in the poly schedule
        assertTrue(output.contains("CG1111A"));
        assertTrue(output.contains("CS1010"));
        assertTrue(output.contains("MA1301"));
        assertTrue(output.contains("ES1103"));
        assertTrue(output.contains("GEC1XXX"));

    }
}

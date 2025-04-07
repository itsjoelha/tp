package seedu.duke.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpecialisationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Specialisation specialisationCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        specialisationCommand = new Specialisation();
    }

    @Test
    public void testSpecialisationDisplaysHeaders() {
        // Execute the specialisation command
        specialisationCommand.execute();

        // Check that the output contains the main header
        String output = outContent.toString();
        assertTrue(output.contains("SPECIALISATIONS"));

        // Check that all specialisation headers are displayed
        assertTrue(output.contains("ADVANCED ELECTRONICS"));
        assertTrue(output.contains("INDUSTRY 4.0"));
        assertTrue(output.contains("INTERNET OF THINGS (IoT)"));
        assertTrue(output.contains("ROBOTICS"));
        assertTrue(output.contains("SPACE TECHNOLOGY"));
    }

    @Test
    public void testSpecialisationDisplaysCourses() {
        // Execute the specialisation command
        specialisationCommand.execute();

        String output = outContent.toString();

        // Check for core courses from different specialisations
        assertTrue(output.contains("EE3408C Integrated Analog Design"));
        assertTrue(output.contains("EE3105 Beyond Sky – New Space Technology and Application"));

        // Check for elective courses from different specialisations
        assertTrue(output.contains("EE4218 Embedded Hardware System Design"));
        assertTrue(output.contains("ME4242 Soft Robotics"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
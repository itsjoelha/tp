package seedu.duke;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class CommandParserTest {
    @Test
    public void parseCommand_validCommands() {
        CommandParser parser = new CommandParser();
        assertDoesNotThrow(() -> parser.parseCommand("/view"));
        assertDoesNotThrow(() -> parser.parseCommand("/detail CS2113"));
        assertDoesNotThrow(() -> parser.parseCommand("/add CS2113"));
        assertDoesNotThrow(() -> parser.parseCommand("/specialisation"));
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
}

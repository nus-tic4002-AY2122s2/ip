package duke.parser;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import duke.commands.Command;
import duke.commands.ExitCommand;
import duke.commands.ListCommand;

public class ParserTest {

    private Parser parser;

    @BeforeEach
    public void setUp() {
        parser = new Parser();
    }


    /*
     * Tests for 0-argument commands =======================================================================
     */

    //@Test
    //public void parse_helpCommand_parsedCorrectly() {
    //    final String input = "help";
    //    parseAndAssertCommandType(input, HelpCommand.class);
    //}

    //@Test
    //public void parse_clearCommand_parsedCorrectly() {
    //    final String input = "clear";
    //    parseAndAssertCommandType(input, ClearCommand.class);
    //}

    @Test
    public void parse_listCommand_parsedCorrectly() {
        final String input = "list";
        parseAndAssertCommandType(input, ListCommand.class);
    }

    @Test
    public void parse_exitCommand_parsedCorrectly() {
        final String input = "bye";
        parseAndAssertCommandType(input, ExitCommand.class);
    }


    /**
     * Parses input and asserts the class/type of the returned command object.
     *
     * @param input to be parsed
     * @param expectedCommandClass expected class of returned command
     * @return the parsed command object
     */
    private <T extends Command> T parseAndAssertCommandType(String input, Class<T> expectedCommandClass) {
        final Command result = parser.parse(input);
        assertTrue(result.getClass().isAssignableFrom(expectedCommandClass));
        return (T) result;
    }
}

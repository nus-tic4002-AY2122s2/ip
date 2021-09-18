import exceptions.DukeStorageError;
import exceptions.DukeTaskInputException;
import org.junit.Test;
import task_classes.*;

import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static parser.Parser.toExtractDate;
import static parser.Parser.toExtractDescription;

public class ParserTest {
    @Test
    public void toExtractDateTest() throws DukeTaskInputException {
        String testingCommand = "event project meeting /at 2021-12-31 11:00 -> 2021-12-31 12:00";

        String expectedResult = "2021-12-31 11:00 -> 2021-12-31 12:00";

        assertEquals(expectedResult, toExtractDate(testingCommand.split(" ")));
    }

    @Test
    public void toExtractDescriptionTest() throws DukeTaskInputException {
        String testingCommand = "event project meeting /at 2021-12-31 11:00 -> 2021-12-31 12:00";

        String expectedResult = "project meeting";

        assertEquals(expectedResult, toExtractDescription(testingCommand.split(" ")));
    }
}

import exceptions.DukeStorageError;
import exceptions.DukeTaskInputException;
import org.junit.Test;
import parser.Parser;
import task_classes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static parser.Parser.*;

public class ParserTest {
    @Test
    public void toExtractDateTest() throws DukeTaskInputException {
        Parser pp = new Parser();
        String testingCommand = "event project meeting /at 2021-12-31 11:00 -> 2021-12-31 12:00";

        String expectedResult = "2021-12-31 11:00 -> 2021-12-31 12:00";

        assertEquals(expectedResult, pp.toExtractDate(testingCommand.split(" ")));
    }

    @Test
    public void toExtractDescriptionTest() throws DukeTaskInputException {
        String testingCommand = "event project meeting /at 2021-12-31 11:00 -> 2021-12-31 12:00";

        String expectedResult = "project meeting";

        assertEquals(expectedResult, toExtractDescription(testingCommand.split(" ")));
    }

    @Test
    public void convertStringArrayToStringTest() {
        String testStr = "I am going to sleep";
        String[] strT = testStr.split(" ");
        ArrayList<String> bufferA = new ArrayList<String>();

        bufferA.addAll(Arrays.asList(strT).subList(1, strT.length));

        String expectedResult = "am going to sleep";

        assertEquals(expectedResult, convertStringArrayToString(bufferA));
    }
}

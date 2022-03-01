import org.junit.jupiter.api.Test;
import task.DeadLines;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadLinesTest {

    @Test
    public void deadlinesTest() {
        DeadLines list = new DeadLines("deadline ThisTest", "2017-09-11 1100", false);
        assertEquals("(by: " + "11 Sep 2017 1100" + ")", list.getDetails());
    }
}

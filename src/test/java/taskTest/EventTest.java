package taskTest;

import duke.Parser;
import duke.task.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    Event event = new Event("meeting", "20-10-2021", Parser.convertDate("20-10-2021"));

    @Test
    void getStatusIconTest() {
        assertEquals("N", event.getStatusIcon());
    }

    @Test
    void toStringTest() {
        assertEquals("[E][N] meeting (at: 10月 20 2021)", event.toString());
    }

    @Test
    void save_toStringTest() {
        assertEquals("E | N | meeting | 20-10-2021", event.save_toString());
    }
}

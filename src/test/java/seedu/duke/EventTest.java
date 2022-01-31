package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    @Test
    void testGetEventDate() {

        assertEquals("(at: Mon 2-4pm)", new Event("project meeting","Mon 2-4pm"));
    }

    @Test
    void testGetTaskDetails() {

        assertEquals("[E][ ] project meeting (at: Mon 2-4pm)", new Event("project meeting", "Tue 2-4pm"));
    }

}

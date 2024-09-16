package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    @Test
    void testGetTaskDetails() {
        Event task = new Event("project meeting", "Tue 2-4pm");
        assertEquals("[E][ ] project meeting (at: Tue 2-4pm)", task.getTaskDetails());
    }

}

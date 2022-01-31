package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {

    @Test
    void testGetDeadline() {
        assertEquals("(by: Sunday)", new Deadline("return book","Sunday"));
    }

    @Test
    void testGetTaskDetails() {
        assertEquals("[D][ ] borrow book (by: Sunday)", new Deadline("return book", "Monday"));
    }
}

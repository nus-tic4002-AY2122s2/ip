package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    @Test
    void testGetTaskDetails() {
        Todo task = new Todo("borrow book");
        assertEquals("[T][ ] borrow book", task.getTaskDetails());
    }

    @Test
    void testGetTaskDetails2() {
        Todo task = new Todo("borrow book", true);
        assertEquals("[T][X] borrow book", task.getTaskDetails());
    }
}

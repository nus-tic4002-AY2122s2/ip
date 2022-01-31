package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    @Test
    void testGetTaskDetails() {
        assertEquals("[T][ ] borrow book", new Todo("borrow book"));
    }

    @Test
    void testGetTaskDetails2() {
        assertEquals("[T][ ] borrow book", new Todo("borrow book", true));
    }
}

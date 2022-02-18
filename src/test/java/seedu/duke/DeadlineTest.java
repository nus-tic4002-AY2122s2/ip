package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {

    @Test
    void testGetTaskDetails() {
        Deadline task = new Deadline("return book","Sunday");
        assertEquals("[D][ ] return book (by: Sunday)", task.getTaskDetails());
    }

}

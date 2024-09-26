package task;

import duke.task.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    Task task = new Task("join sports club");

    @Test
    void getStatusIconTest() {
        assertEquals("N", task.getStatusIcon());
    }

    @Test
    void toStringTest() {
        assertEquals("[N] join sports club", task.toString());
    }

    @Test
    void save_toStringTest() {
        assertEquals("N | join sports club", task.save_toString());
    }
}

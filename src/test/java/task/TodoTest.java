package task;

import duke.task.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    Todo todo = new Todo("join sports club");

    @Test
    void getStatusIconTest() {
        assertEquals("N", todo.getStatusIcon());
    }

    @Test
    void toStringTest() {
        assertEquals("[T][N] join sports club", todo.toString());
    }

    @Test
    void save_toStringTest() {
        assertEquals("T | N | join sports club", todo.save_toString());
    }
}

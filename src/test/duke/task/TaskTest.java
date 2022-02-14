package duke.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import duke.exception.DukeMissingDescException;


public class TaskTest {
    @Test
    public void setDoneTest() throws DukeMissingDescException {
        Task t = new ToDo("Test Task.");
        t.setDone(false);
        assertEquals(false, t.isDone);
        t.setDone(true);
        assertEquals(true, t.isDone);
    }
    @Test
    public void setDescriptionTest() throws DukeMissingDescException {
        String desc = "Test Task.";
        Task t = new ToDo(desc);
        desc = "Updated Description";
        t.setDescription(desc);
        assertEquals(desc, t.getDescription());
    }
}

package edu.nus.duke.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    @Test
    public void getTaskTest() {
        Task task = new Todo("Task1");
        String taskPrint = task.getTask();
        assertEquals("[T][ ] Task1", taskPrint);
    }
}

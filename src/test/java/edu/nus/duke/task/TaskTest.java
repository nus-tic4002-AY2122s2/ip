package edu.nus.duke.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void getTaskTest() {
        Task task = new Todo("Task1");
        String taskPrint = task.getTask();
        assertEquals("[T][ ] Task1", taskPrint);
    }
}

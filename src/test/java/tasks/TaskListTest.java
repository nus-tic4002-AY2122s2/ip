package tasks;

import exceptions.DukeException;
import org.junit.jupiter.api.Test;
import ui.Ui;


import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskListTest {

    @Test
    void getSize_success() throws DukeException {
        TaskList tasks = new TaskList();
        Ui ui = new Ui();
        tasks.addTask("todo", "running", "",ui);
        tasks.addTask("task", "jumping", "",ui);
        tasks.addTask("event", "hopping", "home",ui);
        tasks.addTask("deadline", "walking", "02/02/2020 10:10:10",ui);
        assertEquals(4, tasks.getSize());
    }

}
package edu.nus.duke.command;

import edu.nus.duke.task.Task;
import edu.nus.duke.task.TaskList;

public class AddCommand extends Command {
    // Variables
    public static final String cmd = "todo;deadline;event";
    private Task task;

    // Constructor
    public AddCommand(Task task) {
        this.task = task;
    }

    // Methods
    @Override
    public void run(TaskList taskList) {
        taskList.addTask(task);
    }
}

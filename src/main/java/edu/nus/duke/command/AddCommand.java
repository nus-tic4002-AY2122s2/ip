package edu.nus.duke.command;

import edu.nus.duke.task.Task;
import edu.nus.duke.task.TaskList;

public class AddCommand extends Command {
    // Variables
    private Task task;

    // Constructor
    public AddCommand(Task task) {
        super("todo;deadline;event");
        this.task = task;
    }

    // Methods
    @Override
    public void runCmd(TaskList taskList) {
        taskList.addTask(task);
    }
}

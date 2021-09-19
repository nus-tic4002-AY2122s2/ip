package edu.nus.duke.command;

import edu.nus.duke.task.Task;
import edu.nus.duke.task.TaskList;

public class AddCommand extends Command {
    // Variables
    private Task task;
    private TaskList taskList;

    // Constructor
    public AddCommand(Task task, TaskList taskList) {
        super("todo;deadline;event");
        this.task = task;
        this.taskList = taskList;
    }

    // Methods
    @Override
    public void runCmd() {
        taskList.addTask(task);
    }
}

package edu.nus.duke.command;

import edu.nus.duke.task.Task;
import edu.nus.duke.task.TaskList;

/**
 * Represent add command that extends from Command.
 */
public class AddCommand extends Command {
    // Variables
    public static final String CMD_TODO = "todo";
    public static final String CMD_DEADLINE = "deadline";
    public static final String CMD_EVENT = "event";
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

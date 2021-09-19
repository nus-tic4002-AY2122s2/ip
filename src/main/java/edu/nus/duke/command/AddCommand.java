package edu.nus.duke.command;

import edu.nus.duke.task.Task;
import edu.nus.duke.task.TaskList;

/**
 * Represent add command that extends from Command.
 */
public class AddCommand extends Command {
    // Variables
    public static final String cmdTodo = "todo";
    public static final String cmdDeadline = "deadline";
    public static final String cmdEvent = "event";
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

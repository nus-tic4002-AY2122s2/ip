package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

public abstract class Command {
    // Methods
    public abstract void run(TaskList taskList);
}

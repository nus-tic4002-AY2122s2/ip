package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

/**
 * Represent a command, for use as abstract class.
 */
public abstract class Command {
    // Methods
    /**
     * Run the command and return a CommandResult.
     *
     * @param taskList Duke TaskList.
     * @return CommandResult.
     */
    public abstract CommandResult run(TaskList taskList);
}

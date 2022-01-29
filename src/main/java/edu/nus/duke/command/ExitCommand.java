package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

/**
 * Represent exit command that extends from Command.
 */
public class ExitCommand extends Command {
    // Variables
    public static final String CMD = "bye";

    // Methods
    @Override
    public CommandResult run(TaskList taskList) {
        return (new CommandResult("Bye. Hope to see you again soon!", true));
    }
}

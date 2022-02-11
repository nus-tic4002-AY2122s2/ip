package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

/**
 * Represent exit command that extends from Command.
 */
public class ExitCommand extends Command {
    public static final String CMD = "bye";

    @Override
    public CommandResult run(TaskList taskList, CommandDataHistory commandDataHistory) {
        return (new CommandResult("Bye. Hope to see you again soon!", true));
    }
}

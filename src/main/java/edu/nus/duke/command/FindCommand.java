package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

/**
 * Represent find command that extends from Command.
 */
public class FindCommand extends Command {
    public static final String CMD = "find";
    private final String textFilter;

    public FindCommand(String textFilter) {
        this.textFilter = textFilter;
    }

    @Override
    public CommandResult run(TaskList taskList, CommandDataHistory commandDataHistory) {
        String feedback = taskList.printTasks("Here are the matching tasks in your list:", null, textFilter);
        return (new CommandResult(feedback, false));
    }
}

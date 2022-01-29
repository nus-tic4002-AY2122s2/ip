package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

/**
 * Represent find command that extends from Command.
 */
public class FindCommand extends Command {
    // Variables
    public static final String CMD = "find";
    private final String textFilter;

    // Constructor
    public FindCommand(String textFilter) {
        this.textFilter = textFilter;
    }

    // Methods
    @Override
    public CommandResult run(TaskList taskList) {
        String feedback = taskList.printTasks("Here are the matching tasks in your list:", null, textFilter);
        return (new CommandResult(feedback, false));
    }
}

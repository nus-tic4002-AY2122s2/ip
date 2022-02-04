package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

/**
 * Represent delete command that extends from Command.
 */
public class DeleteCommand extends Command {
    // Variables
    public static final String CMD = "delete";
    private int idx;

    // Constructor
    public DeleteCommand(int idx) {
        this.idx = idx;
    }

    // Methods
    @Override
    public CommandResult run(TaskList taskList, CommandDataHistory commandDataHistory) {
        commandDataHistory.add(taskList);
        String feedback = taskList.deleteTask(idx);
        return (new CommandResult(feedback, false));
    }
}

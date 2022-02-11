package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

/**
 * Represent done command that extends from Command.
 */
public class DoneCommand extends Command {
    public static final String CMD = "done";
    private int idx;

    public DoneCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public CommandResult run(TaskList taskList, CommandDataHistory commandDataHistory) {
        commandDataHistory.add(taskList);
        String feedback = taskList.doneTask(idx);
        return (new CommandResult(feedback, false));
    }
}

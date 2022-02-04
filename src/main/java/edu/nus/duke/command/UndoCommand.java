package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

public class UndoCommand extends Command {
    public static final String CMD = "undo";

    public CommandResult run(TaskList taskList, CommandDataHistory commandDataHistory) {
        return (new CommandResult("Undo success", false));
    }
}

package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

public class UndoCommand extends Command {
    public CommandResult run(TaskList taskList) {
        return (new CommandResult("Undo success", false));
    }
}

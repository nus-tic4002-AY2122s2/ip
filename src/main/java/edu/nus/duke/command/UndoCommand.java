package edu.nus.duke.command;

import edu.nus.duke.exception.DukeEmptyUndoException;
import edu.nus.duke.task.TaskList;

public class UndoCommand extends Command {
    public static final String CMD = "undo";

    @Override
    public CommandResult run(TaskList taskList, CommandDataHistory commandDataHistory) throws DukeEmptyUndoException {
        if (commandDataHistory.getSize() == 0) {
            throw new DukeEmptyUndoException();
        }
        return (new CommandResult("Undo success", false));
    }
}

package edu.nus.duke.command;

import edu.nus.duke.exception.DukeEmptyUndoException;
import edu.nus.duke.task.TaskList;

/**
 * Represent a command, for use as abstract class.
 */
public abstract class Command {
    /**
     * Run the command and return a CommandResult.
     *
     * @param taskList Duke TaskList.
     * @param commandDataHistory Duke CommandDataHistory.
     * @return CommandResult.
     * @throws DukeEmptyUndoException If size of commandDataHistory = 0.
     */
    public abstract CommandResult run(TaskList taskList, CommandDataHistory commandDataHistory)
            throws DukeEmptyUndoException;
}

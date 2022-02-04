package edu.nus.duke.command;

import java.util.ArrayList;

import edu.nus.duke.exception.DukeEmptyUndoException;
import edu.nus.duke.task.Task;
import edu.nus.duke.task.TaskList;

public class UndoCommand extends Command {
    public static final String CMD = "undo";

    @Override
    public CommandResult run(TaskList taskList, CommandDataHistory commandDataHistory) throws DukeEmptyUndoException {
        int historySize = commandDataHistory.getSize();

        if (historySize == 0) {
            throw new DukeEmptyUndoException();
        }

        ArrayList<Task> previousTaskList = commandDataHistory.pop();
        taskList.setTasks(previousTaskList);
        return (new CommandResult("Undo success", false));
    }
}

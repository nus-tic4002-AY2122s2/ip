package commands;

import exceptions.DukeTaskInputException;
import storage.Storage;
import task_classes.TaskList;
import ui.Ui;

public class ListCommand extends Command {

    public ListCommand() {

    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException {
        taskList.toPrintEntireTaskList();

    }

    @Override
    public boolean isExit() {
        return false;
    }
}

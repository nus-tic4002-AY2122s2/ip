package commands;

import exceptions.DukeTaskInputException;
import storage.Storage;
import task_classes.TaskList;
import ui.Ui;

public class ExitCommand extends Command {

    public ExitCommand() {

    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException {

    }

    @Override
    public boolean isExit() {
        return true;
    }
}

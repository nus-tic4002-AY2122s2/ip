package commands;

import exceptions.DukeDateTimeError;
import exceptions.DukeTaskInputException;
import storage.Storage;
import task_classes.TaskList;
import ui.Ui;

public abstract class Command {

    Command() {

    }

    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException, DukeDateTimeError;

    public abstract boolean isExit();
}

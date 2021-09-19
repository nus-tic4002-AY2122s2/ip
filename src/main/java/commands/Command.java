package commands;

import exceptions.DukeTaskInputException;
import storage.Storage;
import task_classes.TaskList;
import ui.Ui;

public abstract class Command {

    Command() {

    }

<<<<<<< HEAD
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException;
=======
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException, DukeDateTimeError, DukeTaskInputException;
>>>>>>> branch-Level-8

    public abstract boolean isExit();
}

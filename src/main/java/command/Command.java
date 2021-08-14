package command;

import exception.DukeException;
import storage.Storage;
import task.TaskList;
import ui.Ui;


public abstract class Command {

    protected boolean bExit = false;
    public boolean isExit(){
        return bExit;
    }
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
}

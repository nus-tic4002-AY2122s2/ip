package commands;

import exceptions.DukeTaskInputException;
import storage.Storage;
import task_classes.TaskList;
import task_classes.Task;
import ui.Ui;


public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    public void execute (TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException {
        if(taskList.isEmpty()){
            throw new DukeTaskInputException("listIsEmpty");
        }

        Task deletedTask = taskList.getTask(index);
        taskList.deleteTask(index);
        Ui.toPrintTaskDeletedMessage(deletedTask, taskList.size());
    }

    public boolean isExit() {
        return false;
    }
}

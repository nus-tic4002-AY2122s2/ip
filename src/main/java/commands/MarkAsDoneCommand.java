package commands;

import exceptions.DukeTaskInputException;
import storage.Storage;
import task_classes.TaskList;
import ui.Output_On_Screen;
import task_classes.Task;
import ui.Ui;

public class MarkAsDoneCommand extends Command{

    private int index;

    public MarkAsDoneCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException {

        int taskListSize = taskList.size();

        if(index >= taskListSize || index <= 0) {
            throw new DukeTaskInputException("listIsEmpty");
        }

        Task markAsDoneTask = taskList.getTask(index);
        markAsDoneTask.markAsDone();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

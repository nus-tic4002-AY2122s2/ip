package commands;

import exceptions.DukeTaskInputException;
import storage.Storage;
import task_classes.TaskList;
import ui.Ui;

public class MarkAsDoneCommand extends Command{

    private int index;

    public MarkAsDoneCommand(int index) {
        this.index = index - 1;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException {

        int taskListSize = taskList.size();

        if(index >= taskListSize || index <= 0) {
            throw new DukeTaskInputException("listIsEmpty");
        }

        taskList.getTask(index).markAsDone();
        ui.printMarkAsDoneOutput(taskList.getTask(index));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

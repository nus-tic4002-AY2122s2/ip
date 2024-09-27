package command;

import exception.ErrorHandler;
import storage.Storage;
import task.Task;
import taskList.TaskList;

public class DataCommand extends Command {
    private final Task task;

    public DataCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(Storage storage, TaskList taskList) throws ErrorHandler {
        try {
            taskList.addItem(this.task);
        } catch (ErrorHandler e) {
            throw new ErrorHandler(e.getMessage());
        }
    }
}

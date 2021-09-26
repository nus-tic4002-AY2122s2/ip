package command;

import exception.ErrorHandler;
import storage.Storage;
import task.Deadline;
import taskList.TaskList;
import ui.Ui;

public class DeadlineCommand extends Command{
    private String taskDescription;
    private String by;

    public DeadlineCommand(String taskDescription, String by)  {
        this.taskDescription = taskDescription;
        this.by = by;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList taskList) throws ErrorHandler {
        Deadline addedTodo = new Deadline(this.taskDescription, this.by, false);
        taskList.addItem(addedTodo);

        this.saveData(storage, taskList);
        ui.printTask(addedTodo.toString(), taskList.getSize());
    }
}

package command;

import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import task.Todo;
import taskList.TaskList;
import ui.Ui;

public class TodoCommand extends Command{
    private String taskDescription;

    public TodoCommand(String taskDescription)  {
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList taskList) throws ErrorHandler {
        Todo addedTodo = new Todo(this.taskDescription, false);
        taskList.addItem(addedTodo);

        this.saveData(storage, taskList);
        ui.printTask(addedTodo.toString(), taskList.getSize());
    }
}

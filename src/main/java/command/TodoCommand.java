package command;

import exception.ErrorHandler;
import storage.Storage;
import task.Todo;
import taskList.TaskList;

public class TodoCommand extends Command {
    private final String taskDescription;
    private final boolean status;

    public TodoCommand(String taskDescription, boolean status) {
        this.taskDescription = taskDescription;
        this.status = status;
    }

    @Override
    public void execute(Storage storage, TaskList taskList) throws ErrorHandler {
        Todo addedTodo = new Todo(this.taskDescription, this.status);
        taskList.addItem(addedTodo);

        this.saveData(storage, taskList);
        String information = "Got it. I've added this task:\n" + addedTodo + "\nNow you have " + " tasks " +
            taskList.getSize() + " in the list.";

        this.executionResult.setSystemMsg(information);
    }
}

package command;

import exception.ErrorHandler;
import storage.Storage;
import task.Deadline;
import taskList.TaskList;

public class DeadlineCommand extends Command {
    boolean status;
    private final String taskDescription;
    private final String by;

    public DeadlineCommand(String taskDescription, String by, boolean status) {
        this.taskDescription = taskDescription;
        this.by = by;
        this.status = status;
    }

    @Override
    public void execute(Storage storage, TaskList taskList) throws ErrorHandler {
        Deadline addedTodo = new Deadline(this.taskDescription, this.by, this.status);
        taskList.addItem(addedTodo);

        this.saveData(storage, taskList);

        String information =
            "Got it. I've added this task:\n" + addedTodo + "\nNow you have " + taskList.getSize() + " " +
                "tasks in the list.";

        this.executionResult.setSystemMsg(information);
    }
}

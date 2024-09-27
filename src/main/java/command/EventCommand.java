package command;

import exception.ErrorHandler;
import storage.Storage;
import task.Event;
import taskList.TaskList;

public class EventCommand extends Command {
    private final String taskDescription;
    private final String at;
    private final boolean status;

    public EventCommand(String taskDescription, String at, boolean status) {
        this.taskDescription = taskDescription;
        this.at = at;
        this.status = status;
    }

    @Override
    public void execute(Storage storage, TaskList taskList) throws ErrorHandler {
        Event addedTodo = new Event(this.taskDescription, this.at, this.status);
        taskList.addItem(addedTodo);

        this.saveData(storage, taskList);

        String information = "Got it. I've added this task:\n" + addedTodo + "\nNow you have " + " tasks " +
            taskList.getSize() + "in the list.";

        this.executionResult.setSystemMsg(information);
    }
}

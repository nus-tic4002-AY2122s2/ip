package command;

import exception.ErrorHandler;
import storage.Storage;
import task.Event;
import taskList.TaskList;
import ui.Ui;

public class EventCommand extends Command{
    private String taskDescription;
    private String at;

    public EventCommand(String taskDescription, String at)  {
        this.taskDescription = taskDescription;
        this.at = at;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList taskList) throws ErrorHandler {
        Event addedTodo = new Event(this.taskDescription, this.at, false);
        taskList.addItem(addedTodo);

        this.saveData(storage, taskList);
        ui.printTask(addedTodo.toString(), taskList.getSize());
    }
}

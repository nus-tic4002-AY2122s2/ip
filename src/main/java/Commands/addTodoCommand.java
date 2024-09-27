package Commands;

import Tasks.*;
import Storage.Storage;
import TaskList.TaskList;
import Ui.Ui;

public class addTodoCommand extends Command{
    public static final String COMMAND = "todo";

    public addTodoCommand(String des){
        super(des);

    }


    public String execute(TaskList tasklist, Ui ui, Storage storage){
        Task newTask = new toDos(description);
        tasklist.addTask(newTask);
        ui.newTodo(tasklist);
        return null;
    }
}
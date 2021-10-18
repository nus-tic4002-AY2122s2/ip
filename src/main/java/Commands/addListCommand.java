package Commands;

import Storage.Storage;
import TaskList.TaskList;
import Tasks.Task;
import Ui.Ui;

import java.io.UnsupportedEncodingException;

public class addListCommand extends Command {
    public static final String COMMAND = "list";

    public addListCommand(String input){
        super(input);
    }

    @Override
    public void execute(TaskList tasklist, Ui ui, Storage storage) throws UnsupportedEncodingException {
        ui.displayTaskList(description, tasklist);
    }
}
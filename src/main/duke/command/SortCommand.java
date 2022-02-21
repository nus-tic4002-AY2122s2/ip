package duke.command;

import java.util.ArrayList;
import java.util.Comparator;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;


public class SortCommand extends Command {


    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ArrayList<Task> arrayList = tasks.getTasks();
        arrayList.sort(Comparator.comparing(Task::getDescription));
        new ListCommand().execute(tasks, ui, storage);
    }
}

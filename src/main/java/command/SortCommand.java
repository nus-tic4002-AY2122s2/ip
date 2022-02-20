package command;

import storage.Storage;
import tasklist.TaskList;
import ui.UI;

import java.text.ParseException;

public class SortCommand extends Command{

    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) throws ParseException {
        return tasks.sortType();
    }
}
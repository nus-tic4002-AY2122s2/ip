package command;

import ui.UI;
import storage.Storage;
import tasklist.TaskList;


public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        tasks.list();
    }
}

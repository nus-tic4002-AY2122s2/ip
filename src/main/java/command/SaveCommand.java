package command;

import ui.UI;
import storage.Storage;
import tasklist.TaskList;

import java.io.FileNotFoundException;

public class SaveCommand extends Command{

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws FileNotFoundException {
        tasks.save(storage);
    }
}

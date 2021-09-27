package command;

import exception.DukeException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    String search_str;

    /**
     * Goes through the list of tasks, and attempt to find the results.
     * @param tasks     The current list of tasks
     * @param ui        Reference to the current UI
     * @param storage   Reference to current storage object we use to save/load from text file.
     * @throws DukeException
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ArrayList<Task> search_res = tasks.find(search_str);
        ui.printFindResultsMsg(search_res);
    }

    public FindCommand(String search_str) {
        this.search_str = search_str;
    }
}

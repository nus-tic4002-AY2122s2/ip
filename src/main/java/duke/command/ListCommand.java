package duke.command;

import duke.dukeException.DukeException;
import duke.ui.Ui;
import duke.task.TaskList;
import duke.storage.Storage;

public class ListCommand extends Command{

    /**
     * Constructs the list command
     */
    public ListCommand(){

    }

    /**
     * Execute the list command to show all the task the user has
     * @param tasks the task list
     * @param ui the Ui
     * @param storage the Storage
     * @throws DukeException any expected error
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (tasks.isEmpty()) {
            throw new DukeException("Empty task list");
        }
        for (int i = 0; i < tasks.getSize(); i++) {
            ui.showTaskInfo(tasks.getTask(i));
        }


    }
}

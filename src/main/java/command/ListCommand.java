package command;

import exception.DukeException;
import basic.TaskList;
import basic.Ui;

/**
 * Lists all tasks in the task list to the user.
 */
public class ListCommand extends Command {
    protected static Ui ui = new Ui();

    /**
     * @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     */
    @Override
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        if (tasks.sizeOfTask() == 0) {
            throw new DukeException("☹ The list is empty.");
        }
        ui.printTask(tasks);
        ui.printEmptyLine();
    }

}

package commands;

import exceptions.DukeException;
import storage.Storage;
import tasks.TaskList;
import ui.Ui;

/**
 * This represents the command to delete a specific task from the task list.
 */
public class DeleteCommand extends Command {
    int option = 0;

    /**
     * This is the constructor for the DeleteCommand.
     *
     * @param option This indicates the Task that the user wants to delete
     */
    public DeleteCommand(int option) {
        this.option = option;
    }

    /**
     * This executes the DeleteCommand. It will call the deleteTask method.
     *
     * @param tasks   This is the Task List that contains the list of tasks.
     * @param ui      This is the ui, to be used for scanning and printing
     * @param storage This is the storage, used to read and write over the file.
     * @throws DukeException throws IOException due to incorrect input
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            tasks.deleteTask(option - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Input option for Delete Command invalid.");
        }
        ui.storeMessage(tasks.printList());
    }

    public static void printHelp(Ui ui) {
        ui.storeMessage("Deleting a task from the list: delete [option number]");
    }
}

package commands;

import exceptions.DukeException;
import storage.Storage;
import tasks.TaskList;
import ui.Ui;


/**
 * This represents the change done command. It is used to change the task from the task list to its
 * done "state".
 */

public class ChangeDoneCommand extends Command {
    private int option = 0;
    private boolean isDone;

    /**
     * This is the constructor of the ChangeDoneCommand.
     *
     * @param option indicates the Task option that the user wants to change
     */
    public ChangeDoneCommand(int option, boolean isDone) {
        this.option = option;
        this.isDone = isDone;
    }

    /**
     * This executes the DoneCommand.
     *
     * @param tasks   This is the Task List that contains the list of tasks.
     * @param ui      This is the ui, to be used for scanning and printing
     * @param storage This is the storage, used to read and write over the file.
     * @throws DukeException when option is not within the range of 1 and TaskList Size
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            String doneLevel;
            tasks.get(option - 1).changeDoneTo(isDone);
            if (isDone) {
                doneLevel = " done:";
            } else {
                doneLevel = " not done:";
            }

            ui.storeMessage("\n" + "Nice! I've marked this task as" + doneLevel
                    + "\n" + tasks.get(option - 1).toString());


        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Input option for ChangeDone Command invalid");
        }
        return;
    }

    public static void printHelp(Ui ui) {
        ui.storeMessage("Changing a task to done: done [option number]");
        ui.storeMessage("Changing a task to undone: undone [option number]");
    }
}

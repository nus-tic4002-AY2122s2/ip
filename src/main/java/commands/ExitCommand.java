package commands;

import storage.Storage;
import tasks.TaskList;
import ui.Ui;

import java.io.IOException;

/**
 * This represents the exit command. It is used to change the running boolean to false.
 * Afterwards, during execution, it will write the tasks into the file.
 */
public class ExitCommand extends Command {

    /**
     * This is the constructor for ExitCommand. It will change the running boolean to false.
     */
    public ExitCommand() {
        this.running = false;
    }

    /**
     * This is the execution of the ExitCommand. It will write the tasks from the TaskList
     * to the storage.
     *
     * @param tasks   This is the Task List that contains the list of tasks.
     * @param ui      This is the ui, to be used for scanning and printing
     * @param storage This is the storage, used to read and write over the file.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        assert (!running) : "running should not be true at this stage. It should be false";
        ui.storeMessage("Executing Exit Command: Saving Task List to storage");
        ui.storeMessage(storage.save(tasks));
        ui.storeMessage("Finished saving Task List to storage");
    }

    public static void printHelp(Ui ui) {
        ui.storeMessage("To close this application: bye");
    }

}

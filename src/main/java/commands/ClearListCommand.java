package commands;

import exceptions.DukeException;
import storage.Storage;
import tasks.TaskList;
import ui.Ui;

import java.io.IOException;

public class ClearListCommand extends Command {
    public ClearListCommand() {
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException, IOException {
        ui.storeMessage("Clearing all tasks in the tasklist.");
        tasks.clearAllTasks();
        ui.storeMessage(tasks.printList());
    }

    public static void printHelp(Ui ui) {
        ui.storeMessage("Clearing the task list: /clear");
    }
}

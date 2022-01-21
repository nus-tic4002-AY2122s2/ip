package duke;

import java.io.IOException;

import duke.commands.Command;
import duke.commands.ExitCommand;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.storage.Storage.InvalidStorageFilePathException;
import duke.storage.Storage.StorageOperationException;
import duke.task.TaskList;
import duke.ui.Ui;

public class Duke {


    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    /**
     * The main entry point to the application.
     */
    public Duke(String filePath) {
        ui = new Ui();
        try {
            storage = new Storage(filePath);
            tasks = new TaskList(storage.load());
        } catch (StorageOperationException | InvalidStorageFilePathException | IOException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }
    public static void main(String[] args) {
        new Duke(System.getProperty("user.dir") + "/data/duke.txt").run();
    }

    /**
     * Runs the application.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = new Parser().parse(fullCommand);
                c.setData(tasks);
                c.execute();
                storage.save(tasks);
                isExit = ExitCommand.isExit(c);
            } catch (Exception e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

}

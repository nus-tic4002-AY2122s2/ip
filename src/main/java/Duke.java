

import commands.Command;
import exceptions.DukeException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import parser.Parser;
import storage.Storage;
import tasks.TaskList;
import ui.Ui;

import java.io.IOException;

// Individual Features:
//Better Search - e.g., find items even if the keyword matches the item only partially.
// Snooze - Provide a way to easily snooze/postpone/reschedule tasks.
// 'Do within a period' task
// - Provide support for managing tasks that need to be done within a certain period
// e.g., collect certificate between Jan 15 and 25th.


public class Duke extends Application {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;


    /**
     * Used to create a new Duke Instance. Initialise the ui,storage and tasks.
     * tasks will load from the storage. If there is an error, it will initialise on its own.
     * @throws IOException throws IOException due to incorrect input
     */

    /*
    public Duke() throws IOException {
        String filePath = "";
        ui = new Ui();
        storage = new Storage(filePath);
        parser = new Parser();
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }
    */

    /**
     * Used to keep the Duke Chat bot running. Scan for input then Parse the input into a command
     * Afterwards, execute the command. The process will keep running until the user types "bye"
     *
     * @throws IOException throws IOException due to incorrect input
     */
    public void run() throws IOException {
        Command c;
        String input;
        ui.printIntro();

        boolean isRunning = true;
        while (isRunning) {
            try {
                input = ui.scanForInput();
                ui.showLine();
                c = parser.parse(input);
                c.execute(tasks, ui, storage);
                isRunning = c.isRunning();
            } catch (DukeException e) {
                ui.showError(e.getErrorMessage());
            } finally {
                ui.showLine();
            }
        }

        ui.printBye();

    }

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }

}

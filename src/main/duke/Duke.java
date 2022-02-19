package duke;

import duke.command.Command;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Parser;
import duke.task.TaskList;
import duke.ui.Ui;
import javafx.application.Application;
import javafx.stage.Stage;

public class Duke extends Application {
    private TaskList tasks;
    private Ui ui;
    private Storage storage;

    @Override
    public void start(Stage stage) throws DukeException {
        System.out.println("On Start.");
        ui = new Ui(this, stage);
        storage = new Storage("data/duke.txt");
        tasks = new TaskList(storage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     */
    public void runOnce(String fullCommand) {
        try {
            Command c = Parser.parseInput(fullCommand);
            c.execute(tasks, ui, storage);
        } catch (DukeException e) {
            ui.printErrorMsg(e);
        } catch (IndexOutOfBoundsException e) {
            // should be due to unable to find.
            ui.printToUI("Unable to find task, please try again.");
        } catch (NumberFormatException e) {
            ui.printErrorMsg(e);
            throw e;
        }
    }
}

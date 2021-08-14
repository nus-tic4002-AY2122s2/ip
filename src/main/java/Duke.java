import command.Command;
import exception.DukeException;
import storage.Storage;
import task.*;
import ui.Ui;

public class Duke {
    private TaskList tasks;
    private Ui ui;
    private Storage storage;

    public Duke() {
        storage = new Storage("data/duke.txt");
        ui = new Ui();
        try {
            tasks = new TaskList(storage);
        } catch (DukeException e) {
            ui.printErrorMsg(e);
        }
    }

    /**
     * Run loop of Duke.
     */
    public void run() {
        boolean running = true;
        ui.printHelloMsg();
        while (running) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parseInput(fullCommand);
                c.execute(tasks, ui, storage);
                running = !c.isExit();
            } catch (DukeException e) {
                ui.printErrorMsg(e);
            } catch (IndexOutOfBoundsException e) {
                ui.printErrorMsg(e);
            }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}

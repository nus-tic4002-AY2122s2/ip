import command.Command;
import parser.Parser;
import storage.Storage;
import tasklist.*;
import ui.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private UI ui;

    public Duke(String filePath) {
        ui = new UI();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage);
        } catch ( IOException e) {
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.printDuke();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.printLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (FileNotFoundException | ParseException e) {
                e.printStackTrace();
            } finally {
                ui.printLine();
            }
        }
    }

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }
}
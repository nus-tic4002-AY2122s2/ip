
package basic;

import command.Command;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Runs basic.Duke program as long as isExit is false
 * Passes tasks entered by user to Storage class
 */
public class Duke extends Application {
    public Ui ui;
    public TaskList tasks;
    public Storage storage;
    private String response;

    public Duke() throws FileNotFoundException, UnsupportedEncodingException {
        ui = new Ui();
        storage = new Storage();
        tasks = new TaskList(storage.load());
    }

    @Override
    public void start(Stage stage) {

    }


    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            response =  c.execute(tasks, ui, storage);
            storage.save(tasks.returnList());
            return " Duke: " + response;
        } catch (Exception e) {
            return " Duke: " + e.toString();
        }
    }

    private void run() throws FileNotFoundException, UnsupportedEncodingException {
        // storage.load();
    }

    /**
     * Runs Duke.
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        new Duke().run();
    }
}

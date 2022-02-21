import command.Command;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import parser.Parser;
import storage.Storage;
import tasklist.*;
import ui.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;


public class Duke {

    public Storage storage;
    public TaskList tasks;
    public UI ui;

    public Duke(String filePath) {
        ui = new UI();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage);
        } catch ( IOException e) {
            tasks = new TaskList();
        }
    }

    public String getResponse(String input, Stage stage) {
        boolean isExit;
        String response = "";
            try {
                Command c = Parser.parse(input);
                response = c.execute(tasks, ui, storage);
                isExit = c.isExit();
                if (isExit) {
                    stage.close();
                }
            } catch (FileNotFoundException | ParseException e) {
                e.printStackTrace();
            }
        return response;
    }
}
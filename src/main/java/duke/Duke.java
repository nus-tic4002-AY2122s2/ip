package duke;

import java.io.IOException;

import duke.commands.Command;
import duke.commands.ExitCommand;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.storage.Storage.InvalidStorageFilePathException;
import duke.storage.Storage.StorageOperationException;
import duke.task.TaskList;
import duke.ui.MainWindow;
import duke.ui.Ui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Duke extends Application {


    private Ui ui;
    private Storage storage;
    private TaskList tasks;
    private MainWindow mainWindow;

    @Override
    public void init() {
//        ui = new Ui();
        try {
            storage = new Storage(System.getProperty("user.dir") + "/data/duke.txt");
            tasks = new TaskList(storage.load());
        } catch (StorageOperationException | InvalidStorageFilePathException | IOException e) {
//            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * The main entry point to the application.
     */
    /*public Duke(String filePath) {
        ui = new Ui();
        try {
            storage = new Storage(filePath);
            tasks = new TaskList(storage.load());
        } catch (StorageOperationException | InvalidStorageFilePathException | IOException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }*/

//    public static void main(String[] args) {
//        //new Duke(System.getProperty("user.dir") + "/data/duke.txt").run();
//        Application.launch(args);
//    }

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
                String commandResult = c.execute();
                ui.showResponse(commandResult);
                storage.save(tasks);
                isExit = ExitCommand.isExit(c);
            } catch (Exception e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    @Override
    public void start(Stage stage) {
        mainWindow = new MainWindow(stage, ui, storage, tasks);
        mainWindow.show();
//            Parent root = FXMLLoader.load(getClass().getResource("/view/MainWindow.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
            /*
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDuke(duke);
            stage.show();
            */
    }

}

package duke;

import duke.dukeCommand.Command;
import duke.dukeException.DukeException;
import duke.dukeParser.DukeParser;
import duke.dukeStorage.DukeStorage;
import duke.dukeTaskList.DukeTaskList;
import duke.dukeUI.DukeUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class Duke extends Application{
    private DukeStorage storage;
    private DukeTaskList taskList;
    private DukeUI ui;

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    @Override
    public void start(Stage stage) {
        //Step 1. Setting up required components

        //The container for the content of the chat to scroll.
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);

        stage.setScene(scene);
        stage.show();

        // more code to be added here later
        System.out.println("hello from start");
        new Duke("taskList.txt").run();
    }

    public Duke(String filePath) {
        ui = new DukeUI();
        storage = new DukeStorage(filePath);
        taskList = new DukeTaskList();
    }
    /*
    public static void main(String[] args) {
        new Duke("taskList.txt").run();
    }
    */
    public void run() {
        ui.welcomeMessage();
        try{
            storage.readFile();
        }catch(IOException | ParseException | DukeException e){
            System.out.println(e);
        }

        while (true) {
            try {
                String fullCommand = ui.readUserInput();
                Command c = DukeParser.parseInput(fullCommand);
                c.execute(taskList, ui, storage);
            }catch (Exception e) {
                ui.showError(e.getMessage());
            }
        }
    }


}
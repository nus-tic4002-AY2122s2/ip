import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import storage.Storage;
import taskclasses.TaskList;
import ui.Ui;

/*
    15th Jan 2022, Repo to the new upstream repo (https://github.com/nus-tic4002-AY2122S2/ip)
 */

public class Duke extends Application {

    private TaskList taskList;
    private Ui ui;
    private Storage storage;
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

/*
    *//**
     * initialize Duke function
     *
     * @param filePath the target file location in local drive to store or extract task data from
     * @throws IOException handles all input error
     *//*
    public Duke(String filePath) throws IOException {
        ui = new Ui();
        ui.showGreetingMessage();
        storage = new Storage(filePath);

        try {
            taskList = new TaskList(storage.load());
        } catch (DukeStorageError | DukeDateTimeError e) {
            ui.showLoadingError();
            taskList = new TaskList();
        }
    }

    *//**
     * Start Duke
     *
     * @throws IOException Handle all input errors
     *//*
    private void run() throws IOException {
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Ui.toPrintSeparateLine(); // show the divider line ("________")
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (DukeTaskInputException e) {
                String errorType = DukeTaskInputException.getErrorType();

                switch (errorType) {
                case "taskListEmpty":
                    DukeTaskInputException.toPrintListIsEmptyError();
                    break;
                case "commandCreateError":
                    DukeTaskInputException.toPrintCommandCreateError();
                    break;
                case "cannotUnderstand":
                    DukeTaskInputException.invalidFirstWordInput();
                    break;
                default:
                    DukeTaskInputException.formatWrong();
                }
            } catch (Exception e) {
                DukeTaskInputException.formatWrong();
            } catch (DukeDateTimeError e) {
                System.out.println("     OOps! The input dateTime format wrong. Please try again.");
            } finally {
                Ui.toPrintSeparateLine();
                System.out.println("");
            }
        }

        storage.transferToFile(taskList.getVectorList());
    }

    public static void main(String[] args) throws IOException, DukeStorageError {
        //new Duke("data/dukeTasks.txt").run();
    }*/

    @Override
    public void start(Stage stage) {

        //Step 1: Setting up required components

        //The container for the content of the chat to scroll.
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.

        //Step 2: Formatting the window to look as expected
        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        // You will need to import `javafx.scene.layout.Region` for this.
        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        
    }
}

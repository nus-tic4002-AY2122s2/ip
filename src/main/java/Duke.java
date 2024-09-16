

import commands.Command;
import exceptions.DukeException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;




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

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    private boolean isRunning = true;
    Command co;

    /**
     * Used to create a new Duke Instance. Initialise the ui,storage and tasks.
     * tasks will load from the storage. If there is an error, it will initialise on its own.
     * @throws IOException throws IOException due to incorrect input
     */

    /*
    public Duke() throws IOException {

    }
    */

    /**
     * Used to keep the Duke Chat bot running. Scan for input then Parse the input into a command
     * Afterwards, execute the command. The process will keep running until the user types "bye"
     *
     * @throws IOException throws IOException due to incorrect input
     */

    /*
    public void run() throws IOException {

        ui.printIntro();

        while (isRunning) {

        }

        ui.printBye();

    }


     */
    @Override
    public void start(Stage stage) throws IOException {

        String filePath = "data/tasks.txt";
        ui = new Ui();
        storage = new Storage(filePath, ui);
        parser = new Parser();
        try {
            tasks = new TaskList(storage.load(), ui);
        } catch (DukeException e) {
            ui.storeMessage(ui.showLoadingError());
            tasks = new TaskList();
        }


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

        AnchorPane.setLeftAnchor(userInput, 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);


        //Step 3. Add functionality to handle user input.


        Label dukeIntro = new Label(ui.printIntro());
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(dukeIntro, new ImageView(duke))
        );



        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
            if (isRunning == false) {
                Platform.exit();
            }
        });

        userInput.setOnAction((event) -> {
            handleUserInput();
            if (isRunning == false) {
                Platform.exit();
            }
        });

        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

    }

    /**
     * Iteration 1:
     * Creates a label with the specified text and adds it to the dialog container.
     * @param text String containing text to add
     * @return a label with the specified text that has word wrap enabled.
     */
    private Label getDialogLabel(String text) {
        Label textToAdd = new Label(text);
        textToAdd.setWrapText(true);
        return textToAdd;
    }

    private void handleUserInput() {

        String input = userInput.getText();
        Label userText = new Label(input);

        Label dukeText = new Label(getResponse(input));
        ui.clearMessages();

        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, new ImageView(user)),
                DialogBox.getDukeDialog(dukeText, new ImageView(duke))
        );
        userInput.clear();
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    private String getResponse(String input) {

        try {
            co = parser.parse(input);
            co.execute(tasks, ui, storage);
            isRunning = co.isRunning();
        } catch (DukeException e) {
            ui.storeMessage(e.getErrorMessage());
        } catch (IOException e) {
            ui.storeMessage("Your input was incorrect. Please input again. type /help for help.");
        }

        return "Duke Replied:\n" + ui.getMessages();
    }

}

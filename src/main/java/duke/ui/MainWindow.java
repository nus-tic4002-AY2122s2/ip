package duke.ui;

import duke.Duke;
import duke.commands.Command;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends UiPart<Stage> {

    private static final String FXML = "MainWindow.fxml";

    private Stage stage;
    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    //private Duke duke;

    private Image userImage;
    private Image dukeImage;

    public MainWindow(Stage stage, Ui ui, Storage storage, TaskList tasks) {
        super(FXML, stage);
        this.stage = stage;
        this.ui = ui;
        this.storage = storage;
        this.tasks = tasks;
    }
    @FXML
    public void initialize() {
        userImage = new Image(Duke.class.getResourceAsStream("/images/DaUser.png"));
        dukeImage = new Image(Duke.class.getResourceAsStream("/images/DaDuke.png"));
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog("hello", dukeImage).getRoot(),
                DialogBox.getDukeDialog("list", dukeImage).getRoot()
        );
    }

/*    public void setDuke(Duke d) {
        duke = d;
    }*/

    public void show() {
        stage.show();
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() throws Storage.StorageOperationException {
        String input = userInput.getText();
        Command c = new Parser().parse(input);
        c.setData(tasks);
        String response = c.execute();
        //String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage).getRoot(),
                DialogBox.getDukeDialog(response, dukeImage).getRoot()
        );
        userInput.clear();
        storage.save(tasks);
    }
}
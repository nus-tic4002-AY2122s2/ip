package edu.nus.duke.view;

import edu.nus.duke.Duke;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class MainWindow extends VBox {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;

    private Duke duke;
    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/user.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/duke.png"));

    /**
     * Set ScrollPane to auto scroll with new user inputs.
     */
    public void setAutoScrollPane() {
        dialogContainer.heightProperty().addListener((observable -> scrollPane.setVvalue(1.0)));
    }

    /**
     * Set up Duke.
     * @param duke Duke class.
     */
    public void setDuke(Duke duke) {
        this.duke = duke;
    }

    /**
     * Add initial Duke DialogBox.
     */
    public void initDukeFeedback() {
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog("Hello! I'm Duke\nWhat can I do for you?", dukeImage));
    }

    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String feedback = duke.getResponse(input);
        dialogContainer.getChildren().addAll(DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(feedback, dukeImage));
        userInput.clear();
    }
}

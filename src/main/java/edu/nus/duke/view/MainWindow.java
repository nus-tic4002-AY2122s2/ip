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

    public void initScrollPane() {
        dialogContainer.heightProperty().addListener((observable -> scrollPane.setVvalue(1.0)));
    }

    public void setDuke(Duke duke) {
        this.duke = duke;
    }

    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String feedback = duke.getResponse(input);
        dialogContainer.getChildren().addAll(new DialogBox(input, userImage), new DialogBox(feedback, userImage));
        userInput.clear();
    }
}

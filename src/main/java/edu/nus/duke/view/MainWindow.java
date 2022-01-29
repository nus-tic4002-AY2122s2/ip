package edu.nus.duke.view;

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

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/user.png"));

    public void initScrollPane() {
        dialogContainer.heightProperty().addListener((observable -> scrollPane.setVvalue(1.0)));
    }

    @FXML
    private void handleUserInput() {
        dialogContainer.getChildren().add(new DialogBox(userInput.getText(), userImage));
        userInput.clear();
    }
}

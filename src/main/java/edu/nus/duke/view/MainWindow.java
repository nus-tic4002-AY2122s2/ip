package edu.nus.duke.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainWindow extends VBox {
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private void handleUserInput() {
        dialogContainer.getChildren().add(new Label(userInput.getText()));
        userInput.clear();
    }
}

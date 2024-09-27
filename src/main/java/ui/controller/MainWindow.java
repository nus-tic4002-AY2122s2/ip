package ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import taskExecutor.TaskExecutor;

import static java.util.Objects.requireNonNull;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ListView taskListView;

    @FXML
    private TextField userInput;
    @FXML
    private TextArea systemOutput;

    private TaskExecutor taskExecutor;

    @FXML
    public void initialize() {
        systemOutput.setEditable(false);
    }


    public void setTaskExecutor(TaskExecutor d) {
        taskExecutor = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        taskExecutor.execute(input);

        String err = taskExecutor.getErrorMessage();
        if (err.equals("")) {
            systemOutput.setText(taskExecutor.getSystemMessage());
            userInput.clear();

            requireNonNull(taskExecutor.getResult());
            taskListView.getItems().setAll(taskExecutor.getResult());
        } else {
            systemOutput.setText(taskExecutor.getErrorMessage());
        }
    }
}

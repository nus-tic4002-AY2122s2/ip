package duke.ui;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import duke.Duke;
import duke.task.Task;
import duke.task.TaskList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Primarily for printing messages to console, also passes input to Parser. Refer to A-MoreOOP
 */
public class Ui {
    private Duke duke;
    private boolean awaitingInput;
    private boolean isEditingTodo;
    private Scanner input;
    private ScrollPane scrollPane;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private VBox dialogContainer;
    private String newDesc;
    private String newDateStr;


    /**
     * @param duke  reference to main duke program
     * @param stage reference to stage used in JavaFX
     */
    public Ui(Duke duke, Stage stage) {
        this.duke = duke;
        awaitingInput = false;
        newDesc = "";
        newDateStr = "";
        input = new Scanner(System.in);
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

        sendButton.setOnMouseClicked((event) -> {
            String a = userInput.getText();
            if (!(a.isEmpty() || a.isBlank())) {
                dialogContainer.getChildren().add(getDialogLabel(a, Color.DARKGREEN, false));
                if (awaitingInput) {
                    if (newDesc.isBlank() || newDesc.isEmpty()) {
                        newDesc = a;
                        if (isEditingTodo()) {
                            setAwaitingInput(false);
                        }
                    } else if (newDateStr.isBlank() || newDateStr.isEmpty()) {
                        newDateStr = a;
                        setAwaitingInput(false);
                    }
                } else {
                    duke.runOnce(a);
                }
                userInput.clear();
            }
        });

        userInput.setOnAction((event) -> {
            String a = userInput.getText();
            if (!(a.isEmpty() || a.isBlank())) {
                dialogContainer.getChildren().add(getDialogLabel(a, Color.DARKGREEN, false));
                if (awaitingInput) {
                    if (newDesc.isBlank() || newDesc.isEmpty()) {
                        newDesc = a;
                        if (isEditingTodo()) {
                            setAwaitingInput(false);
                        }
                    } else if (newDateStr.isBlank() || newDateStr.isEmpty()) {
                        newDateStr = a;
                        setAwaitingInput(false);
                    }
                } else {
                    duke.runOnce(a);
                }
                userInput.clear();
            }
        });

        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

        printHelloMsg();
    }


    public boolean isEditingTodo() {
        return isEditingTodo;
    }

    public void setEditingTodo(boolean editingTodo) {
        isEditingTodo = editingTodo;
    }


    public boolean isAwaitingInput() {
        return awaitingInput;
    }

    public void setAwaitingInput(boolean awaitingInput) {
        this.awaitingInput = awaitingInput;
    }

    public String getNewDesc() {
        return newDesc;
    }

    public String getNewDateStr() {
        return newDateStr;
    }

    /**
     * Resets input string after editing a task
     */
    public void resetInputStrings() {
        newDesc = "";
        newDateStr = "";
    }

    /**
     * Iteration 1:
     * Creates a label with the specified text and adds it to the dialog container.
     *
     * @param text String containing text to add
     * @return a label with the specified text that has word wrap enabled.
     */
    private Label getDialogLabel(String text, Color c, boolean makeBold) {
        // You will need to import `javafx.scene.control.Label`.
        Label textToAdd = new Label(text);
        textToAdd.setWrapText(true);
        textToAdd.setTextFill(c);
        textToAdd.setFont(new Font("Arial", 16));
        if (makeBold) {
            textToAdd.setStyle("-fx-font-weight: bold");
        }
        return textToAdd;
    }

    /**
     * @param msg
     */
    public void printToUI(String msg) {
        System.out.println(msg);
        dialogContainer.getChildren().add(getDialogLabel(msg, Color.BLUE, true));
    }

    public void printTask(Task t) {
        printToUI(t.toString());
    }

    public void printEventsOnDateMsg(LocalDateTime dt) {
        printToUI(String.format("Events and Deadlines on %s", dt.toLocalDate().toString()));
    }

    public void printEventsOnDateMsg(String dt) {
        printToUI(String.format("Events and Deadlines on %s", dt));
    }

    public void printNoEventOnDateMsg() {
        printToUI("No events on this date.");
    }

    /**
     * @param results
     */
    public void printFindResultsMsg(ArrayList<Task> results) {
        if (results.size() != 0) {
            printToUI("Here are the matching tasks in your list:\n");
            printToUI(TaskList.listTasks(results));
        } else {
            printToUI("No results found!");
        }
    }

    /**
     * @param t
     */
    public void printEditTaskMsg(Task t) {
        printToUI(String.format("Editing task: %s", t.toString()));
        printToUI(String.format("Input new description for %s.", t.getClass().getSimpleName()));
    }

    public void printEditDateMsg() {
        printToUI("Input new date for event/deadline.");
    }

    /**
     * @param tasks
     */
    public void printAddMsg(TaskList tasks) {
        printToUI("Got it. I've added this task:");
        printToUI(tasks.get(tasks.size() - 1).toString()); //increment size after printing the task added.
        printToUI(String.format("Now you have %d %s in the list.",
                tasks.size(), (tasks.size() > 1) ? "tasks" : "task"));
    }

    public void printByeMsg() {
        printToUI("Bye. Hope to see you again soon! Program will exit in 5 seconds.");
    }

    /**
     * @param currTask
     * @param tasks
     */
    public void printDeleteMsg(Task currTask, TaskList tasks) {
        printToUI(String.format("Noted. I've removed this task:"
                + "\n %s\nNow you have %d tasks in the list.", currTask, tasks.size()));
    }

    /**
     * @param t
     * @param pos
     */
    public void printDoneMsg(TaskList t, int pos) {
        Task currTask = t.get(pos);
        if (currTask.isDone()) {
            printToUI("Task is already done.");
        } else {
            printToUI(String.format("Nice! I've marked this task as done:\n%s", currTask));
        }
    }

    /**
     * @param e
     */
    public void printErrorMsg(Exception e) {
        printToUI(e.getMessage());
    }

    /**
     *
     */
    public void printHelloMsg() {
        printToUI("Hello! I'm Duke Nuke Em.");
        printToUI("What can I do for you?");
    }

}

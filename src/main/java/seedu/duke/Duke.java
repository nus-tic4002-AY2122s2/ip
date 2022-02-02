package seedu.duke;

import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Duke extends Application {
    /**
     * Main entry-point for the Duke application.
     */
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

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

        //Step 2. Formatting the window to look as expected
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

        //Step 3. Add functionality to handle user input.
        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
            //dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
            //userInput.clear();
        });

        userInput.setOnAction((event) -> {
            handleUserInput();
            //dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
            //userInput.clear();
        });

        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));


    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        Message.getVal("GREETING",logo);

        run();
    }


    public static void run() {
        try {
            TaskList taskList = new TaskList();
            String userInput;
            boolean online = true;
            Storage storage = new Storage(taskList);
            storage.readFile();

            while (online) {
                Scanner scan = new Scanner(System.in);
                userInput = scan.nextLine().trim();
                String command = new Parser().parseInput(userInput);
                switch (command) {
                case "bye":
                    Message.getVal("BYE_MESSAGE");
                    online = false;
                    break;
                case "todo":
                    taskList.addToDo(userInput);
                    storage.saveToDB(userInput);
                    Message.getVal("ADDED_SUCCESSFULLY",Integer.toString(taskList.getSize()));
                    break;
                case "deadline":
                    taskList.addDeadline(userInput);
                    storage.saveToDB(userInput);
                    Message.getVal("ADDED_SUCCESSFULLY",Integer.toString(taskList.getSize()));
                    break;
                case "event":
                    taskList.addEvent(userInput);
                    storage.saveToDB(userInput);
                    Message.getVal("ADDED_SUCCESSFULLY",Integer.toString(taskList.getSize()));
                    break;
                case "list":
                    for (int i = 0; i < taskList.getSize(); i++) {
                        System.out.println("Task " + (i + 1) + ": "
                               + taskList.getList().get(i).getTaskDetails());
                    }
                    break;
                case "find":
                    if (userInput.equals("search")) {
                        Message.getVal("SEARCH_EMPTY");
                    } else {
                        ArrayList<Task> tempList = taskList.searchTask(userInput);

                        if (tempList.size() > 0) {
                            Message.getVal("SEARCH_MATCHING_START_MESSAGE");
                            //System.out.println("Here are the matching flights in your list:");
                            for (Task task : tempList) {
                                System.out.println(task.getTaskDetails());
                            }
                        } else {
                            Message.getVal("NO_MATCH");
                            //System.out.println("There is no matching task in your list.");
                        }
                    }
                    break;
                case "done":
                    taskList.markTask(userInput);
                    storage.markTaskDB(userInput);
                    Message.getVal("MARK_SUCCESSFULLY",Integer.toString(taskList.getSize()));
                    break;
                case "delete":
                    taskList.deleteTask(userInput);
                    storage.deleteFromDB(userInput);
                    Message.getVal("DELETE_SUCCESSFULLY",Integer.toString(taskList.getSize()));
                    break;
                case "help":
                    Message.getVal("HELP_MESSAGE");
                    break;

                default:
                    Message.getVal("ERROR_UNKNOWN");
                }
            }
        } catch (Exception e) {
            Message.getVal("ERROR_UNKNOWN");
        }
    }

    /**
     * Iteration 1:
     * Creates a label with the specified text and adds it to the dialog container.
     * @param text String containing text to add
     * @return a label with the specified text that has word wrap enabled.
     */
    private Label getDialogLabel(String text) {
        // You will need to import `javafx.scene.control.Label`.
        Label textToAdd = new Label(text);
        textToAdd.setWrapText(true);

        return textToAdd;
    }

    private void handleUserInput() {
        Label userText = new Label(userInput.getText());
        Label dukeText = new Label(getResponse(userInput.getText()));
        dialogContainer.getChildren().addAll(
                DialogBox1.getUserDialog(userText, new ImageView(user)),
                DialogBox1.getDukeDialog(dukeText, new ImageView(duke))
        );
        userInput.clear();
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        return "Duke heard: " + input;
    }
}
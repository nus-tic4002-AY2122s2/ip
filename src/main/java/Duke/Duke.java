package Duke;

import Duke.Command.Deadline;
import Duke.Command.Event;
import Duke.Command.Todo;
import Duke.Task.Task;
import Duke.Task.Tasks;
import Duke.Ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.Region;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import javafx.scene.image.Image;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;



/**
 * The Duke.Duke program implements an application that
 * a personal Assistant Chatbot that helps to keep track various of daily items.
 *
 * @author  jr-mojito
 * @version 1.0
 * @since   2021-08-16
 */
public class Duke extends Application {

    private static Ui ui;

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    public void run(){
        ui.showWelcome();
    }


    public static class DialogBox extends HBox {

        private Label text;
        private ImageView displayPicture;

        public DialogBox(Label l, ImageView iv) {
            text = l;
            displayPicture = iv;

            text.setWrapText(true);
            displayPicture.setFitWidth(100.0);
            displayPicture.setFitHeight(100.0);

            this.setAlignment(Pos.TOP_RIGHT);
            this.getChildren().addAll(text, displayPicture);
        }
        /**
         * Flips the dialog box such that the ImageView is on the left and text on the right.
         */
        private void flip() {
            this.setAlignment(Pos.TOP_LEFT);
            ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
            FXCollections.reverse(tmp);
            this.getChildren().setAll(tmp);
        }

        public static DialogBox getUserDialog(Label l, ImageView iv) {
            return new DialogBox(l, iv);
        }

        public static DialogBox getDukeDialog(Label l, ImageView iv) {
            var db = new DialogBox(l, iv);
            db.flip();
            return db;
        }
    }


    @Override
    public void start(Stage stage) {

//        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
//        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label
//
//        stage.setScene(scene); // Setting the stage to show our screen
//        stage.show(); // Render the stage.

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
            dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
            userInput.clear();
        });

        userInput.setOnAction((event) -> {
            dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
            userInput.clear();
        });

        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

        //Part 3. Add functionality to handle user input.
        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
        });

        userInput.setOnAction((event) -> {
            handleUserInput();
        });
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


    /**
     * Iteration 2:
     * Creates two dialog boxes, one echoing user input and the other containing Duke.Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    private void handleUserInput() {

        Label userText = new Label(userInput.getText());
        Label dukeText = new Label(getResponse(userInput.getText()));
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
    String getResponse(String input) {
        return "Duke.Duke heard: " + input;
    }


    public static void main(String[] args){

        ui = new Ui();
        new Duke().run();

        Scanner fullCommand = ui.readCommand();

        String echo = " ";
        ArrayList<Task> addedList = new ArrayList<>();
        Tasks tasks= new Tasks("");

        while (!echo.equals("bye")) {

            echo = fullCommand.nextLine();
            String[] cli = Parser.parse(echo);

            String firstCommand = cli[0];

            switch (firstCommand){
                case("list"):
                    tasks.getList(addedList);
                    break;

                case("done"):
                    try{
                        if(cli[1]!=""){
                            String doneIndex = echo.substring(5);
                            tasks.addDone(Integer.parseInt(doneIndex));
                            System.out.println("-------------------------------");
                            System.out.println("    "+ "Nice! I've marked this task as done:");
                            System.out.println("    "+ tasks.markAsDone(Integer.parseInt(doneIndex)));
                            System.out.println("-------------------------------");
                        }
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("☹ OOPS!!! The number of a done cannot be empty.");
                    }
                    break;

                case("todo"):
                    try{
                        if(cli[1]!=""){
                            String todoIndex = echo.substring(5);

                            Todo todo = new Todo(echo.substring(5));
                            Task task = new Task(false, todo.toString());

                            addedList.add(task);

                            System.out.println("-------------------------------");
                            System.out.println("    " + "Got it. I've added this task:");
                            System.out.println("    " + echo.substring(5) );
                            System.out.println("-------------------------------");
                            System.out.println("    " + "Now you have " + tasks.getNumOfList() + " tasks in the list.");

                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                    break;

                case("event"):
                    try {
                        if (cli[1] != "") {
                            int task_stringIndex_After_taskWord = 0;
                            String task_words ="", by_words = " ";

                            task_stringIndex_After_taskWord = echo.indexOf(" ");
                            int by_string = echo.indexOf("/");
                            by_words = echo.substring(by_string + 3);

                            if (echo.contains("/")) {
                                by_string = echo.indexOf("/");
                                task_words = echo.substring(task_stringIndex_After_taskWord, by_string);
                            }
                            else if(echo.contains("bye")){
                            }
                            else{
                                task_words = echo.substring(task_stringIndex_After_taskWord);
                            }

                            Event event = new Event(task_words, by_words );
                            Task task = new Task(false, event.toString());

                            addedList.add(task);

                            System.out.println("-------------------------------");
                            System.out.println("    " + "Got it. I've added this task:");
                            System.out.println("    " + echo.substring(6) );
                            System.out.println("-------------------------------");
                            System.out.println("    " + "Now you have " + tasks.getNumOfList() + " tasks in the list.");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("☹ OOPS!!! The event description cannot be empty.");
                    }
                    break;

                case("deadline"):
                    try {
                        if (cli[1] != "") {
                            String task_words ="";
                            String by_words = " ";

                            int task_stringIndex_After_taskWord = echo.indexOf(" ");
                            int by_string = echo.indexOf("/");
                            by_words = echo.substring(by_string + 3);

                            if (echo.contains("/")) {
                                by_string = echo.indexOf("/");
                                task_words = echo.substring(task_stringIndex_After_taskWord, by_string);
                            }
                            else if(echo.contains("bye")){
                            }
                            else{
                                task_words = echo.substring(task_stringIndex_After_taskWord);
                            }

                            Deadline deadline = new Deadline(task_words, by_words );
                            Task task = new Task(false, deadline.toString());

                            addedList.add(task);

                            System.out.println("-------------------------------");
                            System.out.println("    " + "Got it. I've added this task:");
                            System.out.println("    " + echo.substring(9) );
                            System.out.println("-------------------------------");
                            System.out.println("    " + "Now you have " + tasks.getNumOfList() + " tasks in the list.");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("☹ OOPS!!! The deadline description cannot be empty.");
                    }
                    break;

                case("delete"):
                    tasks.removeTaskList(Integer.valueOf(cli[1]));
                    break;

                case ("save"):
                    try {
                        FileWriter fw = new FileWriter("./dukesave.txt");
                        File f = new File("dukesave.txt");

                        int index1 = 0;
                        System.out.println("-------------------------------");
                        Iterator itr = addedList.iterator();
                        while (itr.hasNext()){
                            Task t = (Task)itr.next();
                            fw.write("  " + ++index1 +"[" + (t.status ?"\u2713": "\u2718") +"]" + t.desc + System.lineSeparator());
                        }

                        System.out.println("File save successfully to dukesave.txt");
                        System.out.println("-------------------------------");
                        fw.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    } catch (IOException e) {
                        System.out.println("Something went wrong" + e.getMessage());
                    }
                    break;

                case ("find"):

                    if(cli[1]!="") {
                        String searchWord = echo.substring(5);
                        int count_todo_find = tasks.getNumOfList();
                        System.out.println(Ui.seperatorLine2);
                        System.out.println("Here are the matching task in your list");

                        int listPrintFind = 0;
                        int index1 = 0;

                        for (int i = 0; i<addedList.toArray().length; i++) {
                            ++index1;
                            if(addedList.get(i).desc.toString().contains(searchWord.trim())){
                                System.out.println("        " + index1 + ". " + "[" + addedList.get(i).status+ "]" + addedList.get(i).desc);
                                listPrintFind++;
                            }
                        }

                        if(listPrintFind == 0){
                            System.out.println("Not matching found on the list");
                        }

                        System.out.println(Ui.seperatorLine2);

                        break;
                    }
                    default:
            }
        }

        System.out.println("-------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-------------------------------");
    }
}

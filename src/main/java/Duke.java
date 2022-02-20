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
import Duke.Parser;

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
 * The Duke program implements an application that
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

    ImageView dukeImg = new ImageView(duke);

    private static String firstCommand;
    private static String[] fullCommand;

    private static ArrayList<Task> addedList = new ArrayList<>();
    private static Tasks tasks;


    public void run(){
        ui.showWelcome();
    }

    private void showWelcome() {
        DialogBox welcome = DialogBox.getDukeDialog(new Label("Hello! I'm Duke\n What can I do for you?"), dukeImg);
        dialogContainer.getChildren().add(welcome);
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

        public static DialogBox getExceptionDialog(Label l, ImageView iv) {
            var db = new DialogBox(l, iv);
            db.flip();
            return db;
        }
    }


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

        showWelcome();

        stage.setScene(scene);
        stage.show();

        //Step 2. Formatting the window to look as expected
        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(420.0);

        mainLayout.setPrefSize(420.0, 600.0);

        scrollPane.setPrefSize(415, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        // import `javafx.scene.layout.Region` for this.
        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(75.0);

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
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    private void handleUserInput() {

        Label userText = new Label(userInput.getText());
        Label dukeText = new Label(getResponse(userInput.getText()));

        Tasks tasks= new Tasks("");

        switch (fullCommand[0]){
        case ("todo"):
            Todo todo = new Todo(fullCommand[1]);
            Task task = new Task(false, todo.toString());

            addedList.add(task);
            Label userText2 = new Label(userInput.getText());
            Label dukeText2 = new Label("Got it. I've added this task:" + "\n" + fullCommand[1]);
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(userText2, new ImageView(user)),
                    DialogBox.getDukeDialog(dukeText2, new ImageView(duke))
            );
            userInput.clear();
            break;

        case ("list"):
            try{
                if (addedList.toArray().length != 0){
                    int indexList = 0;
                    Iterator itr = addedList.iterator();
                    Label userText3 = new Label(userInput.getText());

                    dialogContainer.getChildren().add(
                            DialogBox.getUserDialog(userText3, new ImageView(user))
                    );

                    StringBuilder stringBuilder = new StringBuilder();
                    String finalString = "";

                    stringBuilder.append("\nHere are the TaskPackage. \nTask in your list:\n");

                    while (itr.hasNext()) {
                        Task t = (Task) itr.next();
                        stringBuilder.append("    " + ++indexList + ". " + "[" + (t.status ? "\u2713" : "\u2718") + "]" + t.desc + "\n");
                        finalString = stringBuilder.toString();
                    }
                    stringBuilder.append("\n    " + "Now you have " + tasks.getNumOfList() + " tasks in the list.\n");

                    dialogContainer.getChildren().add(
                            DialogBox.getDukeDialog(new Label(finalString), new ImageView(duke))
                    );
                    userInput.clear();
                }
                else if (addedList.toArray().length == 0){
                    Label dukeTextEmptyList = new Label("☹ OOPS!!! There are no daily items in the list.\n");
                    dialogContainer.getChildren().add(
                            DialogBox.getExceptionDialog(dukeTextEmptyList, new ImageView(duke))
                    );
                    userInput.clear();
                }
            } catch(ArrayIndexOutOfBoundsException e) {
                Label dukeTextListException = new Label("☹ OOPS!!! \nSomething went wrong \n");
                dialogContainer.getChildren().addAll(
                        DialogBox.getExceptionDialog(dukeTextListException, new ImageView(duke))
                );
            }
            break;
        case("done"):
            try{

                Integer doneIndexInput = Integer.parseInt(fullCommand[1])-1;
                Integer doneIndex = Integer.parseInt(fullCommand[1]);

                int index = 0;

                Iterator itrDone = this.addedList.iterator();
                while (itrDone.hasNext()) {

                    Task t = (Task)itrDone.next();
                    if(doneIndexInput == index) {
                        t.status = true;
                    }
                    ++index;
                }

                Label userTextDone = new Label(userInput.getText());
                StringBuilder stringBuilderDone = new StringBuilder();
                String finalStringDone="";

                dialogContainer.getChildren().add(
                        DialogBox.getUserDialog(userTextDone, new ImageView(user))
                );

                if(doneIndex <= addedList.toArray().length && doneIndex > 0 ){
                    stringBuilderDone.append("\n    "+ "Nice! I've marked this task item:"+ doneIndex + " as done\n");
                    finalStringDone = stringBuilderDone.toString();
                    dialogContainer.getChildren().add(
                            DialogBox.getDukeDialog(new Label(finalStringDone), new ImageView(duke))
                    );
                    userInput.clear();
                }

                else if(doneIndex > addedList.toArray().length || doneIndex <= 0){
                    stringBuilderDone.append("\n☹ OOPS!!! Something went wrong");
                    stringBuilderDone.append("\n 1. The item of a done is not in the list.");
                    stringBuilderDone.append("\n 2. The item no should not be negative");
                    stringBuilderDone.append("\nPlease list all the item\n");

                    finalStringDone = stringBuilderDone.toString();
                    dialogContainer.getChildren().add(
                            DialogBox.getDukeDialog(new Label(finalStringDone), new ImageView(duke))
                    );
                    userInput.clear();
                }

            } catch (IndexOutOfBoundsException e) {
                Label dukeTextEventException = new Label("☹ OOPS!!! \nThe number of a done cannot be empty.\n");
                dialogContainer.getChildren().addAll(
                        DialogBox.getExceptionDialog(dukeTextEventException, new ImageView(duke))
                );
            }
            break;

        case("event"):
            try {
                if (fullCommand[1] != "") {
                    int task_stringIndex_After_taskWord = 0;
                    String task_words ="", by_words = " ";

                    task_stringIndex_After_taskWord = userInput.getText().indexOf(" ");
                    int by_string = userInput.getText().indexOf("/");
                    by_words =  userInput.getText().substring(by_string + 3);

                    if ( userInput.getText().contains("/")) {
                        by_string =  userInput.getText().indexOf("/");
                        task_words =  userInput.getText().substring(task_stringIndex_After_taskWord, by_string);
                    }
                    else if( userInput.getText().contains("bye")){
                    }
                    else{
                        task_words =  userInput.getText().substring(task_stringIndex_After_taskWord);
                    }

                    Event event = new Event(task_words, by_words );
                    Task eventTast = new Task(false, event.toString());

                    addedList.add(eventTast);

                    Label userTextEvent = new Label(userInput.getText());
                    StringBuilder stringBuilderEvent = new StringBuilder();
                    String finalStringEvent="";

                    dialogContainer.getChildren().add(
                            DialogBox.getUserDialog(userTextEvent, new ImageView(user))
                    );

                    stringBuilderEvent.append("\n    " + "Got it. I've added this task:\n");
                    stringBuilderEvent.append("\n    " + userInput.getText().substring(6) +"\n");

                    finalStringEvent = stringBuilderEvent.toString();

                    dialogContainer.getChildren().add(
                            DialogBox.getDukeDialog(new Label(finalStringEvent), new ImageView(duke))
                    );
                    userInput.clear();
                }
            } catch (IndexOutOfBoundsException e) {
                Label dukeTextEventException = new Label("☹ OOPS!!!\n The event description cannot be empty. \n");
                dialogContainer.getChildren().addAll(
                        DialogBox.getExceptionDialog(dukeTextEventException, new ImageView(duke))
                );
            }
            break;

        case("deadline"):
            try {
                if (fullCommand[1] != "") {
                    String task_words ="";
                    String by_words = " ";

                    int task_stringIndex_After_taskWord = userInput.getText().indexOf(" ");
                    int by_string = userInput.getText().indexOf("/");
                    by_words = userInput.getText().substring(by_string + 3);

                    if (userInput.getText().contains("/")) {
                        by_string = userInput.getText().indexOf("/");
                        task_words = userInput.getText().substring(task_stringIndex_After_taskWord, by_string);
                    }
                    else if(userInput.getText().contains("bye")){
                    }
                    else{
                        task_words = userInput.getText().substring(task_stringIndex_After_taskWord);
                    }

                    Deadline deadline = new Deadline(task_words, by_words );
                    Task deadLineTask = new Task(false, deadline.toString());

                    addedList.add(deadLineTask);

                    Label userTextEvent = new Label(userInput.getText());
                    StringBuilder stringBuilderEvent = new StringBuilder();
                    String finalStringEvent="";

                    dialogContainer.getChildren().addAll(
                            DialogBox.getUserDialog(userTextEvent, new ImageView(user))
                    );

                    stringBuilderEvent.append("\n    " + "Got it. I've added this task:\n");
                    stringBuilderEvent.append("\n    " + userInput.getText().substring(9)+"\n" );
                    stringBuilderEvent.append("\n    " + "Now you have " + tasks.getNumOfList() + " tasks in the list.\n");

                    finalStringEvent = stringBuilderEvent.toString();

                    dialogContainer.getChildren().add(
                            DialogBox.getDukeDialog(new Label(finalStringEvent), new ImageView(duke))
                    );
                    userInput.clear();

                }
            } catch (IndexOutOfBoundsException e) {
                Label userTextDelete= new Label(userInput.getText());

                dialogContainer.getChildren().addAll(
                        DialogBox.getUserDialog(userTextDelete, new ImageView(user))
                );
                System.out.println("☹ OOPS!!! The delete cannot be empty.");
            }
            break;

        case("delete"):
            try{
                Integer deleteIndex = Integer.parseInt(fullCommand[1]);
                this.addedList.remove(Integer.parseInt(fullCommand[1])-1);
                StringBuilder stringBuilderDelete= new StringBuilder();
                String finalStringDelete="";

                stringBuilderDelete.append("\n    "+ "Nice! I've deleted item:"+ deleteIndex+"\n");
                finalStringDelete = stringBuilderDelete.toString();
                dialogContainer.getChildren().addAll(
                        DialogBox.getDukeDialog(new Label(finalStringDelete), new ImageView(duke))
                );
                userInput.clear();
                break;
            } catch (IndexOutOfBoundsException e){
                Label dukeTextDeleteException = new Label("☹ OOPS!!! Please enter correct delete item no. \n");
                dialogContainer.getChildren().addAll(
                        DialogBox.getExceptionDialog(dukeTextDeleteException, new ImageView(duke))
                );
            }
            break;

        case ("save"):
            try {
                FileWriter fw = new FileWriter("./dukesave.txt");
                File f = new File("dukesave.txt");

                Label userTextEvent = new Label(userInput.getText());
                StringBuilder stringBuilderEvent = new StringBuilder();
                String finalStringSave = "";

                dialogContainer.getChildren().addAll(
                        DialogBox.getUserDialog(userTextEvent, new ImageView(user))
                );

                int saveIndex = 0;
                Iterator saveItr = addedList.iterator();
                while (saveItr.hasNext()){
                    Task t = (Task)saveItr.next();
                    fw.write("  " + ++saveIndex +"[" + (t.status ?"\u2713": "\u2718") +"]" + t.desc + System.lineSeparator());
                }

                stringBuilderEvent.append("\nFile save successfully to dukesave.txt\n");

                finalStringSave = stringBuilderEvent.toString();

                dialogContainer.getChildren().add(
                        DialogBox.getDukeDialog(new Label(finalStringSave), new ImageView(duke))
                );
                userInput.clear();
                fw.close();
            } catch (FileNotFoundException e) {
                Label dukeTextFindException = new Label("☹ OOPS!!! \nFile not found \n");
                dialogContainer.getChildren().addAll(
                        DialogBox.getExceptionDialog(dukeTextFindException, new ImageView(duke))
                );
            } catch (IOException e) {
                Label dukeTextFindException = new Label("☹ OOPS!!! \nSomething went wrong \n");
                dialogContainer.getChildren().addAll(
                        DialogBox.getExceptionDialog(dukeTextFindException, new ImageView(duke))
                );
            }
            break;

        case ("find"):
            try{
                int listPrintFind = 0;
                int index1 = 0;

                if(fullCommand[1]!="") {
                    String searchWord = userInput.getText().substring(5);

                    StringBuilder stringBuilder = new StringBuilder();
                    String finalStringFind = "";

                    stringBuilder.append("Here are the matching task in your list\n");

                    for (int i = 0; i < addedList.toArray().length; i++) {
                        ++index1;
                        if (addedList.get(i).desc.contains(searchWord.trim())) {
                            stringBuilder.append("\n " + index1 + ". " + "[" + addedList.get(i).status + "]" + addedList.get(i).desc);
                            listPrintFind++;
                        }
                    }
                    finalStringFind = stringBuilder.toString();

                    if(listPrintFind != 0) {
                        dialogContainer.getChildren().add(
                                DialogBox.getDukeDialog(new Label(finalStringFind), new ImageView(duke))
                        );
                        userInput.clear();
                    }
                    else if(listPrintFind == 0){
                        Label dukeTextFind = new Label("☹ OOPS!!! \nNot matching found on the list\"\n");
                        dialogContainer.getChildren().add(
                                DialogBox.getExceptionDialog(dukeTextFind, new ImageView(duke))
                        );
                        userInput.clear();
                    }
                }

            } catch (ArrayIndexOutOfBoundsException e){
                Label dukeTextFindException = new Label("☹ OOPS!!! \nThe finding keywords is missing\n");
                dialogContainer.getChildren().add(
                        DialogBox.getExceptionDialog(dukeTextFindException, new ImageView(duke))
                );
                userInput.clear();
            }
            break;

        default:
            Label dukeTextWrongCmd= new Label("☹ OOPS!!! \nPlease refer User Guide enter correct command");
            dialogContainer.getChildren().add(
                    DialogBox.getExceptionDialog(dukeTextWrongCmd, new ImageView(duke))
            );

        }
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    private static String getResponse(String input) {
        fullCommand = input.split(" ");
        firstCommand = fullCommand[0];

        return "Duke heard: " + firstCommand;
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

            default:
            }
        }

        System.out.println("-------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-------------------------------");
    }

}
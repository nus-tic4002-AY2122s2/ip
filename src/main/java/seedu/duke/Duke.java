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

    public static String run(String userInput) {
        try {
            String command = new Parser().parseInput(userInput);
            switch (command) {
                case "bye":
                    return(Message.getVal("BYE_MESSAGE"));
                case "todo":
                    Main.taskList.addToDo(userInput);
                    Main.storage.saveToDB(userInput);
                    //Message.getVal("ADDED_SUCCESSFULLY",Integer.toString(taskList.getSize()));
                    return(Message.getVal("ADDED_SUCCESSFULLY",Integer.toString(Main.taskList.getSize())));
                case "deadline":
                    Main.taskList.addDeadline(userInput);
                    Main.storage.saveToDB(userInput);
                    return(Message.getVal("ADDED_SUCCESSFULLY",Integer.toString(Main.taskList.getSize())));
                case "event":
                    Main.taskList.addEvent(userInput);
                    Main.storage.saveToDB(userInput);
                    return(Message.getVal("ADDED_SUCCESSFULLY",Integer.toString(Main.taskList.getSize())));
                case "list":
                    String result = "";
                    for (int i = 0; i < Main.taskList.getSize(); i++) {
                        if(i > 0){
                            result = result + "\n";
                        }
                        result = result + "Task " + (i + 1) + ": "
                                + Main.taskList.getList().get(i).getTaskDetails();
                    }
                    return result;
                case "find":
                    if (userInput.equals("search")) {
                        return(Message.getVal("SEARCH_EMPTY"));
                    } else {
                        ArrayList<Task> tempList = Main.taskList.searchTask(userInput);
                        if (tempList.size() > 0) {
                            String result2 = Message.getVal("SEARCH_MATCHING_START_MESSAGE");
                            //System.out.println("Here are the matching flights in your list:");
                            for (Task task : tempList) {
                                result2 = result2 + "\n" + task.getTaskDetails();
                            }
                            return (result2);
                        } else {
                            return(Message.getVal("NO_MATCH"));
                        }
                    }
                case "done":
                    Main.taskList.markTask(userInput);
                    Main.storage.markTaskDB(userInput);
                    return(Message.getVal("MARK_SUCCESSFULLY",Integer.toString(Main.taskList.getSize())));
                case "delete":
                    Main.taskList.deleteTask(userInput);
                    Main.storage.deleteFromDB(userInput);
                    return(Message.getVal("DELETE_SUCCESSFULLY",Integer.toString(Main.taskList.getSize())));
                case "help":
                    return(Message.getVal("HELP_MESSAGE"));

                default:
                    return(Message.getVal("ERROR_UNKNOWN"));

            }
        } catch (Exception e) {
            return (Message.getVal("ERROR_UNKNOWN"));
        }
    }

}
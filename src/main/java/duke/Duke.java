package duke;

import java.util.Scanner;

import duke.command.CommandCaller;
import duke.command.CommandFactory;
import duke.parse.StringParser;
import duke.storage.Storage;
import duke.storage.TempTaskList;
import duke.ui.Message;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * @author      Li Shihao
 * @since       2021 Aug
 */
public class Duke extends Application {
    private TempTaskList tasks = new TempTaskList();
    private Storage storage = new Storage();
    private CommandFactory commandFactory = new CommandFactory(tasks);
    private StringParser strParser = new StringParser();
    private CommandCaller commandCaller = new CommandCaller(commandFactory);
    /*
    bug fixed: DO NOT put scanner creation inside the loop,
    maintain only one scanner object
     */
    private Scanner in = new Scanner(System.in);

    /**
     * constrctor
     */
    public Duke() {
        tasks.addPropertyChangeListener(storage);
        strParser.addPropertyChangeListener(commandCaller);
        storage.listInit(tasks);
    }

    /**
     * entrance of the program
     * @param args
     */
    // public static void main(String[] args) {
    //     Message.greeting();
    //     new Duke().start();
    //     Message.exit();
    // }

    private void start() {
        String userInput = in.nextLine();

        switch(userInput.strip()) {
        case "bye":
            return;
        case "list":
            tasks.print();
            break;
        default:
            strParser.passToCaller(userInput);
        }

        start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        primaryStage.setScene(scene); // Setting the stage to show our screen
        primaryStage.show(); // Render the stage.
    }

}



package duke;

import duke.command.CommandCaller;
import duke.command.CommandFactory;
import duke.parse.StringParser;
import duke.storage.Storage;
import duke.storage.TempTaskList;
import duke.ui.Message;

import java.util.Scanner;

/**
 * @author      Li Shihao
 * @since       2021 Aug
 */
public class Duke {
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


    public Duke() {
        tasks.addPropertyChangeListener(storage);
        strParser.addPropertyChangeListener(commandCaller);
        storage.listInit(tasks);
    }

    public static void main(String[] args)  {
        Message.greeting();
        new Duke().start();
        Message.exit();
    }

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

}



package duke;

import duke.command.CommandCaller;
import duke.command.CommandFactory;
import duke.command.TaskMarkDoneCmd;
import duke.parse.StringParser;
import duke.storage.TempTaskList;
import duke.task.Task;
import duke.ui.Message;

import java.io.File;
import java.util.Scanner;

/**
 * @author      Li Shihao
 * @since       2021 Aug
 */
public class Duke {
    private TempTaskList list = new TempTaskList();
    private File file;
    private CommandFactory commandFactory = new CommandFactory(list, file);
    private StringParser strParser = new StringParser();
    private CommandCaller commandCaller = new CommandCaller(commandFactory);

    public Duke() {
        Message messager = new Message();
        list.addPropertyChangeListener(messager);
        strParser.addPropertyChangeListener(commandCaller);
    }

    public static void main(String[] args)  {
        Message.greeting();
        new Duke().start();
        Message.exit();
    }

    private void start() {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();

        switch(userInput.strip()) {
            case "bye":
                return;
            case "list":
                list.print();
                break;
            default:
                strParser.passToCaller(userInput);
        }

        start();
    }


}



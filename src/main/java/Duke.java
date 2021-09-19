import java.io.IOException;

import commands.Command;
import exceptions.DukeDateTimeError;
import exceptions.DukeStorageError;
import exceptions.DukeTaskInputException;
import parser.Parser;
import storage.Storage;
import task_classes.TaskList;
import ui.Ui;

public class Duke {

    private TaskList taskList;
    private Ui ui;
    private Storage storage;

    public Duke (String filePath) throws IOException, DukeStorageError {
        ui = new Ui();
        storage = new Storage (filePath);

        try {
            taskList = new TaskList(storage.load());
        } catch (DukeStorageError e) {
            ui.showLoadingError();
            taskList = new TaskList();
        }
    }

    private void run() throws IOException {
        ui.showGreetingMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Ui.toPrintSeparateLine(); // show the divider line ("________")
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (DukeTaskInputException | DukeDateTimeError e) {
                String errorType = DukeTaskInputException.getErrorType();

                switch (errorType) {
                    case "taskListEmpty":
                        DukeTaskInputException.toPrintListIsEmtpyError();
                        break;
                    case "commandCreateError":
                        DukeTaskInputException.toPrintCommandCreateError();
                        break;
                    case "cannotUnderstand":
                        DukeTaskInputException.invalidFirstWordInput();
                        break;
                    default:
                        DukeTaskInputException.formatWrong();
                }
            } finally {
                Ui.toPrintSeparateLine();
                System.out.println("");
            }
        }

        storage.transferToFile(taskList.getVectorList());
    }


    public static void main(String[] args) throws IOException, DukeStorageError {
        new Duke("data/dukeTasks.txt").run();
    }
}

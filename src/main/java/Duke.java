import java.io.IOException;

import commands.Command;
import exceptions.DukeDateTimeError;
import exceptions.DukeStorageError;
import exceptions.DukeTaskInputException;

import parser.Parser;
import storage.Storage;
import taskclasses.TaskList;
import ui.Ui;

/*
    15th Jan 2022, Repo to the new upstream repo (https://github.com/nus-tic4002-AY2122S2/ip)
 */

public class Duke {

    private TaskList taskList;
    private Ui ui;
    private Storage storage;

    /**
     * initialize Duke function
     *
     * @param filePath the target file location in local drive to store or extract task data from
     * @throws IOException handles all input error
     */
    public Duke(String filePath) throws IOException {
        ui = new Ui();
        //ui.showGreetingMessage();
        storage = new Storage(filePath);

        try {
            taskList = new TaskList(storage.load());
        } catch (DukeStorageError | DukeDateTimeError e) {
            //ui.showLoadingError();
            taskList = new TaskList();
        }
    }

    public Duke() {

    }

    /**
     * Start Duke
     *
     * @throws IOException Handle all input errors
     */
    private void run() throws IOException {
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Ui.toPrintSeparateLine(); // show the divider line ("________")
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (DukeTaskInputException e) {
                String errorType = DukeTaskInputException.getErrorType();

                switch (errorType) {
                case "taskListEmpty":
                    DukeTaskInputException.toPrintListIsEmptyError();
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
            } catch (Exception e) {
                DukeTaskInputException.formatWrong();
            } catch (DukeDateTimeError e) {
                System.out.println("     OOps! The input dateTime format wrong. Please try again.");
            } finally {
                Ui.toPrintSeparateLine();
                System.out.println("");
            }
        }

        storage.transferToFile(taskList.getVectorList());
    }

/*    public static void main(String[] args) throws IOException, DukeStorageError {
        new Duke("data/dukeTasks.txt").run();
    }*/

    private String runDuke(String input) {

        String echoInfo = "";
        String errorInfo = "     "
                + "\\U+2639"
                + " OOPS!!! ";

        if (input.equals("bye")) {
            return "     Bye. Hope to see you again soon!";
        }

        try {
            Command c = Parser.parse(input);
            echoInfo = c.execute(taskList, ui, storage);
            //storage.transferToFile(taskList.getVectorList());

            return echoInfo;
        } catch (DukeTaskInputException e) {
            String errorType = DukeTaskInputException.getErrorType();
            switch (errorType) {
            case "taskListEmpty":
                errorInfo = errorInfo
                        + "The Task List is empty.";

                return errorInfo;
            case "commandCreateError":
                errorInfo = errorInfo
                        + "The Command you just input was in wrong format.";

                return errorInfo;
            case "cannotUnderstand":
                errorInfo = errorInfo
                        + "I'm sorry, but I don't know what that means :-(";

                return errorInfo;
            default:
                errorInfo = errorInfo
                        + "The input format wrong, please try again. :-(";

                return errorInfo;
            }
        } catch (Exception e) {
            errorInfo = errorInfo
                    + "The input format wrong, please try again. :-(";

            return errorInfo;
        } catch (DukeDateTimeError e) {
            return "     OOps! The input dateTime format wrong. Please try again.";
        }
    }

    String getResponse(String input) throws IOException {
        String filePath = "data/dukeTasks.txt";
        String echoInfo = "";

        Duke dk = new Duke (filePath);


        //echoInfo = String.valueOf(dk.taskList.size());
        echoInfo = dk.runDuke(input);

        return echoInfo;
    }
}

import java.io.IOException;
import java.util.Vector;

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

        /*Vector<String> v1 = new Vector<>();
        Vector<String> v2 = new Vector<>();
        for(int i=0; i<10; i++){
            v1.add("micheal");
        }

        for(int i=0; i<5; i++){
            v2.add("barny");
        }
        TaskList t1 = new TaskList(v1, "");
        TaskList t2 = new TaskList(v2, "");

        int s1 = t1.sizeS();
        int s2 = t2.sizeS();

        Vector<String> t1List =t1.getVectorListS();
        Vector<String> t2List = t2.getVectorListS();

        Ui.toPrintSeparateLine();

        for(String str : t1List){
            System.out.println(str);
        }

        Ui.toPrintSeparateLine();

        for(String str : t2List){
            System.out.println(str);
        }

        Ui.toPrintSeparateLine();*/
    }
}

import java.io.IOException;
import java.util.Vector;

import exceptions.DukeStorageError;
import screen_output.Output_On_Screen;
import storage.Storage;
import task_classes.Task;
import user_input.Ui;

public class Duke {

    private Vector<Task> list = new Vector<Task>();
    private Ui ui;
    private Storage storage;

    public static void main(String[] args) throws IOException, DukeStorageError {

        Output_On_Screen.greetingOutput();

        // To extract existing task list from local storage, txt file
        list = Storage.extractTaskFromTxt();

        Ui.InputStart(list);

        // To store all the current task to local storage, txt file
        Storage.transferToFile(list);

    }
}

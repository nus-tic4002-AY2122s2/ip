import java.io.IOException;
import java.util.Vector;

import exceptions.DukeStorageError;
import screen_output.Output_On_Screen;
import storage.storageInLocal;
import task_classes.Task;
import user_input.Input_Scanner;

public class Duke {
    public static void main(String[] args) throws IOException, DukeStorageError {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Output_On_Screen.toPrintSeparateLine();
        Output_On_Screen.greetingOutput();
        Output_On_Screen.toPrintSeparateLine();
        System.out.println("");

        Vector<Task> list = new Vector<Task>();

        // To extract existing task list from local storage, txt file
        list = storageInLocal.extractTaskFromTxt();

        Input_Scanner.InputStart(list);

        storageInLocal taskStorageFile = new storageInLocal();

        // To store all the current task to local storage, txt file
        taskStorageFile.transferToFile(list);

    }
}

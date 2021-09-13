import java.io.IOException;
import java.util.Vector;

import screen_output.Output_On_Screen;
import storage.storageInLocal;
import task_classes.Task;
import user_input.Input_Scanner;

public class Duke {
    public static void main(String[] args) throws IOException {
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

        Input_Scanner.InputStart(list);

        storageInLocal taskStorageFile = new storageInLocal();

        taskStorageFile.transferToFile(list);

    }
}

package ip.duke;

import ip.duke.exceptions.DukeException;
import ip.duke.storage.Storage;
import ip.duke.task.Task;
import ip.duke.tasklist.TaskList;
import ip.duke.ui.Ui;
import java.util.LinkedHashSet;
import java.util.Scanner;
import static ip.duke.parser.Parser.hasTask;
/**
 * LisGenie Chat Bot CLI App - a task management online assistant.
 *
 * </P>Deals with user tasks register, chat service and administration.
 *
 * <P>Note that tasks are stored as Task objects in a Task[] array (Optimum max size : 100).
 *
 * @author Gwee Yeu Chai
 * @version 1.6
 * @since 2021-08-01
 */
public class Duke {
    private static LinkedHashSet<Task> tasks;

    public Duke(String filePath) {
        Storage storage = new Storage(filePath);
        try {
            tasks = TaskList.load(Storage.getFilePath());
        } catch (DukeException e) {
            Ui.showLoadingError();
            tasks = TaskList.getList();
            storage.setFilePath("data/backup.txt");
        }
    }

    public void run() {
        // Greet display and prompt user for input
        Ui.greet();
        // Warn user to delete some old records if database full
        if (tasks.size() == 100) {
            Ui.showSizeFull();
        }
        // Get user input
        Scanner in = new Scanner(System.in);
        String input;
        boolean isBye = false;
        // Tasks and conversations loop
        do {
            Ui.echoUserPrompt();
            input = in.nextLine().trim();
            Ui.drawALine();

            if (input.isEmpty()) {
                // flush buffer
                in.nextLine();
                Ui.echoEmptyInput();
            }

            try {
                isBye = hasTask(input);
            } catch (DukeException e) {
                Ui.echoDukeErrorMsg(e);
            } finally {
                Ui.drawALine();
            }
        } while (!isBye);

        in.close();
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}

import command.Command;
import exception.ErrorHandler;
import parser.CommandParser;
import parser.DataParser;
import storage.Storage;
import ui.Ui;
import taskList.TaskList;

import java.util.Scanner;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        this.tasks = new TaskList();
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }

    public void run() {
        try {
            this.loadTasks();
            this.ui.welcome();
            Scanner in = new Scanner(System.in);
            boolean isExit = false;

            while (!isExit) {
                try {
                    String userCommand = in.nextLine().trim();
                    Command command = new CommandParser().parse(userCommand);
                    command.execute(this.storage, this.ui, this.tasks);
                    isExit = command.getIsExit();
                } catch (Exception e) {
                    this.ui.print("Error inner: " + e.getMessage());
                }
            }
        } catch (ErrorHandler e) {
            this.ui.print("Error: " + e.getMessage());
        }
    }

    private void loadTasks() throws ErrorHandler {
        String[] data = this.storage.loadData();

        for (String line : data) {
            Command command = new DataParser().parse(line);
            command.execute(this.storage, this.ui, this.tasks);
        }
    }
}

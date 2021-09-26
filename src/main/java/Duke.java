import command.Command;
import parser.CommandParser;
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
            this.ui.welcome();
            Scanner in = new Scanner(System.in);
            boolean isExit = false;

            while (!isExit) {
                String userCommand = in.nextLine().trim();
                Command command = new CommandParser().parse(userCommand);
                command.execute(this.storage, this.ui, this.tasks);
                isExit = command.getIsExit();
            }
        } catch (Exception e) {
            Ui.print("Error: " + e.getMessage());
        }
    }
}

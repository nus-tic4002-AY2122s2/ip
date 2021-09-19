package edu.nus.duke;

import edu.nus.duke.ui.Ui;
import edu.nus.duke.task.TaskList;
import edu.nus.duke.storage.Storage;
import edu.nus.duke.parser.Parser;

public class Main {
    // Variables
    private TaskList taskList;
    private Storage storage;
    private Ui ui;

    // Constructor
    public Main(String filePath) {
        taskList = new TaskList();
        storage = new Storage(filePath, taskList);
        ui = new Ui();

        Ui.printMessage("Hello! I'm Jarvis\nWhat can I do for you?");
        runApp();
        Ui.printMessage("Bye. Hope to see you again soon!");
    }

    // Methods
    private void runApp() {
        while (true) {
            String inputTxt = ui.getUserInput();
            if (Parser.isExit(inputTxt)) {
                break;
            }
            Parser.parseInput(inputTxt, taskList);
            storage.writeToFile(taskList.printForFile());
        }
    }

    public static void main(String[] args) {
        new Main("data/duke.txt");
    }
}

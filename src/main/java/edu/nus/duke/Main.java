package edu.nus.duke;

import java.util.Scanner;

import edu.nus.duke.ui.Ui;
import edu.nus.duke.task.TaskList;
import edu.nus.duke.storage.Storage;
import edu.nus.duke.parser.Parser;

public class Main {
    // Variables
    private TaskList taskList;
    private Storage storage;

    // Constructor
    public Main(String filePath) {
        taskList = new TaskList();
        storage = new Storage(filePath, taskList);

        Ui.printMessage("Hello! I'm Jarvis\nWhat can I do for you?");
        runApp();
        Ui.printMessage("Bye. Hope to see you again soon!");
    }

    // Methods
    private void runApp() {
        Scanner userInput = new Scanner(System.in);
        String inputTxt = userInput.nextLine();
        while (!inputTxt.equals("bye")) {
            Parser.parseInput(inputTxt, taskList);
            storage.writeToFile(taskList.printForFile());
            inputTxt = userInput.nextLine();
        }
    }

    public static void main(String[] args) {
        new Main("data/duke.txt");
    }
}

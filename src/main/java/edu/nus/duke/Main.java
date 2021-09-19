package edu.nus.duke;

import edu.nus.duke.ui.Ui;
import edu.nus.duke.task.TaskList;
import edu.nus.duke.storage.Storage;
import edu.nus.duke.parser.Parser;
import edu.nus.duke.command.Command;
import edu.nus.duke.exception.DukeInvalidInputException;
import edu.nus.duke.exception.DukeEmptyArgsException;
import edu.nus.duke.exception.DukeDisallowInputException;

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
            try {
                Command cmd = Parser.parseInput(inputTxt);
                cmd.run(taskList);
                storage.writeToFile(taskList.printForFile());
            } catch (DukeInvalidInputException e) {
                Ui.printMessage("OOPS!!! I'm sorry, but I don't know what that means :-(");
            } catch (DukeEmptyArgsException e) {
                Ui.printMessage("OOPS!!! The description of a " + inputTxt + " cannot be empty.");
            } catch (DukeDisallowInputException e) {
                Ui.printMessage("'" + Storage.getSaveSep() + "' is not allowed!");
            } catch (ArrayIndexOutOfBoundsException e) {
                Ui.printMessage("Invalid input");
            }
        }
    }

    public static void main(String[] args) {
        new Main("data/duke.txt");
    }
}

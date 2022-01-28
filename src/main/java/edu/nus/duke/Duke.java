package edu.nus.duke;

import java.time.format.DateTimeParseException;

import edu.nus.duke.command.Command;
import edu.nus.duke.command.ExitCommand;
import edu.nus.duke.exception.DukeDisallowInputException;
import edu.nus.duke.exception.DukeInvalidInputException;
import edu.nus.duke.parser.Parser;
import edu.nus.duke.storage.Storage;
import edu.nus.duke.task.TaskList;
import edu.nus.duke.ui.Ui;

public class Duke {
    // Variables
    private final TaskList taskList;
    private final Storage storage;
    private final Ui ui;

    // Constructor

    /**
     * Constructor of Duke class.
     *
     * @param filePath File path of txt storage.
     */
    public Duke(String filePath) {
        taskList = new TaskList();
        storage = new Storage(filePath, taskList);
        ui = new Ui();

        Ui.printMessage("Hello! I'm Duke\nWhat can I do for you?");
        runApp();
    }

    // Methods
    private void runApp() {
        String inputTxt;
        do {
            inputTxt = ui.getUserInput();
            try {
                Command cmd = Parser.parseInput(inputTxt);
                cmd.run(taskList);
                storage.writeToFile(taskList.printForFile());
            } catch (DukeInvalidInputException e) {
                Ui.printMessage("OOPS!!! I'm sorry, but I don't know what that means :-(");
            } catch (DukeDisallowInputException e) {
                Ui.printMessage("'" + Storage.getSaveSep() + "' is not allowed!");
            } catch (ArrayIndexOutOfBoundsException e) {
                Ui.printMessage("Invalid input");
            } catch (DateTimeParseException e) {
                Ui.printMessage("Invalid datetime input");
            }
        } while (!inputTxt.equals(ExitCommand.CMD));
    }

    public static void main(String[] args) {
        new Duke("data/duke.txt");
    }
}

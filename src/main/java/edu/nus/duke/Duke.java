package edu.nus.duke;

import java.time.format.DateTimeParseException;

import edu.nus.duke.command.Command;
import edu.nus.duke.command.CommandDataHistory;
import edu.nus.duke.command.CommandResult;
import edu.nus.duke.exception.DukeDisallowInputException;
import edu.nus.duke.exception.DukeEmptyUndoException;
import edu.nus.duke.exception.DukeInvalidInputException;
import edu.nus.duke.parser.Parser;
import edu.nus.duke.storage.Storage;
import edu.nus.duke.task.TaskList;

/**
 * Class of the Duke app.
 */
public class Duke {
    private TaskList taskList;
    private CommandDataHistory commandDataHistory;
    private Storage storage;

    /**
     * Constructor of Duke class.
     *
     * @param filePath File path of txt storage.
     */
    public Duke(String filePath) {
        taskList = new TaskList();
        commandDataHistory = new CommandDataHistory();
        storage = new Storage(filePath, taskList);
    }

    /**
     * Execute Duke logic and return feedback to user.
     *
     * @param inputTxt String input from user.
     * @return Feedback to user.
     */
    public String getResponse(String inputTxt) {
        try {
            Command cmd = Parser.parseInput(inputTxt);
            CommandResult commandResult = cmd.run(taskList, commandDataHistory);
            if (commandResult.getIsExit()) {
                System.exit(0);
            }
            storage.writeToFile(taskList.printForFile());
            return commandResult.getFeedback();
        } catch (DukeInvalidInputException e) {
            return ("OOPS!!! I'm sorry, but I don't know what that means :-(");
        } catch (DukeDisallowInputException e) {
            return ("'" + Storage.getSaveSep() + "' is not allowed!");
        } catch (ArrayIndexOutOfBoundsException e) {
            return ("Invalid input");
        } catch (DateTimeParseException e) {
            return ("Invalid datetime input");
        } catch (DukeEmptyUndoException e) {
            return ("No undo to return");
        }
    }
}

package edu.nus.duke.parser;

import edu.nus.duke.storage.Storage;
import edu.nus.duke.command.Command;
import edu.nus.duke.command.AddCommand;
import edu.nus.duke.command.ListCommand;
import edu.nus.duke.command.DoneCommand;
import edu.nus.duke.command.DeleteCommand;
import edu.nus.duke.command.ExitCommand;
import edu.nus.duke.task.Todo;
import edu.nus.duke.task.Deadline;
import edu.nus.duke.task.Event;
import edu.nus.duke.exception.DukeInvalidInputException;
import edu.nus.duke.exception.DukeEmptyArgsException;
import edu.nus.duke.exception.DukeDisallowInputException;

/**
 * Class that deals with making sense of the user command
 */
public class Parser {
    // Variables
    private final String dtFormat = "yyyy-MM-dd'T'HH:mm";

    // Methods
    private static void rejectBadInput(String input) throws DukeDisallowInputException {
        if (input.contains(Storage.getSaveSep())) {
            throw new DukeDisallowInputException();
        }
    }

    private static Command parseInput_MultiArgs(String cmd, String args)
            throws ArrayIndexOutOfBoundsException, DukeInvalidInputException {
        String[] argsArray;
        String taskName;
        int idx;

        switch (cmd) {
        case AddCommand.cmdTodo:
            taskName = args;
            return ( new AddCommand(new Todo(taskName)) );
        case AddCommand.cmdDeadline:
            argsArray = args.split("/by");
            taskName = argsArray[0].trim();
            String by = argsArray[1].trim();
            return ( new AddCommand(new Deadline(taskName, by)) );
        case AddCommand.cmdEvent:
            argsArray = args.split("/at");
            taskName = argsArray[0].trim();
            String at = argsArray[1].trim();
            return ( new AddCommand(new Event(taskName, at)) );
        case DoneCommand.cmd:
            idx = Integer.parseInt(args) - 1;
            return (new DoneCommand(idx));
        case DeleteCommand.cmd:
            idx = Integer.parseInt(args) - 1;
            return (new DeleteCommand(idx));
        default:
            throw new DukeInvalidInputException();
        }
    }

    /**
     * Parse the string input from user and returns a {@code Command}.
     *
     * @param inputTxt Input string from user.
     * @return A polymorphic command to be executed.
     * @throws DukeInvalidInputException If user input is not of standard commands.
     * @throws DukeEmptyArgsException If required arguments are missing.
     * @throws DukeDisallowInputException If disallowed keywords are present.
     * @throws ArrayIndexOutOfBoundsException If there is invalid argument.
     */
    public static Command parseInput(String inputTxt) throws DukeInvalidInputException,
            DukeEmptyArgsException, DukeDisallowInputException, ArrayIndexOutOfBoundsException {
        rejectBadInput(inputTxt);

        String[] inputArray = inputTxt.split(" ", 2);
        String cmd = inputArray[0];

        if (cmd.equals(ListCommand.cmd)) {
            return (new ListCommand());
        } else if (cmd.equals(ExitCommand.cmd)) {
            return (new ExitCommand());
        } else {
            if (inputArray.length == 1) {
                throw new DukeEmptyArgsException();
            }
            String args = inputArray[1];
            return parseInput_MultiArgs(cmd, args);
        }
    }
}

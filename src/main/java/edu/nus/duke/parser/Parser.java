package edu.nus.duke.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DT_FORMAT = "yyyy-MM-dd'T'HH:mm";
    private static final String DATE_FORMAT_PRINT = "d MMM yy";
    private static final String DT_FORMAT_PRINT = "d MMM yy h:mm a";

    // Methods
    private static void rejectBadInput(String input) throws DukeDisallowInputException {
        if (input.contains(Storage.getSaveSep())) {
            throw new DukeDisallowInputException();
        }
    }

    public static LocalDateTime parseDt(String s) throws DateTimeParseException {
        String dt = s;
        if (s.length() == DATE_FORMAT.length()) {
            dt = s + "T00:00";
        }
        return LocalDateTime.parse(dt, DateTimeFormatter.ofPattern(DT_FORMAT));
    }

    public static String dtToString(LocalDateTime dt) {
        return dt.format(DateTimeFormatter.ofPattern(DT_FORMAT));
    }

    public static String printDt(LocalDateTime dt) {
        if ((dt.getHour() == 0) && (dt.getMinute() == 0)) {
            return dt.format(DateTimeFormatter.ofPattern(DATE_FORMAT_PRINT));
        }
        return dt.format(DateTimeFormatter.ofPattern(DT_FORMAT_PRINT));
    }

    private static Command parseInput_MultiArgs(String cmd, String args) throws ArrayIndexOutOfBoundsException,
            DukeInvalidInputException, DateTimeParseException {
        String[] argsArray;
        String taskName;
        int idx;

        switch (cmd) {
        case AddCommand.CMD_TODO:
            taskName = args;
            return ( new AddCommand(new Todo(taskName)) );
        case AddCommand.CMD_DEADLINE:
            argsArray = args.split("/by");
            taskName = argsArray[0].trim();
            LocalDateTime by = parseDt( argsArray[1].trim() );
            return ( new AddCommand(new Deadline(taskName, by)) );
        case AddCommand.CMD_EVENT:
            argsArray = args.split("/at");
            taskName = argsArray[0].trim();
            LocalDateTime at = parseDt( argsArray[1].trim() );
            return ( new AddCommand(new Event(taskName, at)) );
        case DoneCommand.CMD:
            idx = Integer.parseInt(args) - 1;
            return (new DoneCommand(idx));
        case DeleteCommand.CMD:
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
    public static Command parseInput(String inputTxt) throws DukeInvalidInputException, DukeEmptyArgsException,
            DukeDisallowInputException, ArrayIndexOutOfBoundsException, DateTimeParseException {
        rejectBadInput(inputTxt);

        String[] inputArray = inputTxt.split(" ", 2);
        String cmd = inputArray[0];

        if (cmd.equals(ListCommand.CMD)) {
            return (new ListCommand());
        } else if (cmd.equals(ExitCommand.CMD)) {
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

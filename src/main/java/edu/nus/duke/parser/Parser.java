package edu.nus.duke.parser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import edu.nus.duke.command.AddCommand;
import edu.nus.duke.command.Command;
import edu.nus.duke.command.DeleteCommand;
import edu.nus.duke.command.DoneCommand;
import edu.nus.duke.command.ExitCommand;
import edu.nus.duke.command.FindCommand;
import edu.nus.duke.command.ListCommand;
import edu.nus.duke.exception.DukeDisallowInputException;
import edu.nus.duke.exception.DukeInvalidInputException;
import edu.nus.duke.storage.Storage;
import edu.nus.duke.task.Deadline;
import edu.nus.duke.task.Event;
import edu.nus.duke.task.Todo;

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

    private static LocalDate parseDate(String s) throws DateTimeParseException {
        return LocalDate.parse(s, DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    /**
     * Returns a {@code LocalDateTime} by parsing from a date/datetime string.
     *
     * @param s Date/datetime string
     * @return a {@code LocalDateTime}
     * @throws DateTimeParseException If format is invalid.
     */
    public static LocalDateTime parseDt(String s) throws DateTimeParseException {
        String dt = s;
        if (s.length() == DATE_FORMAT.length()) {
            dt = s + "T00:00";
        }
        return LocalDateTime.parse(dt, DateTimeFormatter.ofPattern(DT_FORMAT));
    }

    /**
     * Returns a string representation of {@code LocalDateTime}.
     *
     * @param dt {@code LocalDateTime}
     * @return String representation of datetime.
     */
    public static String dtToString(LocalDateTime dt) {
        return dt.format(DateTimeFormatter.ofPattern(DT_FORMAT));
    }

    /**
     * Returns a display-friendly string representation of {@code LocalDateTime}.
     *
     * @param dt {@code LocalDateTime}
     * @return String representation of datetime.
     */
    public static String printDt(LocalDateTime dt) {
        if ((dt.getHour() == 0) && (dt.getMinute() == 0)) {
            return dt.format(DateTimeFormatter.ofPattern(DATE_FORMAT_PRINT));
        }
        return dt.format(DateTimeFormatter.ofPattern(DT_FORMAT_PRINT));
    }

    private static Command parseInputMultiArgs(String cmd, String args) throws ArrayIndexOutOfBoundsException,
            DukeInvalidInputException, DateTimeParseException {
        String[] argsArray;
        String taskName;
        int idx;

        switch (cmd) {
        case AddCommand.CMD_TODO:
            taskName = args;
            return (new AddCommand(new Todo(taskName)));
        case AddCommand.CMD_DEADLINE:
            argsArray = args.split("/by");
            taskName = argsArray[0].trim();
            LocalDateTime by = parseDt(argsArray[1].trim());
            return (new AddCommand(new Deadline(taskName, by)));
        case AddCommand.CMD_EVENT:
            argsArray = args.split("/at");
            taskName = argsArray[0].trim();
            LocalDateTime at = parseDt(argsArray[1].trim());
            return (new AddCommand(new Event(taskName, at)));
        case DoneCommand.CMD:
            idx = Integer.parseInt(args) - 1;
            return (new DoneCommand(idx));
        case DeleteCommand.CMD:
            idx = Integer.parseInt(args) - 1;
            return (new DeleteCommand(idx));
        case FindCommand.CMD:
            return (new FindCommand(args));
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
     * @throws DukeDisallowInputException If disallowed keywords are present.
     * @throws ArrayIndexOutOfBoundsException If there is invalid argument.
     * @throws DateTimeParseException If date/datetime input format is invalid.
     */
    public static Command parseInput(String inputTxt) throws DukeInvalidInputException,
            DukeDisallowInputException, ArrayIndexOutOfBoundsException, DateTimeParseException {
        rejectBadInput(inputTxt);

        String[] inputArray = inputTxt.split(" ", 2);
        String cmd = inputArray[0];

        if (cmd.equals(ListCommand.CMD)) {
            if (inputArray.length == 2) {
                LocalDate date = parseDate(inputArray[1]);
                return (new ListCommand(date));
            }
            return (new ListCommand());
        } else if (cmd.equals(ExitCommand.CMD)) {
            return (new ExitCommand());
        } else {
            String args = inputArray[1];
            return parseInputMultiArgs(cmd, args);
        }
    }
}

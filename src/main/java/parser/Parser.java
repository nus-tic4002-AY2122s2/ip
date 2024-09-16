package parser;//deals with making sense of the user command


import commands.AddCommand;
import commands.ChangeDoneCommand;
import commands.ClearListCommand;
import commands.Command;
import commands.DeleteCommand;
import commands.ExitCommand;
import commands.FindCommand;
import commands.HelpCommand;
import commands.ListCommand;
import commands.RescheduleCommand;
import exceptions.DukeException;


/**
 * This represents the parser. It parses the input from the ui. Depending on the input,
 * it will parse the respective command
 */

public class Parser {

    /**
     * Constructor for Parser.
     */
    public Parser() {
    }

    /**
     * This parses the input gotten from the ui. This method will parse and return the appropriate Command.
     *
     * @param input A string input.
     * @return Command Returns a command class for execution
     * @throws DukeException When the input for option number in various Commands is not a number or when the input
     *                       for Adding a new Task is incomplete.
     */
    public static Command parse(String input) throws DukeException {
        String description = "";
        String secPart = "";
        String keyword;
        int option = 0;
        int index = 0;
        String commandWord = input.stripLeading().split(" ")[0];

        assert !(commandWord.equals(null)) : "commandWord should not be null";


        if (input.strip().equals("")) {
            throw new DukeException("☹ OOPS!!! You did not enter any command");
        }


        switch (commandWord) {
        case "bye":
            return new ExitCommand();
        case "blah":
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");

        case "list":
            return new ListCommand();

        case "/clear":
            return new ClearListCommand();

        case "/help":
            return new HelpCommand();

        case "find":
            keyword = input.replaceFirst("find", "").trim();
            return new FindCommand(keyword);

        case "done":
            try {
                option = Integer.parseInt(input.replaceFirst("done", "").trim());
            } catch (NumberFormatException e) {
                throw new DukeException("Error: Invalid option number, your input is not a number");
            }

            return new ChangeDoneCommand(option, true);

        case "undone":
            try {
                option = Integer.parseInt(input.replaceFirst("undone", "").trim());
            } catch (NumberFormatException e) {
                throw new DukeException("Error: Invalid option number, your input is not a number");
            }

            return new ChangeDoneCommand(option, false);


        case "delete":
            try {
                option = Integer.parseInt(input.replace("delete", "").trim());
            } catch (NumberFormatException e) {
                throw new DukeException("Error: Invalid option number, your input is not a number");
            }
            return new DeleteCommand(option);

        case "reschedule":
            index = input.indexOf("/new");
            secPart = input.substring(index);
            secPart = secPart.replaceFirst("/new", "").trim();

            try {
                option = Integer.parseInt(input.substring(0, index).replaceFirst("reschedule",
                        "").trim());
            } catch (NumberFormatException e) {
                throw new DukeException("Error: Invalid option number, your input is not a number");
            }

            return new RescheduleCommand(option, secPart);

        case "todo":
            description = input.replaceFirst("todo", "").trim();
            return new AddCommand("todo", description, secPart);

        case "event":
        case "deadline":
            return parseAddCommandSpecialTask(commandWord, input);

        default:
            description = input;
            return new AddCommand("task", description, secPart);

        }
    }


    public static Command parseAddCommandSpecialTask(String taskType, String input) throws DukeException {
        int index = 0;
        String description = "";
        String secPart = "";
        String separator = "";
        switch (taskType) {
        case "event":
            separator = "/at";
            break;

        case "deadline":
            separator = "/by";
            break;

        default:
            throw new DukeException("Error: Incomplete Command for Add Task.");
        }

        try {
            index = input.indexOf(separator);
            secPart = input.substring(index);
            secPart = secPart.replaceFirst(separator, "").trim();
            description = input.substring(0, index);
            description = description.replaceFirst(taskType, "").trim();
        } catch (StringIndexOutOfBoundsException e) {
            switch (taskType) {
            case "event":
                throw new DukeException("Error: Incomplete Command for Add Event");
            case "deadline":
                throw new DukeException("Error: Incomplete Command for Add Deadline.");
            default:
                throw new DukeException("Error: Incomplete Command for Adding a special task.");
            }
        }


        return new AddCommand(taskType, description, secPart);


    }

}



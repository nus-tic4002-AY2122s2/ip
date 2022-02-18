package duke;

import duke.command.AddDeadlineCommand;
import duke.command.AddTodoCommand;
import duke.command.DoneCommand;
import duke.command.ListCommand;
import duke.command.AddEventCommand;
import duke.command.DeleteCommand;
import duke.command.FindCommand;
import duke.command.EditCommand;
import duke.command.ByeCommand;
import duke.exception.CommandException;

/**
 * Execute user command.
 * */
public class Execution {
    protected String fullCommand;
    protected String command;
    protected boolean isExit;

    /**
     * Create new command.
     * @param fullCommand user full command.
     * */
    public Execution(String fullCommand) {
        this.fullCommand = fullCommand;
        this.command = Parser.command(fullCommand);
        this.isExit = false;
    }

    private static void checkCommand(String command) throws CommandException {
        if (!(command.equals("todo") || command.equals("deadline") || command.equals("event")
                || command.equals("bye") || command.equals("list") || command.equals("done")
                || command.equals("delete") || command.equals("find") || command.equals("edit"))) {
            throw new CommandException();
        }
    }

    /**
     * Execute new command.
     * @param taskList task list to be updated
     * */
    public String execute(TaskList taskList) {
        try {
            checkCommand(command);

            switch (command) {
            case "list":
                return new ListCommand(fullCommand).run(taskList);
            case "done":
                return new DoneCommand(fullCommand).run(taskList);
            case "todo":
                return new AddTodoCommand(fullCommand).run(taskList);
            case "deadline":
                return new AddDeadlineCommand(fullCommand).run(taskList);
            case "event":
                return new AddEventCommand(fullCommand).run(taskList);
            case "delete":
                return new DeleteCommand(fullCommand).run(taskList);
            case "find":
                return new FindCommand(fullCommand).run(taskList);
            case "edit":
                return new EditCommand(fullCommand).run(taskList);
            case "bye":
                isExit = true;
                return new ByeCommand(fullCommand).run(taskList);
            default:
                return "Command is not correct!";
            }
        } catch (CommandException e) {
            return "OOPS!!! Pls key in the valid command";
        }
    }
}

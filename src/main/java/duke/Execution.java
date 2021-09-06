package duke;

import duke.command.*;
import duke.exception.CommandException;

public class Execution {
    protected String fullCommand;
    protected String command;
    protected boolean isExit;

    public Execution(String fullCommand) {
        this.fullCommand = fullCommand;
        this.command = Parser.command(fullCommand);
        this.isExit = false;
    }

    private static void checkCommand(String command) throws CommandException {
        if ( !(command.equals("todo") || command.equals("deadline") || command.equals("event")
                || command.equals("bye") || command.equals("list") || command.equals("done")
                || command.equals("delete")) ) {
            throw new CommandException();
        }
    }

    public void execute(TaskList taskList) {
        try {
            checkCommand(command);

            switch (command) {
            case "list":
                new ListCommand(fullCommand).run(taskList);
                break;
            case "done":
                new DoneCommand(fullCommand).run(taskList);
                break;
            case "todo":
                new AddTodoCommand(fullCommand).run(taskList);
                break;
            case "deadline":
                new AddDeadlineCommand(fullCommand).run(taskList);
                break;
            case "event":
                new AddEventCommand(fullCommand).run(taskList);
                break;
            case "delete":
                new DeleteCommand(fullCommand).run(taskList);
                break;
            case "bye":
                new ByeCommand(fullCommand).run(taskList);
                isExit = true;
                break;
            }
        } catch (CommandException e) {
            System.out.println("OOPS!!! Pls key in the valid command");
        }
    }
}

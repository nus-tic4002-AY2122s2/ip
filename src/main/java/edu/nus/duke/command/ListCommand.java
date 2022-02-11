package edu.nus.duke.command;

import java.time.LocalDate;

import edu.nus.duke.task.TaskList;

/**
 * Represent list command that extends from Command.
 */
public class ListCommand extends Command {
    public static final String CMD = "list";
    private LocalDate dateFilter;

    public ListCommand() {
    }

    public ListCommand(LocalDate dateFilter) {
        this.dateFilter = dateFilter;
    }

    @Override
    public CommandResult run(TaskList taskList, CommandDataHistory commandDataHistory) {
        String message = "Here are the tasks in your list:";
        if (dateFilter != null) {
            message = "Here are the filtered tasks in your list:";
        }

        String feedback = taskList.printTasks(message, dateFilter, null);
        return (new CommandResult(feedback, false));
    }
}

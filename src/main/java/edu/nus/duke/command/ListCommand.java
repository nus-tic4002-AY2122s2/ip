package edu.nus.duke.command;

import java.time.LocalDate;

import edu.nus.duke.ui.Ui;
import edu.nus.duke.task.TaskList;

/**
 * Represent list command that extends from Command.
 */
public class ListCommand extends Command {
    // Variables
    public static final String CMD = "list";
    private LocalDate dateFilter;

    // Constructor
    public ListCommand() {
    }

    public ListCommand(LocalDate dateFilter) {
        this.dateFilter = dateFilter;
    }

    // Methods
    @Override
    public void run(TaskList taskList) {
        Ui.printMessage("Here are the tasks in your list:", false);
        taskList.printTasks(dateFilter);
    }
}

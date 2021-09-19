package edu.nus.duke.command;

import edu.nus.duke.ui.Ui;
import edu.nus.duke.task.TaskList;

/**
 * Represent list command that extends from Command.
 */
public class ListCommand extends Command {
    // Variables
    public static final String cmd = "list";

    // Methods
    @Override
    public void run(TaskList taskList) {
        Ui.printMessage("Here are the tasks in your list:", false);
        Ui.printMessage(taskList.printTasks(), false);
        Ui.printMessage("Total tasks: " + taskList.getListSize());
    }
}

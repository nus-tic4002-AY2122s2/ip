package edu.nus.duke.command;

import edu.nus.duke.ui.Ui;
import edu.nus.duke.task.TaskList;

/**
 * Represent exit command that extends from Command.
 */
public class ExitCommand extends Command {
    // Variables
    public static final String cmd = "bye";

    // Methods
    @Override
    public void run(TaskList taskList) {
        Ui.printMessage("Bye. Hope to see you again soon!");
    }
}

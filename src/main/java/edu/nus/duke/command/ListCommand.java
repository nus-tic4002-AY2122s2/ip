package edu.nus.duke.command;

import edu.nus.duke.ui.Ui;
import edu.nus.duke.task.TaskList;

public class ListCommand extends Command {
    // Constructor
    public ListCommand() {
        super("list");
    }

    // Methods
    @Override
    public void runCmd(TaskList taskList) {
        Ui.printMessage("Here are the tasks in your list:", false);
        Ui.printMessage(taskList.printTasks(), false);
        Ui.printMessage("Total tasks: " + taskList.getListSize());
    }
}

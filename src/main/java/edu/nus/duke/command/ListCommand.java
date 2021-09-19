package edu.nus.duke.command;

import edu.nus.duke.ui.Ui;
import edu.nus.duke.task.TaskList;

public class ListCommand extends Command {
    // Variables
    private TaskList taskList;

    // Constructor
    public ListCommand(TaskList taskList) {
        super("list");
        this.taskList = taskList;
    }

    // Methods
    @Override
    public void runCmd() {
        Ui.printMessage("Here are the tasks in your list:", false);
        Ui.printMessage(taskList.printTasks(), false);
        Ui.printMessage("Total tasks: " + taskList.getListSize());
    }
}

package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

import edu.nus.duke.ui.Ui;

public class FindCommand extends Command {
    // Variables
    public static final String CMD = "find";
    private String textFilter;

    // Constructor
    public FindCommand(String textFilter) {
        this.textFilter = textFilter;
    }

    // Methods
    @Override
    public void run(TaskList taskList) {
        Ui.printMessage("Here are the matching tasks in your list:", false);
        taskList.printTasks(null, textFilter);
    }
}

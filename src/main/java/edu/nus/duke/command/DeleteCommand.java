package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

public class DeleteCommand extends Command {
    // Variables
    private TaskList taskList;
    private int idx;

    // Constructor
    public DeleteCommand(TaskList taskList, int idx) {
        super("delete");
        this.taskList = taskList;
        this.idx = idx;
    }

    // Methods
    @Override
    public void runCmd() {
        taskList.deleteTask(idx);
    }
}

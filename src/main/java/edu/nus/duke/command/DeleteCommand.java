package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

public class DeleteCommand extends Command {
    // Variables
    private int idx;

    // Constructor
    public DeleteCommand(int idx) {
        super("delete");
        this.idx = idx;
    }

    // Methods
    @Override
    public void run(TaskList taskList) {
        taskList.deleteTask(idx);
    }
}

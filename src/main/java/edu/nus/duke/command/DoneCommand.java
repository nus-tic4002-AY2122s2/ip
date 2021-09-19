package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

public class DoneCommand extends Command {
    // Variables
    private TaskList taskList;
    private int idx;

    // Constructor
    public DoneCommand(TaskList taskList, int idx) {
        super("done");
        this.taskList = taskList;
        this.idx = idx;
    }

    // Methods
    @Override
    public void runCmd() {
        taskList.doneTask(idx);
    }
}

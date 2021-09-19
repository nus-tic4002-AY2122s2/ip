package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

public class DoneCommand extends Command {
    // Variables
    public static final String cmd = "done";
    private int idx;

    // Constructor
    public DoneCommand(int idx) {
        this.idx = idx;
    }

    // Methods
    @Override
    public void run(TaskList taskList) {
        taskList.doneTask(idx);
    }
}

package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

public class DoneCommand extends Command {
    // Variables
    private int idx;

    // Constructor
    public DoneCommand(int idx) {
        super("done");
        this.idx = idx;
    }

    // Methods
    @Override
    public void run(TaskList taskList) {
        taskList.doneTask(idx);
    }
}

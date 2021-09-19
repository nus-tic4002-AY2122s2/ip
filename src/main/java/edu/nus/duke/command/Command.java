package edu.nus.duke.command;

import edu.nus.duke.task.TaskList;

public abstract class Command {
    // Variables
    protected final String cmd;

    // Constructor
    public Command(String cmd) {
        this.cmd = cmd;
    }

    // Methods
    public abstract void runCmd(TaskList taskList);
}

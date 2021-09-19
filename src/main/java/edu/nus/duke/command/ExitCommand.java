package edu.nus.duke.command;

import edu.nus.duke.ui.Ui;

public class ExitCommand extends Command {
    // Constructor
    public ExitCommand() {
        this.cmd = "bye";
    }

    // Methods
    @Override
    public void runCmd() {
        Ui.printMessage("Bye. Hope to see you again soon!");
    }
}

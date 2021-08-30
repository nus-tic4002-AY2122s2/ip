package duke.command;

import duke.TaskList;

public abstract class Command {
    protected String fullCommand;

    public Command(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    public abstract void run(TaskList taskList);
}

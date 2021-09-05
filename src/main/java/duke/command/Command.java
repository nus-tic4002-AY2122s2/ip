package duke.command;

import duke.dukeException.DukeException;
import duke.task.Task;

public abstract class Command {
    protected String taskItem;
    public Command(String taskItem){
        this.taskItem = taskItem;
    }

    public void execute(Task tasks) throws DukeException {
        throw new DukeException("Error for command execute!");
    }

    public boolean isExit(){

        return false;
    }

}

package duke.command;

import duke.storage.TempTaskList;
import duke.task.Task;

/**
 * A Concrete Command in Command Pattern
 */
public class TaskMarkDoneCmd implements UndoableCommand {
    // Task is a Receiver Class in this Command
    private TempTaskList list;
    private Task task;

    public TaskMarkDoneCmd( TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
       // list.stream().filter(e -> e)
        task = (Task) list.get(Integer.parseInt(args[0]) - 1);
        task.markDone();
    }

    @Override
    public void undo() {
        task.markUnDone();
    }

    @Override
    public void redo() {

    }
}

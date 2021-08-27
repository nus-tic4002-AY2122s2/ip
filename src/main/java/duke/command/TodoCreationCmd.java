package duke.command;

import duke.storage.TempTaskList;
import duke.task.*;

public class TodoCreationCmd implements UndoableCommand{
    // Task is a Receiver Class in this Command
    private TempTaskList list;
    private Task task;

    public TodoCreationCmd( TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
        list.add(new Todo(args[0]));
    }

    @Override
    public void undo() {
        task.markUnDone();
    }

    @Override
    public void redo() {

    }
}

package duke.command;

import duke.storage.TempTaskList;
import duke.task.Task;
import duke.task.Deadline;

public class DLCreationCmd implements UndoableCommand{
    // Task is a Receiver Class in this Command
    private TempTaskList list;
    private Task task;

    public DLCreationCmd( TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
        String line = "";
        for (String word : args) {
            line += word;
        }
        String[] parts = line.split("/by");
        list.add(new Deadline(parts[0], parts[1]));
    }

    @Override
    public void undo() {
        task.markUnDone();
    }

    @Override
    public void redo() {

    }
}

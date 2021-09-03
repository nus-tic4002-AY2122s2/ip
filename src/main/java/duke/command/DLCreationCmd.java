package duke.command;

import duke.exception.NoDateException;
import duke.exception.NumArgsException;
import duke.parse.StringParser;
import duke.storage.TempTaskList;
import duke.task.Task;
import duke.task.Deadline;
import duke.ui.Message;

public class DLCreationCmd implements UndoableCommand{
    // Task is a Receiver Class in this Command
    private TempTaskList list;
    private Task task;

    public DLCreationCmd( TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
        String arg = StringParser.join(args);

        String[] parts = arg.split("/by");

        if(args.length == 0 || args.length == 1) {
            try {
                throw new NumArgsException();
            } catch (NumArgsException e) {
                Message.echo(e.getMessage());
            }
        } else if (parts.length != 2) {
            try {
                throw new NoDateException();
            } catch (NoDateException e) {
                Message.echo(e.getMessage());
            }
        } else {
            list.add(new Deadline(parts[0], parts[1]));
        }
    }

    @Override
    public void undo() {
        task.markUnDone();
    }

    @Override
    public void redo() {

    }
}

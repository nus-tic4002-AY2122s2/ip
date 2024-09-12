package duke.command;

import java.time.format.DateTimeParseException;

import duke.exception.NoDateException;
import duke.exception.NumArgsException;
import duke.parse.StringParser;
import duke.storage.TempTaskList;
import duke.task.Event;
import duke.task.Task;
import duke.ui.Message;

/**
 * As a command, run() with arguments to
 * create a new event task
 */
public class EventCreationCmd implements UndoableCommand {
    // Task is a Receiver Class in this Command
    private TempTaskList list;
    private Task task;

    public EventCreationCmd(TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
        String arg = StringParser.join(args);

        String[] parts = arg.strip().split("/at");

        if (args.length == 0 || args.length == 1) {
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
            try {
                var title = parts[0].strip();
                var duration = StringParser.parseEvent(parts);
                Event event = new Event(title, duration);
                list.add(event);
                Message.taskAdd(list);
            } catch (DateTimeParseException e) {
                Message.setBuffer("Event DateTime Format: /at YYYY-MM-DD HHMM-HHMM");
            }
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

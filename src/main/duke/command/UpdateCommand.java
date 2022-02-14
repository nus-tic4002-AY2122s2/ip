package duke.command;

import duke.exception.DukeException;
import duke.exception.DukeUnknownException;
import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;


/**
 * Command that contains all the possible ways to update tasks. (Including delete.)
 */
public class UpdateCommand extends Command {

    private Operation operation;
    private int position;
    private Task task;


    /**
     * @param operation
     * @param task
     */
    public UpdateCommand(Operation operation, Task task) {
        this.operation = operation;
        this.task = task;
    }

    /**
     * @param operation
     * @param pos
     */
    public UpdateCommand(Operation operation, int pos) { //inputted index is not valid. Try again.
        this.operation = operation;
        position = pos;
    }

    public enum Operation {
        Done, Delete, Add, Edit;
    }

    public Task getTask() {
        return task;
    }

    public Operation getOperation() {
        return operation;
    }

    /**
     * Checks Operation tagged to command, executes it accordingly
     * Add: Adds task and prints added task to console
     * Done: prints task which was done and tags it as done.
     * Delete: removes task from tasks before printing message.
     * Edit: edits tasks and replaces previous iteration of task in list.
     * Default: Throws DukeUnknown error as UpdateCommand should only have Add, Done, Delete.
     *
     * @param tasks
     * @param ui
     * @param storage
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        switch (operation) {
        case Add:
            tasks.add(task);
            ui.printAddMsg(tasks);
            break;
        case Done:
            ui.printDoneMsg(tasks, position);
            tasks.done(position);
            break;
        case Delete:
            ui.printDeleteMsg(tasks.remove(position), tasks);
            break;
        case Edit:
            Task eTask = tasks.get(position);
            ui.printEditTaskMsg(eTask);
            eTask.setDescription(ui.readCommand());
            if (eTask.getClass() == Deadline.class || eTask.getClass() == Event.class) {
                ui.printEditDateMsg();
                String dateStr = ui.readCommand();
                if (eTask.getClass() == Deadline.class) {
                    Deadline d = (Deadline) eTask;
                    d.setDeadline(dateStr);
                    eTask = d;
                } else {
                    Event e = (Event) eTask;
                    e.setStartEndTime(dateStr);
                    eTask = e;
                }
            }
            tasks.edit(position, eTask);
            ui.printTask(tasks.get(position));
            break;
        default:
            ui.printErrorMsg(new DukeUnknownException());
            break;
        }
    }

}

package duke.command;

import duke.exception.DukeException;
import duke.exception.DukeUnknownException;
import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.ToDo;
import duke.ui.Ui;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;


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
            ui.setEditingTodo(eTask.getClass() == ToDo.class);
            ui.printEditTaskMsg(eTask);
            ui.setAwaitingInput(true);
            //basically get a task here that keeps running in the background till the description and date are received.
            javafx.concurrent.Task<Void> sleeper = new javafx.concurrent.Task<>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        do {
                            Thread.sleep(500);
                        } while (ui.isAwaitingInput());
                    } catch (InterruptedException e) {
                        ui.printToUI("Interrupted exit!");
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    Task finalETask = eTask;
                    finalETask.setDescription(ui.getNewDesc());
                    if (finalETask.getClass() == Deadline.class || finalETask.getClass() == Event.class) {
                        ui.printEditDateMsg();
                        String dateStr = ui.getNewDateStr();
                        if (finalETask.getClass() == Deadline.class) {
                            Deadline d = (Deadline) finalETask;
                            d.setDeadline(dateStr);
                            finalETask = d;
                        } else {
                            Event e = (Event) finalETask;
                            e.setStartEndTime(dateStr);
                            finalETask = e;
                        }
                    }
                    tasks.edit(position, finalETask);
                    ui.printTask(tasks.get(position));
                    ui.resetInputStrings();
                }
            });
            new Thread(sleeper).start();
            break;
        default:
            ui.printErrorMsg(new DukeUnknownException());
            break;
        }
    }

}

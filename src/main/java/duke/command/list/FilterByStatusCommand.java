package duke.command.list;

import duke.command.Command;
import duke.others.DukeException;
import duke.others.Messages;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Display list of pending tasks.
 */
public class FilterByStatusCommand extends Command {
    private String status;

    public FilterByStatusCommand(String status) {
        this.status = status;
    }

    /**
     * Executes the duke.command and display a list of tasks that are still not completed/done.
     *
     * @param tasks task list
     * @param ui text ui.
     * @param storage storage file.
     * @throws DukeException if task list is empty or there are no tasks with status (isDone) equals to false.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String input = "";
        if (this.status.equals("pending")) {
            input = getPending(tasks);
        } else if (this.status.equals("completed")) {
            input = getCompleted(tasks);
        }
        if (tasks.isEmpty() || input.length() == 0) {
            throw new DukeException(Messages.LIST_EMPTY);
        }
        input = Messages.LIST_HEADER + input;
        return input;
    }

    private String getPending(TaskList tasks) {
        String input = "";
        for (int i = 0; i < tasks.size(); ++i) {
            if (!tasks.get(i).getIsDone()) {
                input = input.concat((i + 1) + ". " + tasks.get(i).getTypeStatusDescNotes() + "\n");
            }
        }
        return input;
    }

    private String getCompleted(TaskList tasks) {
        String input = "";
        for (int i = 0; i < tasks.size(); ++i) {
            if (tasks.get(i).getIsDone()) {
                input = input.concat((i + 1) + ". " + tasks.get(i).getTypeStatusDescNotes() + "\n");
            }
        }
        return input;
    }
}

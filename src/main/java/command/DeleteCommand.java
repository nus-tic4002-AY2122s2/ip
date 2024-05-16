package command;

import exception.DukeException;
import basic.Storage;
import basic.TaskList;
import basic.Ui;
import task.Task;

/**
 * Deletes a task identified using it's index from the task list.
 */
public class DeleteCommand extends Command {
    protected static Ui ui = new Ui();
    private String input;

    public DeleteCommand(String input) {
        this.input = input;
    }

    /**
     * Executes DeleteCommand.
     * @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     * @param exCommand The previous command entered. 
     * @throws DukeException If the inputted index is out of range. 
     * @return The delete confirmation response.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage, TaskList deletedTasks, 
                            String exCommand) throws DukeException {
        input = input.toLowerCase();
        int num = 0;
        if (input.matches(".*\\d.*")) {
            num = Integer.parseInt(input.replaceAll("[\\D]", ""));
        }
        if (num > 0 && num <= tasks.sizeOfTask()) {
            Task task = tasks.returnTask(num - 1);
            tasks.deleteTask(num - 1);
            deletedTasks.addTask(task);
            return ui.printDeleteCommand(task, tasks.sizeOfTask());
        } else {
            throw new DukeException("☹ Item not found.\n");
        }
    }

}

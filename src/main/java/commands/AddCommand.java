package commands;

import exceptions.DukeException;
import storage.Storage;
import tasks.TaskList;
import ui.Ui;

/**
 * This represents the AddCommand class which adds a specific task to the task list.
 */
public class AddCommand extends Command {
    String taskType;
    String taskDescription;
    String taskSecondPart;

    /**
     * This is a constructor for the AddCommand.
     *
     * @param type        This indicates the type or subclass of Task
     * @param description This describes the activity of the Task
     * @param secPart     This is mainly for deadlines or events whereby they have a /by or /at. The Date and Time.
     */
    public AddCommand(String type, String description, String secPart) {
        this.taskType = type;
        this.taskDescription = description;
        this.taskSecondPart = secPart;
    }


    /**
     * This executes the AddCommand. It will add the Task to the TaskList by calling the
     * addToList method.
     *
     * @param tasks   This is the Task List that contains the list of tasks.
     * @param ui      This is the ui, to be used for scanning and printing
     * @param storage This is the storage, used to read and write over the file.
     * @throws DukeException When the taskType is not a Task or its subclasses.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.addTask(taskType, taskDescription, taskSecondPart, ui);

        int size = tasks.getSize();
        ui.storeMessage("Got it. I've added this task:"
                + "\n" + tasks.get(size - 1).toString());

        ui.storeMessage(tasks.printNumberOfTasks());
    }

    public static void printHelp(Ui ui) {
        ui.storeMessage("Adding a generic task: [description]");
        ui.storeMessage("Adding a ToDo task: todo [description]");
        ui.storeMessage("Adding a Deadline task: deadline [description] /by [Date and Time]");
        ui.storeMessage("Adding an Event task: event [description] /at [Date and Time] to [Time]");
    }

    public String getTaskType() {
        return this.taskType;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public String getTaskSecondPart() {
        return this.taskSecondPart;
    }
}

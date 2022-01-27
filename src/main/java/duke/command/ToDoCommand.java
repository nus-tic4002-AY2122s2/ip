package duke.command;

import duke.dukeexception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.task.TaskType;
import duke.task.ToDo;
import duke.ui.Ui;

/**
 * Command to Create a new ToDos task
 */
public class ToDoCommand extends Command {

    /**
     * Constructs the ToDo Command
     * @param taskDes the command the user input
     */
    public ToDoCommand(String taskDes) {
        super(taskDes);
    }


    /**
     * Execute the ToDo command to create the ToDos task
     * @param tasks the task list
     * @param ui the Ui
     * @param storage the Storage
     * @throws DukeException any expected error
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            commandInstruction.substring(5);
        } catch (StringIndexOutOfBoundsException e) {
            throw new DukeException("Todo command can't be empty");
        }
        ToDo todo = new ToDo(commandInstruction.substring(5));
        //Checking whether the task has been created as a ToDo before adding and saving
        assert todo.getTaskType() == TaskType.TODO;
        tasks.addTask(todo);
        storage.save(tasks);
    }


}

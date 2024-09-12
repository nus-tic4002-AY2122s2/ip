package duke;

/*
 *  DeleteCommand.java
 *  Defines the 'Delete' action flow to delete tasks.
 */

public class DeleteCommand extends Command {
    private int index;

    /*
     * Constructs Delete Command object with parsed task.
     * @param Parsed task.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /*
     * Returns not to exit program.
     * @return false Command 'duke' not to exit
     * after delete command.
     */
    @Override
    public boolean isExit() {
        return false;
    }

    /*
     * This method 'Executes' the command and display message
     * after successfully deleting task.
     * @param tasks Object of Task class.
     * @param storage Object of Storage class.
     */
    @Override
    public String execute(TaskList tasks, Storage storage) {
        //delete task from task list
        Task task = TaskList.deleteTask(index - 1);
        //display successful message and task count
        String output = "\tNoted. I've removed this task:\n";
        output = output + "\t" + task.toString() + "\n";
        output = output + "\tNow you have " + tasks.getTaskSize() + " tasks in the list." + "\n";

        return output;
    }
}

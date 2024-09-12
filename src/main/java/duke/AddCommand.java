package duke;

/*
 *  AddCommand.java
 *  Defines the 'Add' action flow to insert tasks.
 */

public class AddCommand extends Command {
    protected Task task;

    /*
     * Constructs Add Command object with parsed task.
     * @param Parsed task.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /*
     * This method 'Executes' the command and display message
     * after successfully inserting task.
     * @param tasks Object of Task class.
     * @param storage Object of Storage class.
     */
    @Override
    public String execute(TaskList tasks, Storage storage) {
        //add task into task list
        TaskList.addTask(task);
        //display successful message and task count
        String output = "\tGot it. I've added this task:\n";
        output = output + "\t " + task.toString() + "\n";
        output = output + "\tNow you have " + tasks.getTaskSize() + " tasks in the list.\n";

        return output;
    }

    /*
     * Returns not to exit program.
     * @return false Command 'duke' not to exit
     * after add command.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
package duke;

/*
 *  DoneCommand.java
 *  Defines the 'Done' action flow to mark tasks
 *  as completed or done.
 */

public class DoneCommand extends Command {
    private int index;

    /*
     * Constructs Done Command object with task index.
     * @param index Parsed task index.
     */
    public DoneCommand(int index) {
        this.index = index;
    }

    /*
     * This method 'Executes' the command and display message
     * after successfully marking task as completed.
     * @param tasks Object of Task class.
     * @param storage Object of Storage class.
     */
    @Override
    public String execute(TaskList tasks, Storage storage) {
        //mark task as completed
        Task task = TaskList.doneTask(index - 1);
        //display successful message
        String output = "\tNice! I've marked this task as done:\n";
        output = output + "\t  " + task;
        return output;
    }

    /*
     * Returns not to exit program.
     * @return false Command 'duke' not to exit
     * after done command.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
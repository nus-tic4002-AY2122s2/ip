package duke;

/*
 *  UpdateCommand.java
 *  Defines the 'update' action flow to update
 *  Date and Time of Event or Deadline Object.
 */

public class UpdateCommand extends Command {
    private int index;
    private String dateTime;

    /**
     * Constructs Update Command object with task index.
     * @param index Parsed task index.
     * @param dateTime Updated data and time
     */
    public UpdateCommand(int index,String dateTime) {
        this.index = index;
        this.dateTime = dateTime;
    }

    /*
     * This method 'Executes' the command and display message
     * after successfully updated date and time.
     * @param tasks Object of Task class.
     * @param storage Object of Storage class.
     */
    @Override
    public String execute(TaskList tasks, Storage storage) {
        //mark task as completed
        Task task = TaskList.updateTask(index - 1,dateTime);
        //display successful message
        String output = "\tNice! I've updated this task:\n";
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
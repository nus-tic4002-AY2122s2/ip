package duke;

/*
 *  ExitCommand.java
 *  Defines the 'Exit' action flow to exit program.
 */

public class ExitCommand extends Command {
    /**
     *  Constructs Exit Command object.
     */
    public ExitCommand(){

    }

    /*
     * This method 'Executes' the command and
     *  display 'Goodbye' message.
     * @param tasks Object of Task class.
     * @param storage Object of Storage class.
     */
    @Override
    public String execute(TaskList tasks, Storage storage) {
        //save and store all tasks.
        storage.save(TaskList.getTaskList());
        //display goodbye message
        return "\tBye. Hope to see you again soon!";
    }

    /*
     * Returns to exit program.
     * @return false Command 'duke' not to exit
     * after exit command.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
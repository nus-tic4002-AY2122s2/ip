package duke;

/*
 *  ExitCommand.java
 *  Defines the 'Exit' action flow to exit program.
 */

public class SaveCommand extends Command {
    /**
     *  Constructs Save Command object.
     */
    public SaveCommand(){

    }

    /*
     * This method 'Executes' the command and
     *  display 'Saved' message.
     * @param tasks Object of Task class.
     * @param storage Object of Storage class.
     */
    @Override
    public String execute(TaskList tasks, Storage storage) {
        //save and store all tasks.
        storage.save(TaskList.getTaskList());
        //display saved message
        return "\t All tasks have been saved.";
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
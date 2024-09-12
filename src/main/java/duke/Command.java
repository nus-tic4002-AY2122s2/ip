package duke;

/*
 *  Command.java
 *  Defines the abstract Command class that all commands have the following method.
 */
public abstract class Command {
    /*
     * This method 'Executes' the command.
     * @param tasks Object of Task class.
     * @param storage Object of Storage class.
     */
    public abstract String execute(TaskList tasks, Storage storage);

    /*
     * Returns to or not to exit program.
     * @return Command 'duke' to or not to exit
     */
    public abstract boolean isExit();
}
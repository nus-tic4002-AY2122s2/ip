package command;

import basic.Storage;
import basic.TaskList;
import basic.Ui;

/**
 * Terminates the program.
 */

public class ExitCommand extends Command {
    protected static Ui ui = new Ui();

    private static void exit() {
        ui.showBye();
        System.exit(0);
    }

    /**
     * Executes ExitCommand.
     *  @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     * @param exCommand The previous command entered. 
     * @return .Bye response.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage, TaskList deletedTasks, 
                            String exCommand) {
        exit();
        return ui.showBye();
    }

}

package commands;

import storage.Storage;
import task_classes.TaskList;
import ui.Ui;

public class ExitCommand extends Command {

    public ExitCommand() {

    }

    /**
     * The method to execute command
     *
     * @param taskList contain all the task
     * @param ui Ui class
     * @param storage Storage class
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Ui.printGoodbyeOutput();
    }

    /**
     * The method to let system know whether the command is to exit the Duke
     * @return return true, the program needs to be terminated. Exit Duke
     */
    @Override
    public boolean isExit() {
        return true;
    }
}

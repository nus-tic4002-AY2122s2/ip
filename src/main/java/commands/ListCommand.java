package commands;

import storage.Storage;
import taskclasses.TaskList;
import ui.Ui;

public class ListCommand extends Command {

    public ListCommand() {

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
        taskList.toPrintEntireTaskList();
    }

    /**
     * The method to let system know whether the command is to exit the Duke
     * @return return false, the program continue
     */
    @Override
    public boolean isExit() {
        return false;
    }
}

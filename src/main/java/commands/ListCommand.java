package commands;

import exceptions.DukeTaskInputException;
import storage.Storage;
import task_classes.TaskList;
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
     * @throws DukeTaskInputException throw all errors about input command
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException {
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

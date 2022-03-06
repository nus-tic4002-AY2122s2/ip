package command;

import exception.ErrorHandler;
import storage.Storage;
import taskList.TaskList;

public class ByeCommand extends Command {
    @Override
    public void execute(Storage storage, TaskList taskList) throws ErrorHandler {
        try {
            this.saveData(storage, taskList);
            this.executionResult.setSystemMsg("Bye. Hope to see you again soon!");
        } catch (ErrorHandler e) {
            throw new ErrorHandler("while exiting program: " + e.getMessage());
        }
    }
}

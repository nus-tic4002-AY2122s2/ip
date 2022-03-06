package command;

import storage.Storage;
import taskExecutor.ExecutionResult;
import taskList.TaskList;
import exception.ErrorHandler;

public abstract class Command {
    protected ExecutionResult executionResult = new ExecutionResult();

    protected void saveData(Storage storage, TaskList taskList) throws ErrorHandler {
        String[] data = taskList.getFileDataFormatList();
        storage.saveData(data);
    }

    public ExecutionResult getExecutionResult() {
        return executionResult;
    }

    public abstract void execute(Storage storage, TaskList taskList) throws ErrorHandler;
}


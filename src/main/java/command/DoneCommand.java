package command;

import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import taskList.TaskList;

public class DoneCommand extends Command {
    private final int taskNumber;

    public DoneCommand(String taskNumber) throws ErrorHandler {
        try {
            int index = Integer.parseInt(taskNumber);
            this.taskNumber = index;
        } catch (Exception e) {
            throw new ErrorHandler("while parsing task number :" + e.getMessage());
        }
    }

    @Override
    public void execute(Storage storage, TaskList taskList) throws ErrorHandler {
        if (this.taskNumber > 0 && this.taskNumber <= taskList.getSize()) {
            taskList.setStatus(this.taskNumber - 1, true);
            this.saveData(storage, taskList);
            String information =
                "Nice! I've marked this task as done:\n" + taskList.getTask(this.taskNumber - 1).toString();

            this.executionResult.setSystemMsg(information);

        } else {
            throw new ErrorHandler("In Command, " + ErrorMessage.INVALID_TASK_NUMBER);
        }
    }

}

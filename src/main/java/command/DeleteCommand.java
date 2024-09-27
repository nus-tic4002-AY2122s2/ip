package command;

import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import taskList.TaskList;

public class DeleteCommand extends Command {
    private final int taskNumber;

    public DeleteCommand(String taskNumber) throws ErrorHandler {
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
            int deleteIndex = this.taskNumber - 1;
            String deletedItem = taskList.getTask(deleteIndex).toString();
            taskList.removeItem(deleteIndex);
            this.saveData(storage, taskList);

            String information = "Noted. I've removed this task:\n" + deletedItem + "\nNow you have " + " tasks in " +
                taskList.getSize() + "the list.";

            this.executionResult.setSystemMsg(information);
        } else {
            throw new ErrorHandler("In Command, " + ErrorMessage.INVALID_TASK_NUMBER);
        }
    }
}

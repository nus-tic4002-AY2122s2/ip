package duke.commands;

import duke.task.Task;

import java.time.LocalDateTime;

/**
 * Update the task based on the element that want to be updated
 * @param <T> the new value for updated task, e.g. description, due etc.
 */
public class UpdateCommand<T> extends Command {
    public static final String COMMAND_WORD = "update";

    public static final String MESSAGE_USAGE = "||update";
    private int targetIndex;
    private String toUpdate;
    private T newValue;

    /**
     * Constructor of the UpdateCommand
     */
    public UpdateCommand(int targetIndex, String toUpdate, T newValue) {
        this.targetIndex = targetIndex;
        this.toUpdate = toUpdate;
        this.newValue = newValue;
    }

    @Override
    public String execute() {
        String commandResult;
        Task target = taskList.getTaskByIdx(targetIndex);
        String original = target.toString();
        switch (toUpdate) {
        case "desc":
        case "description":
            target.updateTask((String) newValue);
            break;
        case "tasktime":
        default:
            target.updateTask((LocalDateTime) newValue);
            break;
        }
        commandResult = original + "\nupdated to\n" + taskList.getTaskByIdx(targetIndex).toString();
        return commandResult;
    }
}

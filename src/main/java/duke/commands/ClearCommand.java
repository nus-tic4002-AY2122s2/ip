package duke.commands;

public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_USAGE = "||" + COMMAND_WORD + ": clear all the tasks in the task list.";

    @Override
    public String execute() {
        taskList.clear();
        return "All the tasks are cleared.\n";
    }
}

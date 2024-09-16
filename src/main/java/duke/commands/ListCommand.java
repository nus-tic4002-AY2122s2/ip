package duke.commands;


/**
 * List all the tasks in the taskList.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = "||" + COMMAND_WORD + ": list the all the tasks in the task list.";


    @Override
    public String execute() {
        String commandResult = "";
        if (taskList.getSize() == 0) {
            return "There isn't any tasks in the list.\n";
        }
        for (int i = 1; i <= taskList.getSize(); i++) {
            commandResult += i + ". " + taskList.getTaskByIdx(i).toString() + "\n";
        }
        return commandResult;
    }
}

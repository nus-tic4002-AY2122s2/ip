package duke.commands;


import java.util.Collections;

/**
 * Sort the tasks in the list by the task finish time
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = "||"
            + COMMAND_WORD + ": sort the all the tasks in the task list by finish date in descending order.";


    @Override
    public String execute() {
        String commandResult = "";
        if (taskList.getSize() == 0) {
            return "There isn't any tasks in the list.\n";
        }

        Collections.sort(taskList.getTasks(), (t1, t2) -> {
            if (t1.getFinishTime().isAfter(t2.getFinishTime())) {
                return -1;
            } else {
                return 1;
            }
        });

        for (int i = 1; i <= taskList.getSize(); i++) {
            commandResult += i + ". " + taskList.getTaskByIdx(i).toString() + "\n";
        }
        return  commandResult;
    }
}

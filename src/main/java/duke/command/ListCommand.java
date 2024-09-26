package duke.command;

import duke.TaskList;
import duke.UI;

public class ListCommand extends Command {
    /**
     * Create new list command.
     * @param fullCommand user full command.
     * */
    public ListCommand(String fullCommand) {
        super(fullCommand);
    }

    /**
     * Method to execute list command.
     * @param taskList task list to be updated
     * */
    public String run(TaskList taskList) {
        return UI.listMessage(taskList.tasks);
    }
}

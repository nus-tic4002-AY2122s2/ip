package duke.command;

import duke.TaskList;
import duke.UI;

public class ByeCommand extends Command {
    /**
     * Create new bye command.
     * @param fullCommand user full command.
     * */
    public ByeCommand(String fullCommand) {
        super(fullCommand);
    }

    /**
     * Method to execute bye command.
     * @param taskList task list to be updated
     * */
    public String run(TaskList taskList) {
        return UI.byeMessage();
    }
}

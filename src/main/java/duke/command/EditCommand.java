package duke.command;

import duke.Parser;
import duke.TaskList;
import duke.UI;
import duke.exception.LackOfIndexException;

public class EditCommand extends Command {
    /**
     * Create new edit command.
     * @param fullCommand user full command.
     * */
    public EditCommand(String fullCommand) {
        super(fullCommand);
    }

    private static void checkElement(String fullCommand) throws LackOfIndexException {
        if (fullCommand.trim().equals("edit")) {
            throw new LackOfIndexException();
        }
    }

    /**
     * Method to execute edit command.
     * @param taskList task list to be updated
     * */
    public String run(TaskList taskList) {
        try {
            checkElement(fullCommand);
            int index = Parser.taskNumber(fullCommand);
            taskList.tasks.get(index).description = Parser.editedItem(fullCommand);
            return UI.editMessage(taskList.tasks, index);
        } catch (LackOfIndexException e) {
            return "OOPS!!! Pls key in the number of the task";
        } catch (IndexOutOfBoundsException e) {
            return "OOPS!!! The number of task is invalid";
        }
    }
}

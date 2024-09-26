package duke.command;

import duke.Parser;
import duke.TaskList;
import duke.UI;
import duke.exception.LackOfIndexException;

public class DoneCommand extends Command {
    /**
     * Create new done command.
     * @param fullCommand user full command.
     * */
    public DoneCommand(String fullCommand) {
        super(fullCommand);
    }

    private static void checkElement(String fullCommand) throws LackOfIndexException {
        if (fullCommand.trim().equals("done")) {
            throw new LackOfIndexException();
        }
    }

    /**
     * Method to execute done command.
     * @param taskList task list to be updated
     * */
    public String run(TaskList taskList) {
        try {
            checkElement(fullCommand);
            int index = Parser.taskNumber(fullCommand);
            taskList.done(index);
            return UI.doneMessage(taskList.tasks, index);
        } catch (LackOfIndexException e) {
            return "OOPS!!! Pls key in the number of the task";
        } catch (IndexOutOfBoundsException e) {
            return "OOPS!!! The number of task is invalid";
        }
    }
}

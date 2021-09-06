package duke.command;

import duke.Parser;
import duke.TaskList;
import duke.UI;
import duke.exception.LackOfIndexException;

public class DoneCommand extends Command {
    public DoneCommand(String fullCommand) {
        super(fullCommand);
    }

    private static void checkElement(String fullCommand) throws LackOfIndexException {
        if (fullCommand.trim().equals("done") ) {
            throw new LackOfIndexException();
        }
    }

    public void run(TaskList taskList) {
        try {
            checkElement(fullCommand);
            int index = Parser.taskNumber(fullCommand);
            taskList.done(index);
            UI.doneMessage(taskList.tasks, index);
        } catch (LackOfIndexException e) {
            System.out.println("OOPS!!! Pls key in the number of the task");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("OOPS!!! The number of task is invalid");
        }
    }
}

package duke.command;

import duke.Parser;
import duke.TaskList;
import duke.UI;
import duke.exception.LackOfDateException;
import duke.exception.LackOfDescriptionException;

public class AddEventCommand extends Command {
    /**
     * Create new add-event command.
     * @param fullCommand user full command.
     * */
    public AddEventCommand(String fullCommand) {
        super(fullCommand);
    }

    private static void checkDescription(String fullCommand) throws LackOfDescriptionException {
        if (fullCommand.trim().equals("event") ) {
            throw new LackOfDescriptionException();
        }
    }

    private static void checkDate(String fullCommand, String description) throws LackOfDateException {
        if ( fullCommand.equals("deadline " + description)
                || fullCommand.trim().equals("deadline " + description + " /at") ) {
            throw new LackOfDateException();
        }
    }
    /**
     * Method to execute add-event command.
     * @param taskList task list to be updated.
     * */
    public void run(TaskList taskList) {
        try {
            checkDescription(fullCommand);
            String description = Parser.description(fullCommand);
            checkDate(fullCommand, description);
            String date = Parser.date(fullCommand);
            taskList.addEvent(description, date);
            int size = taskList.size;
            UI.addMessage(taskList.tasks.get(size - 1), size);
        } catch (LackOfDescriptionException e) {
            System.out.println("OOPS!!! Pls key in the description for the task");
        } catch (LackOfDateException e) {
            System.out.println("OOPS!!! Pls key in the date for the task");
        }
    }
}

package duke.command;

import duke.Parser;
import duke.TaskList;
import duke.UI;

import duke.exception.LackOfKeywordException;

import java.util.ArrayList;

public class FindCommand extends Command {
    /**
     * Create new done command.
     * @param fullCommand user full command.
     * */
    public FindCommand(String fullCommand) {
        super(fullCommand);
    }

    private static void checkElement(String fullCommand) throws LackOfKeywordException {
        if (fullCommand.trim().equals("find")) {
            throw new LackOfKeywordException();
        }
    }

    /**
     * Method to execute find command.
     * @param taskList task list to be found.
     * */
    public String run(TaskList taskList) {
        try {
            checkElement(fullCommand);
            String keyword = Parser.description(fullCommand);
            ArrayList<Integer> findResult = new ArrayList<>();
            taskList.find(keyword, findResult);
            return UI.findMessage(taskList.tasks, findResult);
        } catch (LackOfKeywordException e) {
            return "OOPS!!! Please key in the keyword you want to search";
        }
    }
}

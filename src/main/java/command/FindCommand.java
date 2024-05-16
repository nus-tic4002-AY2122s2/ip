package command;

import exception.DukeException;
import basic.Storage;
import basic.TaskList;
import basic.Ui;


/**
 * Finds relevant tasks in the TaskList.
*/
public class FindCommand extends Command {
    private String input;
    private String response = "";

    public FindCommand(String input) {
        this.input = input;
    }

    /**
     * Executes FindCommand.
     *  @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     * @param exCommand The previous command entered. 
     * @throws DukeException If the search keyword is empty or there is no matching task. 
     * @return The response.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage, TaskList deletedTasks, 
                            String exCommand) throws DukeException {
        input = input.toLowerCase();
        input = input.replace("find ", "");
        if (input.equals("") || input.equals(" ")) {
            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means.\n");
        } else {
            int count = 0;
            for (int i = 0; i < tasks.sizeOfTask(); i++) {
                if (tasks.returnTask(i).description.contains(input)) {
                    if (count == 0) {
                        response += ui.printMatching();
                    }
                    response += ui.printMatchingTask(tasks.returnTask(i), i + 1);
                    count++;
                }
            }
            if (count == 0) {
                throw new DukeException("No matching tasks in your list.");
            }
            return response;
        }
    }

}

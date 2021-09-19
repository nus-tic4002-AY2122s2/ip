package command;

import storage.Storage;
import tasklist.TaskList;
import ui.UI;

public class DeleteCommand extends Command{
    String userInput;

    public DeleteCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        tasks.deleteTask(userInput);
    }
}

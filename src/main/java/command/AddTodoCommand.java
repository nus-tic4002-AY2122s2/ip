package command;

import storage.Storage;
import tasklist.TaskList;
import ui.UI;

public class AddTodoCommand extends Command{
    String userInput;

    public AddTodoCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        tasks.todo(userInput);
    }
}

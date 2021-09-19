package command;

import storage.Storage;
import tasklist.TaskList;
import ui.UI;

public class AddEventCommand extends Command{
    String userInput;

    public AddEventCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        tasks.event(userInput);
    }
}

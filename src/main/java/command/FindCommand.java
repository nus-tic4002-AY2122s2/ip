package command;

import storage.Storage;
import taskList.TaskList;

import java.util.ArrayList;

public class FindCommand extends Command {
    private final String searchContent;

    public FindCommand(String searchContent) {
        this.searchContent = searchContent;
    }

    @Override
    public void execute(Storage storage, TaskList taskList) {
        ArrayList<String> filteredList = new ArrayList();

        int index = 1;
        for (String listItem : taskList.findTasks(this.searchContent)) {
            filteredList.add(index + ". " + listItem);
            index += 1;
        }

        this.executionResult.setResult(filteredList.toArray(new String[0]));
    }
}

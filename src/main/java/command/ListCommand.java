package command;

import storage.Storage;
import taskList.TaskList;

import java.util.ArrayList;

public class ListCommand extends Command {
    @Override
    public void execute(Storage storage, TaskList taskList) {
        ArrayList<String> filteredList = new ArrayList();

        int index = 1;
        for (String listItem : taskList.getSerializedList()) {
            filteredList.add(index + ". " + listItem);
            index += 1;
        }

        this.executionResult.setResult(filteredList.toArray(new String[0]));
    }
}


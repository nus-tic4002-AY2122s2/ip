package commands;

import exceptions.DukeTaskInputException;
import storage.Storage;
import task_classes.Task;
import task_classes.TaskList;
import ui.Ui;

import java.util.Vector;

public class FindCommand extends Command {

    private String keyword;

    public FindCommand (String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException {
        Vector<Task> list = taskList.getVectorList();
        Vector<Task> matchedTaskList = getMatchedTasks(list);

        TaskList.toPrintEntireTaskList(matchedTaskList); // print all the matched task
    }

    @Override
    public boolean isExit() {
        return false;
    }

    private Vector<Task> getMatchedTasks (Vector<Task> list) {
        Vector<Task> matchedTaskList = new Vector<>();
        for(Task task: list){
            String description = task.getDescription();
            String[] descriptionWords = description.split(" ");
            for(String word : descriptionWords) {
                if(word.equals(keyword)) {
                    matchedTaskList.add(task);
                }
            }
        }

        return matchedTaskList;
    }
}

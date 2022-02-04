package edu.nus.duke.command;

import java.util.ArrayList;

import edu.nus.duke.task.Task;
import edu.nus.duke.task.TaskList;

public class CommandDataHistory {
    private ArrayList<ArrayList<Task>> taskLists;

    public CommandDataHistory() {
        taskLists = new ArrayList<>();
    }

    public int getSize() {
        return taskLists.size();
    }

    public void add(TaskList taskList) {
        taskLists.add(taskList.getTasksCopy());
    }

    public ArrayList<Task> pop() {
        return taskLists.remove(getSize() - 1);
    }
}

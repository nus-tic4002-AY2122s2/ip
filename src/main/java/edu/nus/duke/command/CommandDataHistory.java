package edu.nus.duke.command;

import java.util.ArrayList;

import edu.nus.duke.task.Task;
import edu.nus.duke.task.TaskList;

/**
 * Data structure to keep history of TaskList after commands execution.
 */
public class CommandDataHistory {
    private ArrayList<ArrayList<Task>> taskLists;

    /**
     * Constructor of CommandDataHistory class.
     */
    public CommandDataHistory() {
        taskLists = new ArrayList<>();
    }

    /**
     * Returns size of taskLists.
     *
     * @return Size of taskLists.
     */
    public int getSize() {
        return taskLists.size();
    }

    /**
     * Append a copy of TaskList to taskLists.
     *
     * @param taskList Duke TaskList.
     */
    public void add(TaskList taskList) {
        taskLists.add(taskList.getTasksCopy());
    }

    /**
     * Remove and return last element of taskLists.
     *
     * @return Last ArrayList Task of taskLists.
     */
    public ArrayList<Task> pop() {
        return taskLists.remove(getSize() - 1);
    }
}

package edu.nus.duke.command;

import java.util.ArrayList;

import edu.nus.duke.task.TaskList;

public class CommandDataHistory {
    private ArrayList<TaskList> taskLists;

    public CommandDataHistory() {
        taskLists = new ArrayList<>();
    }

    public void add(TaskList taskList) {
        taskLists.add(taskList);
    }
}

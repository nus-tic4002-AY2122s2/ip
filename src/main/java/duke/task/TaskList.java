package duke.task;

import java.util.ArrayList;

/**
 * Store the list of task for the program to call and use
 */
public class TaskList {

    private static ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Constructs the task list
     */
    public TaskList() {

    }

    /**
     * Constructs the task list with an available list of task
     * @param tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;

    }

    public static Task getTask(int i) {
        return tasks.get(i);
    }

    /**
     * Remove the task from the list that the user requested
     * @param taskIndex the task index that the user requested
     */
    public void remove(int taskIndex) {
        tasks.remove(taskIndex);
        for (int i = taskIndex; i < tasks.size(); i++) {
            tasks.get(i).setTaskIndex(i);
        }
    }
    /**
     * Getting the number of task in the list
     * @return the number of task in the list
     */
    public static int getSize() {
        return tasks.size();
    }

    /**
     * Adding of task into the task list and set the task index as well as display the action after it has been added
     * @param s the task that the user requested to be added
     */
    public static void addTask(Task s) {
        tasks.add(s);
        s.setTaskIndex(tasks.size() - 1);
    }

    /**
     * Check if task list is empty
     * @return if task is empty or not
     */
    public static boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Remove everything from the task list
     */
    public void clearAll() {
        tasks.clear();
    }
}

package basic;

import task.Task;

import java.util.ArrayList;

public class TaskList {
    /**
     * Constructs a new task list and initialises it with an empty ArrayList.
     */
    public ArrayList<Task> tasks = new ArrayList<Task>();

    /**
     * Checks if the task was marked as done
     *
     * @param myString one task in the txt file
     * @return true if the tasks was marked as done, else return false
     */
    private boolean isDone(String myString) {
        return !myString.toLowerCase().contains("[✘]");
    }

    /**
     * Converts all strings in the txt file to tasks
     *
     * @param list task list in string form.
     */
    public TaskList(ArrayList<String> list) {
        for (String s : list) {
            if (isDone(s)) {
                returnTask(sizeOfTask() - 1).isDone = true;
            }
        }
    }

    ArrayList<Task> returnList() {
        return tasks;
    }

    /**
     * Returns the task from the specified index from the task list.
     *
     * @param num The index the task.
     * @return Task The task at the specified index.
     */
    public Task returnTask(int num) {
        return tasks.get(num);
    }

    /**
     * Adds a task to the task list.
     *
     * @param task1 The task that is required to be added to the task list.
     */
    public void addTask(Task task1) {        
        tasks.add(task1);
    }

    /**
     * Deletes a task from the task list.
     *
     * @param num The index of a task that is required to be removed from the task list.
     */
    public void deleteTask(int num) {
        tasks.remove(num);
    }

    /**
     * Returns the size of the current task list.
     *
     * @return int  The size of the current task list.
     */
    public int sizeOfTask() {
        return tasks.size();
    }

}

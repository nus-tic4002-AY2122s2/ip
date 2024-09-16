package duke.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * A list of tasks.
 */
public class TaskList implements Iterable<Task> {

    private final List<Task> taskList = new ArrayList<>();

    /**
     * Construct an empty taskList.
     */
    public TaskList() {
    }

    /**
     * z
     * Construct a taskList with the given tasks.
     */
    public TaskList(Task[] tasks) {
        final List<Task> initialTasks = Arrays.asList(tasks);
        taskList.addAll(initialTasks);
    }

    /**
     * Constructs a taskList from the items in the given collection.
     *
     * @param tasks a collection of tasks
     */
    public TaskList(Collection<Task> tasks) {
        taskList.addAll(tasks);
    }

    /**
     * Constructs a shallow copy of the list.
     */
    public TaskList(TaskList source) {
        taskList.addAll(source.taskList);
    }

    /**
     * Adds a task to the list
     *
     * @param toAdd the task to add
     */
    public void addTask(Task toAdd) throws DuplicateTaskException {
        if (contains(toAdd)) {
            throw new DuplicateTaskException();
        }
        taskList.add(toAdd);
    }

    /**
     * check if a task is already exist in the taskList
     *
     * @param toCheck the task to check
     */
    public boolean contains(Task toCheck) {
        for (Task task : taskList) {
            if (task.equals(toCheck)) {
                return true;
            }
        }
        return false;
    }

    /**
     * gets the specific task by index in the list
     *
     * @param taskIdx the index in the taskList
     * @return a Task
     */
    public Task getTaskByIdx(int taskIdx) {
        return taskList.get(taskIdx - 1);
    }

    /**
     * Remove a task from a list based on Task Object
     *
     * @param toRemove the Task to remove
     */
    public void removeTask(Task toRemove) {
        taskList.remove(toRemove);
    }

    /**
     * Remove a task from the list based on the index
     *
     * @param toRemoveIdx the index in the taskList
     */
    public void removeTask(int toRemoveIdx) {
        taskList.remove(toRemoveIdx);
    }

    /**
     * Remove a tasks set from a list based on {@link List} of {@link Task}
     *
     * @param toRemove the task set to remove
     */
    public void removeTasks(List<Task> toRemove) {
        taskList.removeAll(toRemove);
    }

    /**
     * gets the size of the taskList
     *
     * @return the int size
     */
    public int getSize() {
        return taskList.size();
    }

    /**
     * gets taskList
     *
     * @return the tasklist
     */
    public List<Task> getTasks() {
        return taskList;
    }

    /**
     * gets all the tasks in the taskList
     *
     * @return a new TaskList
     */
    public TaskList getAllTasks() {
        return new TaskList(taskList);
    }

    /**
     * clear all the task in the tasklist
     */
    public void clear() {
        taskList.clear();
    }

    @Override
    public Iterator<Task> iterator() {
        return taskList.iterator();
    }

    /**
     * Signals that an operation would have violated the 'no duplicates' task of the list.
     */
    public static class DuplicateTaskException extends Exception {
        public DuplicateTaskException() {
            super("There is a same task which already existed in the task list.");
        }
    }
}

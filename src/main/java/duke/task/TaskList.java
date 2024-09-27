package duke.task;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class TaskList {
    private List<Task> tasks = new ArrayList<>();

    /**
     * Constructs a new empty task list.
     */
    public TaskList() {
    }

    /**
     * Parse the given string to a task.
     *
     * @param line Line to parse.
     * @return Parsed task.
     */
    private Task parseTask(String line) {
        String[] load = line.split("\\|");
        Task task;
        switch (load[0]) {
        case "T":
            task = new ToDo(load[2]);
            break;
        case "D":
            task = new Deadline(load[2], load[3]);
            break;
        case "E":
            task = new Event(load[2], load[3]);
            break;
        default:
            return null;
        }
        if (load[1].equals("1")) {
            task.markAsDone();
        }
        return task;
    }

    /**
     * Constructs a task list with the parsed tasks.
     *
     * @param lines List of lines to parse tasks.
     */
    public TaskList(List<String> lines) {
        for (String line : lines) {
            tasks.add(parseTask(line));
        }
    }

    /**
     * Converts the task list into a list of lines for saving.
     *
     * @return A list of converted tasks.
     */
    public List<String> convertAsLines() {
        List<String> saveIn = new ArrayList<>();
        for (Task task : tasks) {
            saveIn.add(getSaveIn(task));
        }
        return saveIn;
    }

    /**
     * Converts the provided task to a string for saving.
     *
     * @param task To convert into a string.
     * @return String for saving.
     */
    private String getSaveIn(Task task) {
        StringJoiner joiner = new StringJoiner("|");
        for (String stringLine : task.getList()) {
            joiner.add(stringLine);
        }
        return joiner.toString();
    }

    /**
     * Adds a task to the task list.
     *
     * @param task Task to add.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Remove a task from the task list according to index provided by the user.
     *
     * @param index Position of the task in the list.
     * @return The removed task.
     */
    public Task remove(int index) {
        return tasks.remove(index);
    }

    /**
     * Return the task of given index in the list.
     *
     * @param index Position of the task in the list.
     * @return The requested task.
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Return of the size of the task list.
     *
     * @return The size of the task list.
     */
    public int size() {
        return tasks.size();
    }
}

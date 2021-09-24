package edu.nus.duke.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import edu.nus.duke.parser.Parser;
import edu.nus.duke.ui.Ui;
import edu.nus.duke.exception.DukeInvalidTaskIndexException;

/**
 * Class that contains the task list
 */
public class TaskList {
    // Variables
    private ArrayList<Task> tasks;

    // Constructor
    public TaskList() {
        tasks = new ArrayList<>();
    }

    // Getter
    /**
     * Return the tasks size as an integer.
     *
     * @return tasks size.
     */
    public int getListSize() {
        return tasks.size();
    }

    /**
     * Print tasks with total count, filtered by date.
     *
     * @param dateFilter Date filter.
     */
    public void printTasks(LocalDate dateFilter) {
        int printCount = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (isExclude(task, dateFilter)) {
                continue;
            }

            Ui.printMessage((i + 1) + ". " + task.getTask(), false);
            printCount++;
        }
        Ui.printMessage("Total tasks: " + printCount);
    }

    /**
     * Return a string with all tasks for file save.
     *
     * @return string with all tasks.
     */
    public String printForFile() {
        StringBuilder output = new StringBuilder();
        for (Task task : tasks) {
            output.append(task.printForSave());
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    // Setter
    /**
     * Add a task.
     *
     * @param task A {@code Task} to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
        Ui.printMessage("added: " + task.getTask());
    }

    /**
     * Add a task from Array of elements.
     *
     * @param elements Array of elements.
     * @throws DukeInvalidTaskIndexException If task index is invalid.
     * @throws ArrayIndexOutOfBoundsException If bad input is read from file.
     * @throws DateTimeParseException If datetime input is invalid.
     */
    public void addTask(String[] elements) throws DukeInvalidTaskIndexException, ArrayIndexOutOfBoundsException,
            DateTimeParseException {
        String taskType = elements[0];
        boolean isDone = elements[1].equals("1");
        String taskName = elements[2];

        switch (taskType) {
            case "T":
                tasks.add(new Todo(taskName, isDone));
                break;
            case "D":
                LocalDateTime by = Parser.parseDt(elements[3]);
                tasks.add(new Deadline(taskName, by, isDone));
                break;
            case "E":
                LocalDateTime at = Parser.parseDt(elements[3]);
                tasks.add(new Event(taskName, at, isDone));
                break;
            default:
                throw new DukeInvalidTaskIndexException();
        }
    }

    /**
     * Set a task to done.
     *
     * @param idx Task index.
     */
    public void doneTask(int idx) {
        try {
            tasks.get(idx).setDone();
            Ui.printMessage("done: " + tasks.get(idx).getTask());
        } catch (IndexOutOfBoundsException e) {
            Ui.printMessage("Invalid/missing index");
        }
    }

    /**
     * Delete a task.
     *
     * @param idx Task index.
     */
    public void deleteTask(int idx) {
        try {
            String task = tasks.get(idx).getTask();
            tasks.remove(idx);
            Ui.printMessage("deleted: " + task);
        } catch (IndexOutOfBoundsException e) {
            Ui.printMessage("Invalid/missing index");
        }

    }

    // Methods
    private boolean isExclude(Task task, LocalDate date) {
        if (date != null) {
            if (task instanceof Deadline) {
                return !((Deadline)task).getBy().toLocalDate().equals(date);
            } else if (task instanceof Event) {
                return !((Event)task).getAt().toLocalDate().equals(date);
            }
            return true;
        }
        return false;
    }
}

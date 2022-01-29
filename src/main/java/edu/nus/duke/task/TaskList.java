package edu.nus.duke.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import edu.nus.duke.exception.DukeInvalidTaskIndexException;
import edu.nus.duke.parser.Parser;

/**
 * Class that contains the task list
 */
public class TaskList {
    // Variables
    private final ArrayList<Task> tasks;

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
     * Print tasks with total count, filtered by date or text.
     *
     * @param initMessage Feedback prefix string to the user.
     * @param dateFilter Date filter.
     * @param textFilter Text filter.
     */
    public String printTasks(String initMessage, LocalDate dateFilter, String textFilter) {
        StringBuilder feedback = new StringBuilder();
        feedback.append(initMessage);
        feedback.append(System.lineSeparator());
        int printCount = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (isExclude(task, dateFilter, textFilter)) {
                continue;
            }

            feedback.append(i + 1);
            feedback.append(". ");
            feedback.append(task.getTask());
            feedback.append(System.lineSeparator());
            printCount++;
        }
        feedback.append("Total tasks: ");
        feedback.append(printCount);
        feedback.append(System.lineSeparator());
        return feedback.toString();
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
     * Add a task and return feedback string to the user.
     *
     * @param task A {@code Task} to be added.
     * @return Feedback string to user.
     */
    public String addTask(Task task) {
        tasks.add(task);
        return ("added: " + task.getTask());
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
     * Set a task to done and return feedback string to the user.
     *
     * @param idx Task index.
     * @return Feedback string to user.
     */
    public String doneTask(int idx) {
        try {
            tasks.get(idx).setDone();
            return ("done: " + tasks.get(idx).getTask());
        } catch (IndexOutOfBoundsException e) {
            return ("Invalid/missing index");
        }
    }

    /**
     * Delete a task and return feedback string to the user.
     *
     * @param idx Task index.
     * @return Feedback string to the user.
     */
    public String deleteTask(int idx) {
        try {
            String task = tasks.get(idx).getTask();
            tasks.remove(idx);
            return ("deleted: " + task);
        } catch (IndexOutOfBoundsException e) {
            return ("Invalid/missing index");
        }

    }

    // Methods
    private boolean isExclude(Task task, LocalDate date, String text) {
        if (date != null) {
            if (task instanceof Deadline) {
                return !((Deadline) task).getBy().toLocalDate().equals(date);
            } else if (task instanceof Event) {
                return !((Event) task).getAt().toLocalDate().equals(date);
            } else {
                return true;
            }
        }

        if (text != null) {
            return !(task.getTaskName().contains(text));
        }

        return false;
    }
}

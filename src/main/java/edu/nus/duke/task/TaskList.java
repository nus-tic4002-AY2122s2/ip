package edu.nus.duke.task;

import java.util.ArrayList;

import edu.nus.duke.ui.Ui;
import edu.nus.duke.exception.DukeInvalidTaskIndexException;

public class TaskList {
    // Variables
    private ArrayList<Task> tasks;

    // Constructor
    public TaskList() {
        tasks = new ArrayList<>();
    }

    // Getter
    public int getListSize() {
        return tasks.size();
    }

    public String printTasks() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            output.append(i + 1);
            output.append(". ");
            output.append(tasks.get(i).getTask());
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    public String printForFile() {
        StringBuilder output = new StringBuilder();
        for (Task task : tasks) {
            output.append(task.printForSave());
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    // Setter
    public void addTask(Task task) {
        tasks.add(task);
        Ui.printMessage("added: " + task.getTask());
    }

    public void addTask(String[] elements) throws DukeInvalidTaskIndexException, ArrayIndexOutOfBoundsException {
        String taskType = elements[0];
        boolean isDone = elements[1].equals("1");
        String taskName = elements[2];

        switch (taskType) {
            case "T":
                tasks.add(new Todo(taskName, isDone));
                break;
            case "D":
                String by = elements[3];
                tasks.add(new Deadline(taskName, by, isDone));
                break;
            case "E":
                String at = elements[3];
                tasks.add(new Event(taskName, at, isDone));
                break;
            default:
                throw new DukeInvalidTaskIndexException();
        }
    }

    public void doneTask(int idx) {
        try {
            tasks.get(idx).setDone();
            Ui.printMessage("done: " + tasks.get(idx).getTask());
        } catch (IndexOutOfBoundsException e) {
            Ui.printMessage("Invalid/missing index");
        }
    }

    public void deleteTask(int idx) {
        try {
            String task = tasks.get(idx).getTask();
            tasks.remove(idx);
            Ui.printMessage("deleted: " + task);
        } catch (IndexOutOfBoundsException e) {
            Ui.printMessage("Invalid/missing index");
        }

    }
}

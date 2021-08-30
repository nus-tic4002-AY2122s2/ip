package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;

public class TaskList {
    public ArrayList<Task> tasks;
    public int size;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.size = tasks.size();
    }

    public void done(int index) {
        tasks.get(index).markAsDone();
    }

    public void addTodo(String description) {
        Task task = new Todo(description);
        tasks.add(task);
        size++;
    }

    public void addDeadline(String description, String date) {
        Task task = new Deadline(description, date);
        tasks.add(task);
        size++;
    }

    public void addEvent(String description, String date) {
        Task task = new Event(description, date);
        tasks.add(task);
        size++;
    }
}

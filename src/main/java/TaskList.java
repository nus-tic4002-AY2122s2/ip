import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> tasks;
    protected int size;

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

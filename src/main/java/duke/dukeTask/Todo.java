package duke.dukeTask;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
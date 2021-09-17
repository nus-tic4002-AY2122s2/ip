package task;
/**
 * Represents a Task
 */
public abstract class Task {
    public String description;
    public boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    private String getStatusIcon() {
        return (isDone ? "✓" : "✘"); //return tick or X symbols
    }

    public String toString() {
        return "[" + getStatusIcon() + "]" + description;
    }
}
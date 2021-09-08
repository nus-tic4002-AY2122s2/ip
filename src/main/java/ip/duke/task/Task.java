package ip.duke.task;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected char id;

    protected Task(String description) {
        this.description = description;
    }

    public abstract String getDescription();

    public char getId(){
        return id;
    }
    // Tag task with an identity String
    public abstract void setId();
    // mark done task with "X"
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void setDone() {
        this.isDone = true;
    }

    // String representation of task object
    @Override
    public String toString() {
        return description;
    }

    // String format the task object for write to file
    public abstract String toFileString();
}

package ip.duke.task;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected String id;

    protected Task(String description) {
        this.description = description;
    }

    public abstract String getDescription();


    public String getId(){
        return id;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void setDone() {
        this.isDone = true;
    }

    protected abstract void setId();

    @Override
    public String toString() {
        return description;
    }   // description to print to console output
}

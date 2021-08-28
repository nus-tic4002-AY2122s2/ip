package task;

public abstract class Task {
    protected String description;
    public boolean isDone;
    protected char type;

    public Task (String description) {
        this.description = description;
        this.isDone = false;
    }

    public abstract String getFullStatus();

    public String getStatusIcon(){
        return (isDone ? "X" : " ");
    }

    public String getDescription(){
        return (description);
    }
}

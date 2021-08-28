package task; // Shifted all various types of task class to a package

public abstract class Task {
    protected String description;
    public boolean isDone;
    protected char type;

    public Task (String description) {
        this.description = description;
        this.isDone = false;
    }

    public abstract String getFullStatus(); // Abstract method

    public String getStatusIcon(){
        return (isDone ? "X" : " ");
    }

    public String getDescription(){
        return (description);
    }
}

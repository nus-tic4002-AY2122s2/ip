package main.java.duke.task;

public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2714" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone(){
        isDone = true;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return "["+getStatusIcon()+"] "+getDescription();
    }
}

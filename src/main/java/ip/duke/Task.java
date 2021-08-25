package ip.duke;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String id;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public String getId(){
        return id;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    protected void setDone() {
        this.isDone = true;
    }

    protected void setId(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return description;
    }   // description to print to console output
}

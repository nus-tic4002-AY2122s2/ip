package Task_Classes;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon(){
        return (isDone ? "X" : " ");
    }

    public String getDescription(){
        return this.description;
    }

    public void markAsDone(){
        this.isDone = true;
    }

    public String getType(){
        return this.type;
    }
}

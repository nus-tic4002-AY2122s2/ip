package duke.task;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected TaskType taskType;
    protected int taskIndex;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void editDone(Boolean isDone){
        this.isDone = isDone;
    }

    public boolean getIsDone(){
        return isDone;
    }

    public String getDescription(){
        return description;
    }

    public String getTask(){
        return description;
    }

    public String toString() {
        return " [" + this.getStatusIcon() + "] " + this.getTask();
    }

    public TaskType getTaskType(){
        return taskType;
    }

}

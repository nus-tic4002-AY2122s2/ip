package duke.task;

/**
 * The task class to store all the class
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected TaskType taskType;
    protected int taskIndex;

    /**
     * Constructs the task class to store the task the user requested
     * @param description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Return a Tick or X symbols
     * @return a Tick or X symbols
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void editDone(Boolean isDone){
        this.isDone = isDone;
    }

    public boolean getIsDone(){
        return isDone;
    }


    /**
     * Return the task that the user set
     * @return the task that was store
     */
    public String getTaskDescription(){
        return description;
    }

    /**
     * Convert the task description with the done status icon
     * @return the task description with the done status icon
     */
    public String toString() {
        return " [" + this.getStatusIcon() + "] " + this.getTaskDescription();
    }

    public TaskType getTaskType(){
        return taskType;
    }

}

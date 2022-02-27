package task;

public abstract class Task {
    protected String description;
    protected String tag;
    protected boolean isDone;
    protected char type;

    public Task(String description) {
        this.description = description.trim();
        this.isDone = false;
        this.tag = "#empty";
    }

    /**
     * Returns the description of the task
     *
     * @return The description of the task in string.
     */
    public String getTask() {
        return description;
    }

    /**
     * Sets a task done.
     */
    public void setTaskDone() {
        this.isDone = true;
    }

    /**
     * Returns the tag of the current task
     *
     * @return A string of the current task's tag.
     */
    public String getTag() {
        return this.tag;
    }

    /**
     * Get the task status, whether is the current task done or not.
     *
     * @return a Tick Symbol if it is done, Cross symbol other wise.
     */
    public String getTaskStatus() {
        return "[" + (isDone ? "\u2713" : "\u2718") + "]";
    }

    /**
     * Get the type of current Task, if it is a todo, event, deadline task.
     * todo = 'T'
     * event = 'E'
     * deadline = 'D'
     *
     * @return [T/E/D]
     */
    public String getType() {
        return "[" + this.type + "]";
    }

    public String getDetails() {
        return "";
    }

    /**
     * Returns the description of the current task
     *
     * @return A string of the current task's description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Tags the task
     *
     */
    public void tagTask(String message) {
        this.tag = message;
    }

}

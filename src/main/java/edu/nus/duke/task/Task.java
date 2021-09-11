package edu.nus.duke.task;

/**
 * Represent a task, for use as abstract class.
 */
public abstract class Task {
    // Variables
    protected final String SAVE_SEP = ";";
    protected char prefix = ' ';
    protected String taskName;
    protected boolean isDone = false;

    // Constructor
    public Task(String taskName) {
        this.taskName = taskName;
    }

    // Getter

    /**
     * Return a string with required info to represent a task.
     * @return string that represent a task.
     */
    public String getTask() {
        String taskStatus = isDone ? "X" : " ";
        return ("[" + prefix + "]" + "[" + taskStatus + "] " + taskName);
    }

    /**
     * Set a task to done.
     */
    public String printToSave() {
        String doneIdx = isDone ? "1" : "0";
        return (prefix + SAVE_SEP + doneIdx + SAVE_SEP + taskName);
    }

    // Setter
    public void setDone() {
        this.isDone = true;
    }
}

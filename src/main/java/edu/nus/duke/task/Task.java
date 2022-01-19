package edu.nus.duke.task;

import edu.nus.duke.storage.Storage;

/**
 * Represent a task, for use as abstract class.
 */
public abstract class Task {
    // Variables
    protected static final String SAVE_SEP = Storage.getSaveSep();
    protected char prefix;
    protected String taskName;
    protected boolean isDone = false;

    // Constructor

    /**
     * Constructor of Task class.
     *
     * @param prefix Character code of Task type.
     * @param taskName Name of task.
     */
    public Task(char prefix, String taskName) {
        this.prefix = prefix;
        this.taskName = taskName;
    }

    // Getter
    /**
     * Returns task name.
     *
     * @return task name.
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Return a string with required info to represent a task.
     *
     * @return string that represent a task.
     */
    public String getTask() {
        String taskStatus = isDone ? "X" : " ";
        return ("[" + prefix + "]" + "[" + taskStatus + "] " + taskName);
    }

    /**
     * Return a string with required info to be saved for a task.
     *
     * @return string with required info to be saved.
     */
    public String printForSave() {
        String doneIdx = isDone ? "1" : "0";
        return (prefix + SAVE_SEP + doneIdx + SAVE_SEP + taskName);
    }

    // Setter
    /**
     * Set a task to done.
     */
    public void setDone() {
        this.isDone = true;
    }
}

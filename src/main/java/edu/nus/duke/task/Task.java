package edu.nus.duke.task;

import edu.nus.duke.storage.Storage;

/**
 * Represent a task, for use as abstract class.
 */
public abstract class Task {
    protected static final String SAVE_SEP = Storage.getSaveSep();
    protected char prefix;
    protected String taskName;
    protected boolean isDone = false;

    protected Task(char prefix, String taskName) {
        this.prefix = prefix;
        this.taskName = taskName;
    }

    /**
     * Returns task prefix.
     *
     * @return Task prefix.
     */
    public char getPrefix() {
        return prefix;
    }

    /**
     * Returns task name.
     *
     * @return task name.
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Returns task isDone status.
     *
     * @return Boolean isDone.
     */
    public boolean getIsDone() {
        return isDone;
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

    /**
     * Set a task to done.
     */
    public void setDone() {
        this.isDone = true;
    }
}

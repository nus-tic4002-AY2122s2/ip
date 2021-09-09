package ip.duke.task;
/**
 * Task.java - a simple abstract class
 * as a template for various subclass task objects.
 * @author  Alvin Gwee
 * @version 1.0
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected char id;

    protected Task(String description) {
        this.description = description;
    }
    /**
     * abstract getter method
     * to get a task description.
     */
    public abstract String getDescription();

    // abstract setter method for tagging task with a letter id
    protected abstract void setId();
    /**
     * getter method for the protected field id.
     * @return A String value.
     */
    public char getId(){
        return id;
    }
    /**
     * getter method for the protected field isDone.
     * @return A String value.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }
    /**
     * setter method for the protected field isDone.
     */
    public void setDone() {
        this.isDone = true;
    }
    /**
     * Method gives the string representation
     * of a Task description.
     * @return A String value.
     */
    @Override
    public String toString() {
        return description;
    }

    // String format the task object for write to file
    public abstract String toFileString();
}

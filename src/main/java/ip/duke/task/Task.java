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
    protected String id;

    protected Task(String description) {
        this.description = description;
    }
    /**
     * abstract getter method
     * to get a task description.
     */
    public abstract String getDescription();
    /**
     * getter method for the protected field id.
     * @return A String value.
     */
    public String getId(){
        return id;
    }
    /**
     * getter method for the protected field isDone.
     * @return A String value.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }
    /**
     * setter method for the protected field isDone.
     */
    public void setDone() {
        this.isDone = true;
    }

    protected abstract void setId();
    /**
     * Method gives the string representation
     * of a Task description.
     * @return A String value.
     */
    @Override
    public String toString() {
        return description;
    }   // description to print to console output
}

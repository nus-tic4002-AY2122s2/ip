package edu.nus.duke.task;

/**
 * Represent an event with start that extends from Task.
 */
public class Event extends Task {
    // Variables
    protected String at;

    // Constructor
    public Event(String taskName, String at) {
        super(taskName);
        this.prefix = 'E';
        this.at = at;
    }

    public Event(String taskName, String at, boolean isDone) {
        this(taskName, at);
        this.isDone = isDone;
    }

    // Getter
    @Override
    public String getTask() {
        return (super.getTask() + " (at: " + at + ")");
    }

    @Override
    public String printForSave() {
        return (super.printForSave() + SAVE_SEP + at);
    }
}

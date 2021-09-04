package edu.nus.duke.task;

public class Event extends Task {
    // Variables
    protected String at;

    // Constructor
    public Event(String taskName, String at) {
        super(taskName);
        this.prefix = 'E';
        this.at = at;
    }

    // Getter
    @Override
    public String getTask() {
        return (super.getTask() + " (at: " + at + ")");
    }
}

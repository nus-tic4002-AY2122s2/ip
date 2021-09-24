package edu.nus.duke.task;

import java.time.LocalDateTime;

import edu.nus.duke.parser.Parser;

/**
 * Represent an event with start that extends from Task.
 */
public class Event extends Task {
    // Variables
    protected LocalDateTime at;

    // Constructor
    public Event(String taskName, LocalDateTime at) {
        super('E', taskName);
        this.at = at;
    }

    public Event(String taskName, LocalDateTime at, boolean isDone) {
        this(taskName, at);
        this.isDone = isDone;
    }

    // Getter
    @Override
    public String getTask() {
        return (super.getTask() + " (at: " + Parser.printDt(at) + ")");
    }

    public LocalDateTime getAt() {
        return at;
    }

    @Override
    public String printForSave() {
        return (super.printForSave() + SAVE_SEP + Parser.dtToString(at));
    }
}

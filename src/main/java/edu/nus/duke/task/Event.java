package edu.nus.duke.task;

import java.time.LocalDateTime;

import edu.nus.duke.parser.Parser;

/**
 * Represent an event with start that extends from Task.
 */
public class Event extends Task {
    protected LocalDateTime at;

    /**
     * Constructor of Event class.
     *
     * @param taskName Name of task.
     * @param at Event datetime.
     */
    public Event(String taskName, LocalDateTime at) {
        super('E', taskName);
        this.at = at;
    }

    /**
     * Constructor of Event class.
     *
     * @param taskName Name of task.
     * @param at Event datetime.
     * @param isDone Done status of task.
     */
    public Event(String taskName, LocalDateTime at, boolean isDone) {
        this(taskName, at);
        this.isDone = isDone;
    }

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

package edu.nus.duke.task;

import java.time.LocalDateTime;

import edu.nus.duke.parser.Parser;

/**
 * Represent a deadline with due that extends from Task.
 */
public class Deadline extends Task {
    // Variables
    protected LocalDateTime by;

    // Constructor
    public Deadline(String taskName, LocalDateTime by) {
        super('D', taskName);
        this.by = by;
    }

    public Deadline(String taskName, LocalDateTime by, boolean isDone) {
        this(taskName, by);
        this.isDone = isDone;
    }

    // Getter
    @Override
    public String getTask() {
        return (super.getTask() + " (by: " + Parser.dtToString(by) + ")");
    }

    @Override
    public String printForSave() {
        return (super.printForSave() + SAVE_SEP + Parser.dtToString(by));
    }
}

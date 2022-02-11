package edu.nus.duke.task;

import java.time.LocalDateTime;

import edu.nus.duke.parser.Parser;

/**
 * Represent a deadline with due that extends from Task.
 */
public class Deadline extends Task {
    protected LocalDateTime by;

    /**
     * Constructor of Deadline class.
     *
     * @param taskName Name of task.
     * @param by Due datetime.
     */
    public Deadline(String taskName, LocalDateTime by) {
        super('D', taskName);
        this.by = by;
    }

    /**
     * Constructor of Deadline class.
     *
     * @param taskName Name of task.
     * @param by Due date.
     * @param isDone Done status of task.
     */
    public Deadline(String taskName, LocalDateTime by, boolean isDone) {
        this(taskName, by);
        this.isDone = isDone;
    }

    @Override
    public String getTask() {
        return (super.getTask() + " (by: " + Parser.printDt(by) + ")");
    }

    public LocalDateTime getBy() {
        return by;
    }

    @Override
    public String printForSave() {
        return (super.printForSave() + SAVE_SEP + Parser.dtToString(by));
    }
}

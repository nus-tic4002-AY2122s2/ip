package edu.nus.duke.task;

/**
 * Represent a simple to-do that extends from Task.
 */
public class Todo extends Task {
    // Constructor
    public Todo(String taskName) {
        super('T', taskName);
    }

    /**
     * Constructor.
     *
     * @param taskName Name of task.
     * @param isDone Done status of task.
     */
    public Todo(String taskName, boolean isDone) {
        this(taskName);
        this.isDone = isDone;
    }
}

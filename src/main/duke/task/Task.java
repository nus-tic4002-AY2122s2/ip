package duke.task;

import duke.exception.DukeMissingDescException;

/**
 * Abstract Task class cannot be directly instantiated, only subclasses can.
 */
public abstract class Task {
    public static final char CHECKMARK = '\u2713';
    public static final char CROSSMARK = '\u274C';

    protected boolean isDone;
    protected String description;

    /**
     * @param description
     * @throws DukeMissingDescException
     */
    public Task(String description) throws DukeMissingDescException {
        setDescription(description);
        if (description.isEmpty() || description.isBlank()) {
            System.out.println(String.format("description: %s", description));
            throw new DukeMissingDescException(getClass().getSimpleName().toLowerCase());
        }
        setDone(false);
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return String.format("[%s] %s", (isDone) ? CHECKMARK : CROSSMARK, getDescription());
    }
}

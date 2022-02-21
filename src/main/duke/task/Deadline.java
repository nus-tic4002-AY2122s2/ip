package duke.task;

import java.time.LocalDateTime;

import duke.exception.DukeMissingDescException;

/**
 * Deadline can understand dates and times.
 * Refer to Level-8
 */
public class Deadline extends Task {
    private LocalDateTime deadline;
    private String rawDeadline;


    /**
     * Constructor
     * @param description
     * @param deadline
     * @throws DukeMissingDescException
     */
    public Deadline(String description, String deadline) throws DukeMissingDescException {
        super(description);
        setDeadline(deadline);
    }

    /**
     * @return DateTime representation of this Deadline object
     */
    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getRawDeadline() {
        return rawDeadline;
    }

    /**
     * Sets or updates this object's deadline.
     *
     * @param deadline
     */
    public void setDeadline(String deadline) {
        this.rawDeadline = deadline;
        this.deadline = Parser.parseDateTimeStr(deadline);
    }


    @Override
    public String toString() {
        String dateString = (getDeadline() != null) ? getDeadline().toString() : getRawDeadline();
        return String.format("[D]%s (by: %s)", super.toString(), dateString);
    }
}

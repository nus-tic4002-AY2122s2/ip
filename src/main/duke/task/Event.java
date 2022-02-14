package duke.task;

import java.time.LocalDateTime;

import duke.exception.DukeMissingDescException;

/**
 * Task with specific date of occurrence, can understand dates and times.
 * Refer to Level 8
 */
public class Event extends Task {
    private LocalDateTime startEndTime;
    private String rawStartEndTime;

    /**
     * @param description
     * @param startEndTime
     * @throws DukeMissingDescException
     */
    public Event(String description, String startEndTime) throws DukeMissingDescException {
        super(description);
        setStartEndTime(startEndTime);
    }

    public String getRawStartEndTime() {
        return rawStartEndTime;
    }

    /**
     * @return start_endTime if string was valid ISO DateTime, else null.
     */
    public LocalDateTime getStartEndTime() {
        return startEndTime;
    }

    /**
     * tries to set start_endTime if parsable.
     * @param startEndTime string passed in by user input
     */
    public void setStartEndTime(String startEndTime) {
        this.rawStartEndTime = startEndTime;
        this.startEndTime = Parser.parseDateTimeStr(startEndTime);
    }

    @Override
    public String toString() {
        String dateStr = (getStartEndTime() != null) ? getStartEndTime().toString() : getRawStartEndTime();
        return String.format("[E]%s (at: %s)", super.toString(), dateStr);
    }
}

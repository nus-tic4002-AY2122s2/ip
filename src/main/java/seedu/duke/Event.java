package seedu.duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected String eventDate;

    public Event(String description, boolean mark, String eventDate) {
        super();
        this.description = description;
        this.mark = mark;
        this.eventDate = eventDate;
    }

    public Event(String description, String eventDate) {
        super();
        this.description = description;
        this.mark = false;
        this.eventDate = eventDate;
    }

    public String getEventDate() {
        return " (at: " + eventDate + ")";
    }

    public void setEventDate(String deadline) {
        this.eventDate = eventDate;
    }

    public String getTaskDetails() {
        return "[E]" + getMarkSymbol() + " "
                + getDescription() + getEventDate();
    }

}

package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    private String at;
    private LocalDateTime till;

    public Event(String title, String at) {
        super(title);
        this.at = at;
    }

    public String getStartTime() {
        return at;
    }
    public LocalDateTime getEndTime() {
        return till;
    }




    @Override
    public String toString() {
        return "[E]" + super.toString()
                + " (at: " + at + ")";
    }
}

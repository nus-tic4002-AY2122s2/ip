package duke.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Deadline is a Task with duedate by property
 */
public class Deadline extends Task {
    private LocalDateTime by;

    public Deadline (String title, LocalDateTime by){
        super(title);
        this.by = by;
    }

    public LocalDateTime getDate() {
        return by;
    }

    @Override
    public String toString() {
        return  "[D]" + super.toString()
                + " (by: "
                + by.format(DateTimeFormatter.ofPattern("dd.MMM.yy HH:mm"))
                + ")";
    }
}

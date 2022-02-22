package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import duke.others.DateFormat;

/**
 * A type of task where task is tied to an occurrence date
 */
public class Event extends Task {
    protected LocalDate date;

    /**
     * A type of task that has the occurrence date
     * @param desc is name of task
     * @param date is occurrence of task
     */
    public Event(String desc, LocalDate date, String notes) {
        super(desc, "E", notes);
        this.date = date;
    }

    /** @return the date of the event. Format = "yyyy-mm-dd" */
    public LocalDate getDate() {
        return this.date;
    }

    /** @return the date of the event. Format = "dd mm yyyy" */
    public String getFormattedDate() {
        return this.date.format(DateTimeFormatter.ofPattern(DateFormat.EVENT_AND_DEADLINE));
    }

    /** @return the task type, task status (as an icon), task description and task date (in "dd mm yyyy" format). */
    public String getTypeStatusDesc() {
        return "[" + this.type + "][" + this.getStatusIcon() + "] " + this.desc + " (on: " + getFormattedDate() + ")";
    }

    /** @return the task type, task status (as an icon) and task description and notes. */
    public String getTypeStatusDescNotes() {
        String output = "[" + this.type + "][" + this.getStatusIcon() + "] " + this.desc
                + " (on: " + getFormattedDate() + ")";
        if (hasNotes()) {
            output = output.concat("\n\t: " + this.notes);
        }
        return output;
    }
}

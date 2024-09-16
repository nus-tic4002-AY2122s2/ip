package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import ui.Ui;


/**
 * This represents a Deadline Task. It has a LocalDateTime by object.
 * The "by" object will represent the time which the Deadline is supposed to finish.
 * The local date time format is in "YYYY
 */

public class Deadline extends Task {
    private LocalDateTime by;

    /**
     * This is a constructor for the Deadline class.
     *
     * @param description This describe the task for the deadline
     * @param by          This represents the date and time of the deadline
     */
    public Deadline(String description, String by, Ui ui) {
        super(description);
        try {
            this.by = LocalDateTime.parse(by, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        } catch (DateTimeParseException e) {
            this.by = LocalDateTime.now();
            ui.storeMessage("Invalid Date Time set for /by. It will be set to the current "
                    + "time. Format should be \"dd/MM/yyyy HH:mm:ss\" ");
        }

    }

    /**
     * This is an accessor of the "by" object which represents the date and time of the dateline.
     *
     * @return the dateline of the task
     */
    public String getBy() {
        return this.by.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss"));
    }


    public void rescheduleBy(String by, Ui ui) {
        try {
            this.by = LocalDateTime.parse(by, DateTimeFormatter.ofPattern("dd/M/yyyy HH:mm:ss"));
        } catch (DateTimeParseException e) {
            this.by = LocalDateTime.now();
            ui.storeMessage("Invalid Date Time set for /by. It will be set to the current "
                    + "time. Format should be \"dd/MM/yyyy HH:mm:ss\" ");
        }
    }

    /**
     * This converts the Deadline to a String object for printing.
     *
     * @return the deadline written as a String
     */
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.getBy() + ")";
    }
}

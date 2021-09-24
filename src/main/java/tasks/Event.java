package tasks;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * This represents the Event Class. It includes a String at.
 * at will represent the destination or "time" for the task. Anything that the user
 * wants to input for it.
 */

public class Event extends Task {
    protected LocalDateTime start;
    protected LocalTime end;

    /**
     * This is a constructor for the Event Class.
     *
     * @param description This describes the activity of the event.
     * @param at          This is indicates the time period for the event.
     */
    public Event(String description, String at) {
        super(description);
        int indexOfDash = 20;
        at = at.replaceFirst("/at", "").trim();
        try {
            //System.out.println(at.substring(0, indexOfDash));
            //System.out.println(at.substring(indexOfDash + 1).replace("-", "").trim());
            this.start = LocalDateTime.parse(at.substring(0, indexOfDash).trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            this.end = LocalTime.parse(at.substring(indexOfDash + 1).replace("-", "").trim(), DateTimeFormatter.ofPattern("HH:mm:ss"));
        } catch (DateTimeParseException | StringIndexOutOfBoundsException e) {
            this.start = LocalDateTime.now();
            this.end = LocalTime.now();
            System.out.println("Invalid Date Time set for /at. It will be set to the current " +
                    "time. Format should be \"dd/MM/yyyy HH:mm:ss - HH:mm:ss\" ");
        }
    }

    /**
     * This is a accessor for the object "at"
     *
     * @return the location of the event.
     */
    public String getAt() {
        return this.start.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")) + " - "
                + this.end.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    /**
     * This converts the Event Object to a String for printing.
     *
     * @return the Event written as a String
     */
    public String toString() {
        return "[E]" + super.toString() + " (at: " + getAt() + ")";
    }

    public void rescheduleAt(String at) {
        int index;
        try {
            index = at.indexOf(" - ");
            this.end = LocalTime.parse(at.substring(index).replace(" - ", "").trim(),
                    DateTimeFormatter.ofPattern("HH:mm:ss"));
            this.start = LocalDateTime.parse(at.substring(0, index).replaceFirst("/at", "").trim(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        } catch (DateTimeParseException | StringIndexOutOfBoundsException e) {
            this.start = LocalDateTime.now();
            this.end = LocalTime.now();
            System.out.println("Invalid Date Time set for /at. It will be set to the current " +
                    "time. Format should be \"dd/MM/yyyy HH:mm:ss - HH:mm:ss\" ");
        }
    }
}

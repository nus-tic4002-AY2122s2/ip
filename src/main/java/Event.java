import java.time.LocalDate;
import java.time.LocalTime;

public class Event extends Task {
    protected LocalDate taskDate;
    protected LocalTime taskTime;
    protected boolean hasTime = false;
    protected String stringDate;

    /**
     * Constructs the Event class without a time
     * @param description the description the user input
     * @param taskDate the date that the user input
     */
    public Event(String description, LocalDate taskDate) {
        super(description);
        this.taskDate = taskDate;
    }

    public Event(String description, String stringDate) {
        super(description);
        this.stringDate = stringDate;
    }



    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + stringDate + ")";
    }
}

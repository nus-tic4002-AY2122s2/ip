package duke.task;
/**
 * The child class of Task.
 * */
public class Event extends Task {
    protected String date;
    /**
     * Creation of new Deadline with description.
     * @param description of Event.
     * @param date for saving date.
     * */
    public Event (String description, String date) {
        super(description);
        this.date = date;
    }
    /**
     * Update the printing format by adding icon and date for event.
     * @return printing format.
     * */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + date + ")";
    }
    /**
     * Update the saving format by adding icon and date for event.
     * @return printing format.
     * */
    @Override
    public String save_toString() {
        return "E | " + super.save_toString() + "| " + date;
    }
}

package duke.task;
/**
 * The child class of Task.
 * */
public class Deadline extends Task {
    protected String date;
    /**
     * Creation of new Deadline with description.
     * @param description description of Deadline.
     * @param date date information for saving date.
     * */
    public Deadline(String description, String date) {
        super(description);
        this.date = date;
    }
    /**
     * Update the printing format by adding icon and date for deadline.
     * @return printing format.
     * */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + date + ")";
    }
}

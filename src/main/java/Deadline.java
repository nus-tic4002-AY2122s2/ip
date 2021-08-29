import java.time.LocalDate;
import java.time.LocalTime;

public class Deadline extends Task {
    protected LocalDate taskDate;
    protected LocalTime taskTime;
    protected boolean hasTime = false;
    protected String stringDate;

    public Deadline(String description, LocalDate taskDate) {
        super(description);
        this.taskDate = taskDate;
    }

    public Deadline(String description, String stringDate) {
        super(description);
        this.stringDate = stringDate;
    }




    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + stringDate + ")";
    }
}

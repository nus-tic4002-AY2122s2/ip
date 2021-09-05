package duke.task;



import java.time.LocalDate;
import java.time.LocalTime;

public class Deadline extends Task {
    protected LocalDate taskDate;
    protected LocalTime taskTime;
    protected boolean hasTime = false;
    protected String taskDateString;

    public Deadline(String description, LocalDate taskDate) {
        super(description);
        this.taskDate = taskDate;
    }

    public Deadline(String description, String stringDate) {
        super(description);
        this.taskDateString = stringDate;
    }




    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + taskDateString + ")";
    }
}

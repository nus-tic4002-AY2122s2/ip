package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private String by;

    public Deadline (String title, String by){
        super(title);
        this.by = by;
    }

    public String getDate() {
        return by;
    }

    @Override
    public String toString() {
        return taskNo + ". " + "[D]" + super.toString()
                + " (by: " + by + ")";
    }
}

package seedu.duke;

import java.time.LocalDateTime;

public class Deadline extends Task {
    protected String deadline;

    public Deadline(String description, boolean mark, String deadline) {
        super();
        this.description = description;
        this.mark = mark;
        this.deadline = deadline;
    }

    public Deadline(String description, String deadline) {
        super();
        this.description = description;
        this.mark = false;
        this.deadline = deadline;
    }

    public String getDeadline() {
        return "(by: " + deadline + ")";
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTaskDetails() {
        return "[D]" + getMarkSymbol() + " "
                + getDescription() + getDeadline();

    }
}

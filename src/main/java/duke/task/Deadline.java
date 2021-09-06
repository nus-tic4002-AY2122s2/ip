package duke.task;

public class Deadline extends Task {
    protected String date;

    public Deadline(String description, String date) {
        super(description);
        this.date = date;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + date + ")";
    }

    @Override
    public String save_toString() {
        return "D | " + super.save_toString() + "| " + date;
    }
}

package tasks;

public class Deadline extends Task {
    private String time;

    public Deadline(String description, String by) {
        super(description);
        this.time = by;
    }
    public String getTime() {
        return this.time;
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.getTime() + ")";
    }

}

package ip.duke;

public class Deadline extends Todo {
    private final String by;
    protected Deadline(String description, String by) {
        super(description);
        setId("D");
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return String.format("%s (by: %s)", super.toString(), by);
    }
}

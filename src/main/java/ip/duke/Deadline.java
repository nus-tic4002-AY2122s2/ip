package ip.duke;

public class Deadline extends Todo {
    private final String by;

    protected Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public void setId() {
        this.id = 'D';
    }

    @Override
    public String toString() {
        return String.format("%s (by: %s)", getDescription(), by);
    }

    @Override
    public String toFileString() {
        return super.toFileString().replaceFirst("T", "D") + " : " + by;
    }
}

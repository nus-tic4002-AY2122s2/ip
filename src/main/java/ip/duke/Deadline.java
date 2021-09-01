package ip.duke;

public class Deadline extends Todo {
    private final String by;

    protected Deadline(String description, String by) {
        super(description);
        setId();
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    protected void setId(){
        this.id = "D";
    }

    @Override
    public String toString() {
        return String.format("%s (by: %s)", super.toString(), by);
    }
}

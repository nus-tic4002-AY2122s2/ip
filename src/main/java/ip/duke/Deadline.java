package ip.duke;
/**
 * Deadline.java - a simple class for deadline objects.
 * A subclass of Todo
 * @author  Alvin Gwee
 * @version 1.0
 * @see Todo
 */
public class Deadline extends Todo {
    private final String by;

    protected Deadline(String description, String by) {
        super(description);
        this.by = by;
    }
    /**
     * getter method for the private final field by.
     * @return A String value.
     */
    public String getBy() {
        return by;
    }

    @Override
    public void setId() {
        this.id = 'D';
    }
    /**
     * Method gives the string representation
     * of the Deadline object.
     * @return A String value.
     */
    @Override
    public String toString() {
        return String.format("%s (by: %s)", getDescription(), by);
    }

    @Override
    public String toFileString() {
        return super.toFileString().replaceFirst("T", "D") + " : " + by;
    }
}

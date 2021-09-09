package ip.duke;

import ip.duke.task.Task;
/**
 * Todo.java - a simple class for todo objects.
 * A subclass of Task
 * @author  Alvin Gwee
 * @version 1.0
 * @see Task
 */
public class Todo extends Task {
    protected Todo(String description) {
        super(description);
        setId();
    }
    /**
     * Method gives the string representation
     * of the Todo object.
     * @return A String value.
     */
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    protected void setId() {
        this.id = "T";
    }
}

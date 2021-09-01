package ip.duke;

import ip.duke.task.Task;

public class Todo extends Task {
    protected Todo(String description) {
        super(description);
        setId();
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    protected void setId() {
        this.id = "T";
    }
}

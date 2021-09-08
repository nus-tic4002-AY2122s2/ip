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
    public void setId() {
        this.id = 'T';
    }

    @Override
    public String toFileString() {
        return "T" + " : " + (isDone ? "1" : "0") + " : " + getDescription();
    }
}

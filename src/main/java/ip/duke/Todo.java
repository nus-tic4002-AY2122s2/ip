package ip.duke;

public class Todo extends Task {
    protected Todo(String description) {
        super(description);
        setId();
    }

    @Override
    protected void setId() {
        this.id = "T";
    }
}

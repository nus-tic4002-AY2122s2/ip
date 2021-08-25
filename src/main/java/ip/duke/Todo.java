package ip.duke;

public class Todo extends Task {
    protected Todo(String description) {
        super(description);
        setId("T");
    }
}

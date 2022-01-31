package seedu.duke;

public class Todo extends Task {

    public Todo(String description, boolean mark) {
        super();
        this.description = description;
        this.mark = mark;
    }

    public Todo(String description) {
        super();
        this.description = description;
        this.mark = false;
    }

    public String getTaskDetails() {
        return "[T]" + getMarkSymbol() + " "
                + getDescription();

    }
}

package duke.task;

public class Todo extends Task{
    public Todo(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return taskNo + ". " + "[T]" + super.toString();
    }

}


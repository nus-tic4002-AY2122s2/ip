package duke.task;
/**
 * The child class of Task.
 * */
public class Todo extends Task {
    /**
     * Creation of new Todo with description.
     * @param description description of Todo.
     * */
    public Todo(String description){
        super(description);
    }
    /**
     * Update the printing format by adding icon for todo.
     * @return printing format.
     * */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

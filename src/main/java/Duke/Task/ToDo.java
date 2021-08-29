package Duke.Task;



public class ToDo extends Task {

    public ToDo(String thingsToDo) {
        super(thingsToDo);

    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

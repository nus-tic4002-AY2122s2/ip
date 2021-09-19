package duke.task;



public class ToDo extends Task {




    public ToDo(String thingsToDo) {
        super(thingsToDo);
        taskType = TaskType.TODO;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

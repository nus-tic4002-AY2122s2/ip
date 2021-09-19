package duke.task;


/**
 * The ToDo class for user to store their To Do task
 */
public class ToDo extends Task {

<<<<<<< HEAD



=======
    /**
     * Constructs and store the task that the user input
     * @param thingsToDo The task that the user input to do
     */
>>>>>>> branch-A-JavaDoc
    public ToDo(String thingsToDo) {
        super(thingsToDo);
        taskType = TaskType.TODO;
    }

    /**
     * When this function is called, it will return the task type with the task that the user input and whether it is done or not
     * @return the task in String
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

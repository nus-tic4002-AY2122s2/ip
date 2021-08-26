public class Task {
    // Variables
    protected String taskName;
    protected boolean isDone = false;

    // Constructor
    public Task(String taskName) {
        this.taskName = taskName;
    }

    // Getter
    public String getTask() {
        String taskStatus = isDone ? "X" : " ";
        return ("[" + taskStatus + "] " + taskName);
    }

    // Setter
    public void setDone() {
        this.isDone = true;
    }
}

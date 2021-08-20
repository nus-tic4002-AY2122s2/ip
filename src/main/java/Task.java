public class Task {
    // Variables
    private String taskName;
    private boolean isDone = false;

    // Constructor
    public Task(String taskName) {
        this.taskName = taskName;
    }

    // Getter
    public String getTask() {
        String taskStatus = isDone ? "X" : "";
        return ("[" + taskStatus + "] " + taskName);
    }

    // Setter
    public void setDone() {
        this.isDone = true;
    }
}

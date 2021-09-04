public abstract class Task {
    // Variables
    protected char prefix = ' ';
    protected String taskName;
    protected boolean isDone = false;

    // Constructor
    public Task(String taskName) {
        this.taskName = taskName;
    }

    // Getter
    public String getTask() {
        String taskStatus = isDone ? "X" : " ";
        return ("[" + prefix + "]" + "[" + taskStatus + "] " + taskName);
    }

    // Setter
    public void setDone() {
        this.isDone = true;
    }
}

package duke.task;

public class Task {
    protected String title;
    protected boolean isDone;
    protected int taskNo = 0;
    protected static int taskCount = 0;

    public Task(String title) {
        this.title = title;
        this.isDone = false;
        taskCount++;
        taskNo = taskCount;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String getTitle() {return title;}
    public boolean isDone() {return isDone;}
    public void markDone() {this.isDone = true;}
    public void markUnDone() {this.isDone = false;}
    public int getTaskNo() {return taskNo;}


    @Override
    public String toString() {
        String status = "[ ]";
        if (isDone()) {
            status = "[✓]";
        }
        return taskNo + ". " + status + " " + title;
    }
}

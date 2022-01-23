package duke.task;

/**
 * SuperClass , Abstract Class
 * Also, a Receiver Class in Command Pattern
 */

public abstract class Task {
    protected static int taskCount = 0;
    protected String title;
    protected boolean isDone;

    /**
     * constractor to initiate new instance of Task
     * @param title
     */
    public Task(String title) {
        this.title = title;
        this.isDone = false;
        taskCount++;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String getTitle() {
        return title;
    }
    public boolean isDone() {
        return isDone;
    }
    public void markDone() {
        this.isDone = true;
    }
    public void markUnDone() {
        this.isDone = false;
    }


    @Override
    public String toString() {
        String status = "[ ]";
        if (isDone()) {
            status = "[✓]";
        }
        return status + " " + title;
    }
}

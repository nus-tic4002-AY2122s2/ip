package tasks;

public class Task {
    private String description;
    private boolean isDone;
    protected static int cumulatedTasksAdded = 0;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        cumulatedTasksAdded++;
    }

    public void changeDoneTo(boolean isDone) {
        this.isDone = isDone;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        String symbol;

        if (this.isDone) {
            symbol = "+";
        } else {
            symbol = "-";
        }

        return ("[" + symbol + "] " + getDescription());
    }

}

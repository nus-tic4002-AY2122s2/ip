package task;

public class Todo extends Task{
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" +  "[" + this.getStatusIcon() + "] " + this.description;
    }

    @Override
    public String toDataFormat() {
        String status = this.isDone ? "1" : "0";
        return "T"+ "|" + status + "|" + this.description;
    }
}

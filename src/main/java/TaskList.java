import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> tasks;
    protected int size;

    public TaskList(ArrayList<Task> tasks){
        this.tasks = tasks;
        this.size = tasks.size();
    }

    public void doneCommand (String fullCommand) {
        tasks.get(Parser.taskNumber(fullCommand)).markAsDone();
        UI.doneMessage(tasks, Parser.taskNumber(fullCommand));
    }

    public void addTodoCommand (String fullCommand) {
        String description = Parser.description(fullCommand);
        Task t = new Todo(description);
        tasks.add(t);
        size++;
        UI.addMessage(t, size);
    }

    public void addDeadlineCommand (String fullCommand) {
        String description = Parser.description(fullCommand);
        String date = Parser.date(fullCommand);
        Task t = new Deadline(description, date);
        tasks.add(t);
        size++;
        UI.addMessage(t, size);
    }

    public void addEventCommand (String fullCommand) {
        String description = Parser.description(fullCommand);
        String date = Parser.date(fullCommand);
        Task t = new Event(description, date);
        tasks.add(t);
        size++;
        UI.addMessage(t, size);
    }
}

import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> taskList){
        this.taskList = taskList;
    }

    public void doneCommand (String fullCommand) {
        taskList.get(Parser.taskNumber(fullCommand)).markAsDone();
        UI.doneMessage(taskList, Parser.taskNumber(fullCommand));
    }

    public void addTodoCommand (String fullCommand) {
        String description = Parser.description(fullCommand);
        Task t = new Todo(description);
        taskList.add(t);
        UI.addMessage(t, taskList.size());
    }

    public void addDeadlineCommand (String fullCommand) {
        String description = Parser.description(fullCommand);
        String date = Parser.date(fullCommand);
        Task t = new Deadline(description, date);
        taskList.add(t);
        UI.addMessage(t, taskList.size());
    }

    public void addEventCommand (String fullCommand) {
        String description = Parser.description(fullCommand);
        String date = Parser.date(fullCommand);
        Task t = new Event(description, date);
        taskList.add(t);
        UI.addMessage(t, taskList.size());
    }
}

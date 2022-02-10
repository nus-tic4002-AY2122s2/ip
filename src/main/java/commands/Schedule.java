package commands;

import dukedatetime.DateTimeDuke;
import exceptions.DukeDateTimeError;
import exceptions.DukeTaskInputException;
import storage.Storage;
import taskclasses.Task;
import taskclasses.TaskList;
import ui.Ui;

import java.util.Vector;

public class Schedule extends Command {

    private DateTimeDuke date;

    public Schedule (String date) throws DukeDateTimeError {
        date += " 11:11";
        this.date = new DateTimeDuke(date);
    }

    private Vector<Task> getMatchedTasks(Vector<Task> list, String scheduleDate) {
        Vector<Task> matchedTasks = new Vector<>();

        for(Task tsk : list) {
           String tskType = tsk.getType();
           String tskDate = "";

           switch (tskType) {
           case "D":
               tskDate = tsk.getDeadlineTime().convertToStringTypeIII();
               break;
           case "E":
               tskDate = tsk.getStartingTime().convertToStringTypeIII();
               break;
           default:
               break;
           }

           if(tskDate.equals(scheduleDate)) {

               matchedTasks.add(tsk);
           }
        }

        return matchedTasks;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeDateTimeError, DukeTaskInputException {
        Vector<Task> list = taskList.getVectorList();
        Vector<Task> matchedTaskList = getMatchedTasks(list, this.date.convertToStringTypeIII());

        String echoInfo = "";

        echoInfo = TaskList.toPrintEntireTaskList(matchedTaskList); // print all the matched task

        return echoInfo;
    }

    @Override
    public boolean isExit() {

        return false;
    }
}

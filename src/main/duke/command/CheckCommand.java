package duke.command;

import java.time.LocalDateTime;

import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Parser;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;


/**
 * Check Command represents a user wanting to check the task list
 */
public class CheckCommand extends Command {
    private String rawTime;
    private LocalDateTime checkTime;


    /**
     * @param timeStr
     */
    public CheckCommand(String timeStr) {
        rawTime = timeStr;
        checkTime = Parser.parseDateTimeStr(timeStr);
    }

    public String getCheckTime() {
        if (checkTime != null) {
            return checkTime.toString();
        } else {
            return rawTime;
        }
    }

    /**
     * Checks TaskList for tasks that have a date, and print them if they are on the same date.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printEventsOnDateMsg(getCheckTime());
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task curr = tasks.get(i);
            if (curr.getClass() == Event.class) {
                Event e = (Event) curr;
                LocalDateTime dateTime = e.getStartEndTime();
                if (dateTime != null) {
                    if (dateTime.toLocalDate().isEqual(checkTime.toLocalDate())) {
                        ui.printTask(e);
                        count++;
                    }
                } else {
                    String dateTimeStr = e.getRawStartEndTime();
                    if (dateTimeStr.equals(rawTime)) {
                        ui.printTask(e);
                        count++;
                    }
                }

            }
            if (curr.getClass() == Deadline.class) {
                Deadline d = (Deadline) curr;
                //here we need to see if both can be converted to LocalDate.
                //Otherwise, just compare the strings.
                LocalDateTime deadline = d.getDeadline();
                if (deadline != null) {
                    if (deadline.toLocalDate().isEqual(checkTime.toLocalDate())) {
                        ui.printTask(d);
                        count++;
                    }
                } else {
                    String deadlineStr = d.getRawDeadline();
                    if (deadlineStr.equals(rawTime)) {
                        ui.printTask(d);
                        count++;
                    }
                }
            }
        }
        if (count == 0) {
            ui.printNoEventOnDateMsg();
        }
    }

}

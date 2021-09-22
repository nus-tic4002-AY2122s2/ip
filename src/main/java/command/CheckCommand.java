package command;

import storage.Storage;
import task.*;
import ui.Ui;

import java.time.LocalDateTime;


public class CheckCommand extends Command {
    private String raw_time;
    private LocalDateTime check_time;
    public String getCheck_time(){
        if(check_time != null){
            return check_time.toString();
        }
        else return raw_time;
    }
    /**
     * Checks TaskList for tasks that have a date, and print them if they are on the same date.
     * TODO: Extend this such that it can return a plain string for un-parsable strings.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if(check_time != null) {
            //if
        }
        else{

        }
        ui.printEventsOnDateMsg(check_time);
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task curr = tasks.get(i);
            if (curr.getClass() == Event.class) {
                Event e = (Event) curr;
                if(e.getStart_endTime().toLocalDate().isEqual(check_time.toLocalDate())){
                    ui.printTask(e);
                    count++;
                }
            }
            if (curr.getClass() == Deadline.class) {
                Deadline d = (Deadline) curr;
                if(d.getDeadline().toLocalDate().isEqual(check_time.toLocalDate())){
                    ui.printTask(d);
                    count++;
                }
            }
        }
        if(count == 0){
            ui.printNoEventOnDateMsg();
        }
    }

    public CheckCommand(String time_str) {
        raw_time = time_str;
        check_time = Parser.parseDateTimeStr(time_str);
    }
}

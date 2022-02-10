package commands;

import dukedatetime.DateTimeDuke;
import exceptions.DukeDateTimeError;
import exceptions.DukeTaskInputException;
import storage.Storage;
import taskclasses.TaskList;
import ui.Ui;

public class Schedule extends Command {

    private DateTimeDuke date;

    public Schedule (String date) throws DukeDateTimeError {

        this.date = new DateTimeDuke(date);
    }

    public String getScheduleDate() {

        String dt;

        dt = this.date.convertToStringTypeIII(); //"yyyy-MM-dd"

        return dt;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeDateTimeError, DukeTaskInputException {
        

        return null;
    }

    @Override
    public boolean isExit() {

        return false;
    }
}

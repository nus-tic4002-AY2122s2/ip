package command;

import exception.ErrorHandler;
import storage.Storage;
import taskList.TaskList;
import ui.Ui;

public class ByeCommand extends Command{
    @Override
    public void execute(Storage storage, Ui ui, TaskList taskList) throws ErrorHandler {
        try{
            String [] data = taskList.getFileDataFormatList();
            storage.saveData(data);
            ui.bye();
        } catch (ErrorHandler e) {
            throw new ErrorHandler("while exiting program: " + e.getMessage());
        }
    }

}

package command;

import exception.ErrorHandler;
import storage.Storage;
import taskList.TaskList;
import ui.Ui;

public class DataCommand extends Command{

    public DataCommand() {

    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList taskList) throws ErrorHandler {

        try{
            String [] data = storage.loadData();


        } catch (ErrorHandler e) {
            throw new ErrorHandler("while exiting program: " + e.getMessage());
        }
    }
}

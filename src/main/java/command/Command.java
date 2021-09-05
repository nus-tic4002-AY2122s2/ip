package command;

import Ui.Ui;
import UserList.UserList;
import exception.ErrorHandler;
import parser.Parser;

public class Command {
    private boolean isExit = false;

    public  Command(UserList list, String userInput) throws ErrorHandler {
        this.process(list, userInput);
    }

    private void process (UserList list, String userInput) throws ErrorHandler {
        Parser parser = new Parser(userInput);

        switch (parser.getCommandWord()) {
            case "bye":
                Ui.bye();
                this.isExit = true;
                break;
            case "list":
                Ui.printList(list.getSerializedList());
                break;
            case "done":
                int index =Integer.parseInt(parser.getContent());
                if(index > 0 && index <= list.getList().size()) {
                    list.getList().get(index - 1).setStatus(true);
                    Ui.printMarkedDone(list.getSerializedList().get(index - 1));
                } else {
                    throw new ErrorHandler("Task number keyed in is wrong.");
                }
                break;
            default:
                list.addItem(userInput);
                Ui.print(userInput);
                break;
        }
    }

    public boolean getIsExit() {return this.isExit;}
}

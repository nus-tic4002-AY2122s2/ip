package command;

import Ui.Ui;
import UserList.UserList;
import exception.ErrorHandler;
import parser.Parser;
import task.Deadline;
import task.Event;
import task.Todo;


public class Command {
    private boolean isExit = false;

    public  Command(UserList list, String userInput) throws ErrorHandler {
        this.process(list, userInput);
    }

    private void process (UserList list, String userInput) throws ErrorHandler {
        try {
            Parser parser = new Parser(userInput);
            switch (parser.getCommandWord()) {
                case BYE:
                    Ui.bye();
                    this.isExit = true;
                    break;
                case LIST:
                    Ui.printList(list.getSerializedList());
                    break;
                case DONE:
                    int index =Integer.parseInt(parser.getContent());
                    if(index > 0 && index <= list.getList().size()) {
                        list.getList().get(index - 1).setStatus(true);
                        Ui.printMarkedDone(list.getSerializedList().get(index - 1));
                    } else {
                        throw new ErrorHandler("In Command, task number is out of range.");
                    }
                    break;
                case TODO:
                    Todo addedTodo = new Todo(parser.getContent());
                    list.addItem(addedTodo);
                    Ui.printTask(addedTodo.toString(), list.getList().size());
                    break;
                case EVENT:
                    Event addedEvent = new Event(parser.getContent(), parser.getAt());
                    list.addItem(addedEvent);
                    Ui.printTask(addedEvent.toString(), list.getList().size());
                    break;
                case DEADLINE:
                    Deadline addDeadline = new Deadline(parser.getContent(), parser.getBy());
                    list.addItem(addDeadline);
                    Ui.printTask(addDeadline.toString(), list.getList().size());
                    break;
                default:
                    break;
            }
        } catch (ErrorHandler e) {
            throw new ErrorHandler(e.getMessage());
        }

    }

    public boolean getIsExit() {return this.isExit;}
}

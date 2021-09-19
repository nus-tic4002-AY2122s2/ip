package command;

import constant.ErrorMessage;
import parser.CommandParser;
import ui.Ui;
import userList.UserList;
import exception.ErrorHandler;
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
            CommandParser parser = new CommandParser(userInput);
            System.out.println(parser.getCommandWord());
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
                        throw new ErrorHandler("In Command, " + ErrorMessage.INVALID_TASK_NUMBER);
                    }
                    break;
                case TODO:
                    Todo addedTodo = new Todo(parser.getContent(), false);
                    list.addItem(addedTodo);
                    Ui.printTask(addedTodo.toString(), list.getList().size());
                    break;
                case EVENT:
                    Event addedEvent = new Event(parser.getContent(), parser.getAt(), false);
                    list.addItem(addedEvent);
                    Ui.printTask(addedEvent.toString(), list.getList().size());
                    break;
                case DEADLINE:
                    Deadline addDeadline = new Deadline(parser.getContent(), parser.getBy(), false);
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

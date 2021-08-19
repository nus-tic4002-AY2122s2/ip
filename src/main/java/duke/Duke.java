package duke;

import duke.storage.tempTaskList;
import duke.ui.Message;

import java.util.Scanner;

public class Duke {
    private tempTaskList list = new tempTaskList();
    private Message messager = new Message();

    public Duke() {
        list.addPropertyChangeListener(messager);
    }

    public static void main(String[] args)  {
        Message.greeting();
        new Duke().start();
        Message.exit();
    }

    private void start() {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();

        if(userInput.equals("bye")) return;
        if(userInput.equals("list")) {
            list.print();
        } else {list.add(userInput);}

        
        start();
    }
}



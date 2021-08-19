package duke;

import duke.storage.TempList;
import duke.task.Task;
import duke.ui.Message;

import java.util.Scanner;

public class Duke {
    private TempList<Task> list = new TempList<>();

    public Duke() {
        Message messager = new Message();
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
        if(userInput.equals("list")) { print();
        } else if(userInput.contains("done")) {
            var index = userInput.split(" ")[1];
            markDone(Integer.parseInt(index)-1);
        } else { list.add(new Task(userInput));}


        start();
    }

    public void markDone(int index) {
        var task = list.get(index);
        task.markDone();
        Message.echo("Marked below as Done:");
        Message.echo(task.toString());
    }

    public void print() {
        for (Task task : list) {
           Message.echo(task.toString());
        }
    }
}



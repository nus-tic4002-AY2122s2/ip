import ui.Message;

import java.util.Scanner;

public class Duke {

    public Duke() {

    };

    public static void main(String[] args)  {
        Message.greeting();
        new Duke().start();
        Message.exit();
    }

    private void start() {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();

        if(userInput.equals("bye")) return;


        Message.echo(userInput);


        start();
    }
}



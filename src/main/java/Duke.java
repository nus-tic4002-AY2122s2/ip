import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        new Duke().run();


    }

    public void run() {
        System.out.println("Hello! I'm Duke \n  " +
                "What can I do for you?");
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");

        boolean isExit = false;
        while (!isExit) {

            String line;
            Scanner in = new Scanner(System.in);
            System.out.println("Type something: ");
            line = in.nextLine();
            System.out.println("____________________________________________________________");
            if(line.toLowerCase().equalsIgnoreCase("bye")){
                isExit = true;
                System.out.println("See you!");
                System.out.println("____________________________________________________________");
                break;
            }
            System.out.println(line);
            System.out.println("____________________________________________________________");

        }
    }
}

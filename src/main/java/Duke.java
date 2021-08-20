import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("-------------------------------");
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");


        System.out.println("-------------------------------");

        String echo = " ";

        Scanner input = new Scanner(System.in);
        while (!echo.equals("bye")) {
            echo = input.nextLine();
            if(!echo.equals("bye")){
                System.out.println("-------------------------------");
                System.out.println("    " + echo);
                System.out.println("-------------------------------");
            }

        }

        System.out.println("-------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-------------------------------");
    }
}

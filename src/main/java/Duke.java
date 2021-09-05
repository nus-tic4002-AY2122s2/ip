import java.util.ArrayList;
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
        ArrayList<Tasks> addedList = new ArrayList<Tasks>();

        Scanner input = new Scanner(System.in);
        Task tc= new Task("");

        while (!echo.equals("bye")) {
            echo = input.nextLine();

            if(!echo.trim().equals("bye") && !echo.trim().equals("list") && !echo.contains("done")){
                Tasks tasks = new Tasks(false, echo);
                addedList.add(tasks);
                System.out.println("-------------------------------");
                System.out.println("    " + echo);
                System.out.println("-------------------------------");
            }
            if(echo.equals("list")){
                int index = 0;
                tc.getList(addedList);

            }
            if(echo.contains("done")){
                String doneIndex = echo.substring(5);
                tc.addDone(Integer.parseInt(doneIndex));
                System.out.println("-------------------------------");
                System.out.println("    "+ "Nice! I've marked this task as done: ");
                System.out.println("    "+ tc.markAsDone(Integer.parseInt(doneIndex)));
                System.out.println("-------------------------------");
            }
        }

        System.out.println("-------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-------------------------------");
    }


}

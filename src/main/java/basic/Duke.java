
package basic;


import exception.DukeException;
import task.Task;

import java.util.ArrayList;
import java.util.Scanner;



public class Duke {


    private void run() throws DukeException{
        String logo = " ____        _        \n"
        + "|  _ \\ _   _| | _____ \n"
        + "| | | | | | | |/ / _ \\\n"
        + "| |_| | |_| |   <  __/\n"
        + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("___________________________________________");
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        System.out.println("___________________________________________\n");

        int i=0;
        ArrayList<String> array = new ArrayList<String>();
        TaskList tasks = new TaskList(array);

        while (true) {
            Scanner input = new Scanner(System.in);
            String myString = "";
            myString+= input.nextLine();
            if (myString.equals("bye") || myString.equals("Bye") || myString.equals("BYE")) {
                System.out.println("   Bye. Hope to see you again soon!");
                break;
            }
            else if (myString.equals("List") || myString.equals("list") || myString.equals("LIST")) {
                for (int j=1;j<=i; j++) {
                    System.out.println("   " + j + ". " + tasks.returnTask(j - 1));
                    if (j==i)
                        System.out.println("\n");
                }
            }
            else if (myString.contains("done") || myString.contains("Done") || myString.contains("DONE")) {

                String editedInput = myString.toLowerCase().replace("done ", "");
                assert editedInput.replaceAll("[\\D]", "").equals(editedInput) : "wrong format key in numeric number instead";

                int num = 0;
                //replacing all the non digit elements
                num = Integer.parseInt(myString.replaceAll("[\\D]", ""));
                
                
                if (num > 0 && num <= tasks.sizeOfTask()) {
                    tasks.returnTask(num - 1).isDone = true;
                    System.out.print("   " + "Nice! I've marked this task as done: \n" + "   " + tasks.returnTask(num - 1) + "\n\n");

                } else {
                    throw new DukeException("☹ Item not found.");

                }

                tasks.returnTask(num - 1).isDone = true;
            }
            else {
                Task task = new Task(myString);
                tasks.addTask(task);
                i++;
                System.out.println("   added: " + myString + "\n");
            }
        }
    }

    public static void main(String[] args)  throws DukeException {
        new Duke().run();
    }
}

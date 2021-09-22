import TaskPackage.Task;
import TaskPackage.Tasks;
import Task.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _\n"
                + "|  _ \\ _   _| | _____\n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        System.out.println("-------------------------------");
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");
        System.out.println("-------------------------------");

        String echo = " ";
        ArrayList<Task> addedList = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        Tasks tc= new Tasks("");

        while (!echo.equals("bye")) {
            echo = input.nextLine();

//            if(!echo.trim().equals("bye") && !echo.trim().equals("list") && !echo.contains("done")){
//                TaskPackage.Tasks tasks = new TaskPackage.Tasks(false, echo);
//                addedList.add(tasks);
//                System.out.println("-------------------------------");
//                System.out.println("    " + echo);
//                System.out.println("-------------------------------");
//            }
            if(echo.equals("list")){
                int index = 0;
                tc.getList(addedList);

            }
            if(echo.contains("done")){
                String doneIndex = echo.substring(5);
                tc.addDone(Integer.parseInt(doneIndex));
                System.out.println("-------------------------------");
                System.out.println("    "+ "Nice! I've marked this task as done:");
                System.out.println("    "+ tc.markAsDone(Integer.parseInt(doneIndex)));
                System.out.println("-------------------------------");
            }

            if(echo.contains("todo")){
                String todoIndex = echo.substring(5);
//                TaskPackage.Tasks tasks = new TaskPackage.Tasks(false, echo.substring(5));
//                addedList.add(tasks);

                Todo todo = new Todo(echo.substring(5));
                Task task = new Task(false, todo.toString());

                addedList.add(task);

                System.out.println("-------------------------------");
                System.out.println("    " + "Got it. I've added this task:");
                System.out.println("    " + echo.substring(5) );
                System.out.println("-------------------------------");
                System.out.println("    " + "Now you have " + tc.getNumOfList() + " tasks in the list.");

            }

            if(echo.contains("event")){

                int task_stringIndex_After_taskWord = 0;
                String task_words ="", by_words = " ";

                task_stringIndex_After_taskWord = echo.indexOf(" ");
                int by_string = echo.indexOf("/");
                by_words = echo.substring(by_string + 3);

                if (echo.contains("/")) {
                    by_string = echo.indexOf("/");
                    task_words = echo.substring(task_stringIndex_After_taskWord, by_string);
                }
                else if(echo.contains("bye")){
                }
                else{
                    task_words = echo.substring(task_stringIndex_After_taskWord);
                }


                Event event = new Event(task_words, by_words );
                Task task = new Task(false, event.toString());

                addedList.add(task);

                System.out.println("-------------------------------");
                System.out.println("    " + "Got it. I've added this task:");
                System.out.println("    " + echo.substring(6) );
                System.out.println("-------------------------------");
                System.out.println("    " + "Now you have " + tc.getNumOfList() + " tasks in the list.");

            }

            if(echo.contains("deadline")){

                int task_stringIndex_After_taskWord = 0;
                String task_words ="", by_words = " ";

                task_stringIndex_After_taskWord = echo.indexOf(" ");
                int by_string = echo.indexOf("/");
                by_words = echo.substring(by_string + 3);

                if (echo.contains("/")) {
                    by_string = echo.indexOf("/");
                    task_words = echo.substring(task_stringIndex_After_taskWord, by_string);
                }
                else if(echo.contains("bye")){
                }
                else{
                    task_words = echo.substring(task_stringIndex_After_taskWord);
                }


                Deadline deadline = new Deadline(task_words, by_words );
                Task task = new Task(false, deadline.toString());

                addedList.add(task);

                System.out.println("-------------------------------");
                System.out.println("    " + "Got it. I've added this task:");
                System.out.println("    " + echo.substring(9) );
                System.out.println("-------------------------------");
                System.out.println("    " + "Now you have " + tc.getNumOfList() + " tasks in the list.");
            }

        }

        System.out.println("-------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-------------------------------");
    }

}

import Duke.Command.Deadline;
import Duke.Command.Event;
import Duke.Command.Todo;
import Duke.Task.Task;
import Duke.Task.Tasks;

import java.util.ArrayList;
import java.util.Scanner;


public class Duke  {
    public static void main(String[] args){
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
        Tasks tasks= new Tasks("");

        while (!echo.equals("bye")) {

            echo = input.nextLine();
            String[] command = new String[100];
            command = echo.split(" ");


            switch (command[0]){
                case("list"):
                    int index = 0;
                    tasks.getList(addedList);
                    break;

                case("done"):
                    try{
                        if(command[1]!=""){
                            String doneIndex = echo.substring(5);
                            tasks.addDone(Integer.parseInt(doneIndex));
                            System.out.println("-------------------------------");
                            System.out.println("    "+ "Nice! I've marked this task as done:");
                            System.out.println("    "+ tasks.markAsDone(Integer.parseInt(doneIndex)));
                            System.out.println("-------------------------------");
                        }
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("☹ OOPS!!! The number of a done cannot be empty.");
                    }
                    break;

                case("todo"):
                    try{
                        if(command[1]!=""){
                            String todoIndex = echo.substring(5);

                            Todo todo = new Todo(echo.substring(5));
                            Task task = new Task(false, todo.toString());

                            addedList.add(task);

                            System.out.println("-------------------------------");
                            System.out.println("    " + "Got it. I've added this task:");
                            System.out.println("    " + echo.substring(5) );
                            System.out.println("-------------------------------");
                            System.out.println("    " + "Now you have " + tasks.getNumOfList() + " tasks in the list.");

                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                    break;

                case("event"):
                    try {
                        if (command[1] != "") {
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
                            System.out.println("    " + "Now you have " + tasks.getNumOfList() + " tasks in the list.");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("☹ OOPS!!! The event description cannot be empty.");
                    }
                    break;

                case("deadline"):
                    try {
                        if (command[1] != "") {
                            //                    int task_stringIndex_After_taskWord = 0;
                            String task_words ="";
                            String by_words = " ";

                            int task_stringIndex_After_taskWord = echo.indexOf(" ");
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
                            System.out.println("    " + "Now you have " + tasks.getNumOfList() + " tasks in the list.");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("☹ OOPS!!! The deadline description cannot be empty.");
                    }
                    break;

                default:
            }
        }

        System.out.println("-------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-------------------------------");
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static ArrayList<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke\nWhat can I do for you?");

        while (echo());
    }

    public static boolean echo() {

        String userInput;
        Scanner scan = new Scanner(System.in);
        userInput = scan.nextLine();

        String[] splitStr = userInput.split("\\s+");

        switch (splitStr[0]) {
            case "bye":
                System.out.println("Bye. Hope to see you again soon!");
                return false;

            case "list":
                printList();
                return true;

            case "done":
                try {
                    int index = Integer.valueOf(splitStr[1]) - 1;
                    if (!userInput.equals("")) {
                        System.out.println("Nice! I've marked this task as done: \n" +
                                "       [X] " + taskList.get(index).getDescription());
                        //mark.set(index, true);
                        taskList.get(index).setMark(true);
                        return true;
                    } else {
                        System.out.println("☹ OOPS!!! There isn't a task <empty>.");
                        return false;
                    }
                }
                catch(Exception e){
                    System.out.println("☹ OOPS!!! Please try again. Bye!");
                    return false;
                }

            case "todo":
                try {
                    userInput = userInput.replace("todo ","");
                    if(!userInput.equals("") && !userInput.equals("todo")){
                        Task newTask = new Task(userInput, false, 'T', "");
                        taskList.add(newTask);
                        //newTask.setDescription(userInput);
                        System.out.println("Got it. I've added this task: \n" +
                                "      [T][ ] " + userInput + "\n" +
                                "Now you have " + taskList.size() + " tasks in the list.");
                        return true;
                    }
                    else {
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                        return false;
                    }
                }
                catch(Exception e){
                    System.out.println("☹ OOPS!!! Please try again. Bye!");
                    return false;
                }

            case "deadline":
                try {
                    userInput = userInput.replace("deadline ","");
                    //System.out.println(userInput);
                    if(!userInput.equals("") && !userInput.equals("deadline")){
                        String[] deadline = userInput.split("/");
                        Task newTask1 = new Task(deadline[0], false, 'D', deadline[1]);
                        taskList.add(newTask1);
                        System.out.println("Got it. I've added this task: \n" +
                                "      [D][ ] " + deadline[0] + "(" + deadline[1] + ")\n" +
                                "Now you have " + taskList.size() + " tasks in the list.");
                        return true;
                    }
                    else {
                        System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                        return false;
                    }
                }
                catch(Exception e){
                    System.out.println("☹ OOPS!!! Please try again. Bye!");
                    return false;
                }

            case "event":
                try {
                    userInput = userInput.replace("event ","");
                    if(!userInput.equals("") && !userInput.equals("event")){
                        String[] event = userInput.split("/");
                        Task newTask2 = new Task(event[0], false, 'E', event[1]);
                        taskList.add(newTask2);
                        System.out.println("Got it. I've added this task: \n" +
                                "      [E][ ] " + event[0] + "(" + event[1] + ")\n" +
                                "Now you have " + taskList.size() + " tasks in the list.");
                        return true;
                    }
                    else {
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                        return false;
                    }
                }
                catch(Exception e){
                    System.out.println("☹ OOPS!!! Please try again. Bye!");
                    return false;
                }

            default:
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                return false;
        }
    }

    public static void printList(){
        String markToString;
        for(int i = 0; i < taskList.size(); i++){
            if(i==0){
                System.out.println("Here are the tasks in your list:");
            }
            if(taskList.get(i).getMark()){
                markToString = "X";
            }
            else {
                markToString = "";
            }
            System.out.println(i+1 + ". [" + taskList.get(i).getToDo() + "][" + markToString + "] " + taskList.get(i).getDescription() + taskList.get(i).getAdditionalDetails());
        }
    }
}
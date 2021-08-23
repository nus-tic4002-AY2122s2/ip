import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    //public static ArrayList<String> list = new ArrayList<>();
    //public static ArrayList<Boolean> mark = new ArrayList<>();
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
                int index = Integer.valueOf(splitStr[1]) - 1;
                System.out.println("Nice! I've marked this task as done: \n" +
                        "       [X] " + taskList.get(index).getDescription());
                //mark.set(index, true);
                taskList.get(index).setMark(true);
                return true;
            case "todo":
                userInput = userInput.replace("todo ","");
                Task newTask = new Task(userInput, false, 'T', "");
                taskList.add(newTask);
                //newTask.setDescription(userInput);
                System.out.println("Got it. I've added this task: \n" +
                     "      [T][ ] " + userInput + "\n" +
                             "Now you have " + taskList.size() + " tasks in the list.");
                return true;
            case "deadline":
                userInput = userInput.replace("deadline ","");
                System.out.println(userInput);
                String[] deadline = userInput.split("/");
                Task newTask1 = new Task(deadline[0], false, 'D', deadline[1]);
                taskList.add(newTask1);
                System.out.println("Got it. I've added this task: \n" +
                        "      [D][ ] " + deadline[0] + "(" + deadline[1] + ")\n" +
                        "Now you have " + taskList.size() + " tasks in the list.");
                return true;
            case "event":
                userInput = userInput.replace("event ","");
                String[] event = userInput.split("/");
                Task newTask2 = new Task(event[0], false, 'E', event[1]);
                taskList.add(newTask2);
                System.out.println("Got it. I've added this task: \n" +
                        "      [E][ ] " + event[0] + "(" + event[1] + ")\n" +
                        "Now you have " + taskList.size() + " tasks in the list.");
                return true;
            default:
                return true;
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
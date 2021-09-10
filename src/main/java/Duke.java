import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class Duke {

    public static ArrayList<Task> taskList = new ArrayList<>();
    public static final String fileSeparator = " | ";

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
                System.out.println("Bye. Your tasks has been saved to myTask.txt.\n Hope to see you again soon!");
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
                        writeToFile();
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
                        writeToFile();
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
                        writeToFile();
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
                        writeToFile();
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
            case "delete":
                try {
                    int index = Integer.valueOf(splitStr[1]) - 1;
                    if (!userInput.equals("")) {
                        Boolean markToBeRemoved = taskList.get(index).getMark();
                        char toDoToRemoved = taskList.get(index).getToDo();
                        String descToBeRemoved = taskList.get(index).getDescription();
                        String additionalDetailsToBeRemoved = taskList.get(index).getAdditionalDetails();
                        taskList.remove(index);
                        String markToString;
                        if(markToBeRemoved) {
                            markToString = "X";
                        }
                        else {
                            markToString = "";
                        }
                        System.out.println("Noted. I've removed this task: \n" +
                                "      [" + toDoToRemoved + "][" + markToString + "] " + descToBeRemoved + additionalDetailsToBeRemoved + "\n" +
                                "Now you have " + taskList.size() + " tasks in the list.");
                        writeToFile();
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

    public static String getFileContent(){
        String result = "";
        for(int i = 0; i < taskList.size(); i++){
            result = result + taskList.get(i).getToDo() + fileSeparator + taskList.get(i).getMark() + fileSeparator;
            result = result + taskList.get(i).getDescription() + fileSeparator + taskList.get(i).getAdditionalDetails() + "\n";
        }
        return result;
    }

    public static void writeToFile() {
        try {
            //create file is it doesnt exist
            File myObj = new File("myTask.txt");
            if (myObj.createNewFile()) {
                //System.out.println("File created");
            }
            //exist
            FileWriter myWriter = new FileWriter("myTask.txt");
            myWriter.write(getFileContent());
            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
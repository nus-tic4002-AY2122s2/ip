import duke.dukeTask.*;
import duke.dukeException.*;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("what can i do for you?\n");
        getMsg();
    }

    private static void getMsg(){
        String line;
        Scanner sc = new Scanner(System.in);
        Task[] taskList = new Task[100];
        int counter = 1;
        // any other user input
        String[] userInput = null;
        String command;
        String input;
        String description = "";
        String date = "";
        // user input loops
        while (true) {
            line = sc.nextLine().trim();
            // exit program
            if (line.equals("bye")){
                System.out.println("Bye.Hope to see you again soon!");
                sc.close();
                break;
            }else{
                // check for user command and input
                userInput = line.split(" ",2);
                command = userInput[0].trim().toLowerCase();
                switch(command){
                    case "todo":
                        try{
                            if(userInput[1].trim() == ""){
                                throw new DukeException();
                            }
                            todoFunction(taskList, userInput[1].trim(), counter);
                            addTaskPrint(taskList,counter);
                        }catch(IndexOutOfBoundsException | DukeException e){
                             System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                        }
                        break;
                    case "done":
                        try{
                            if(userInput[1].trim() == ""){
                                throw new DukeException();
                            }
                            doneFunction(taskList, Integer.valueOf(userInput[1].trim()));
                            donePrint();
                        }catch (IndexOutOfBoundsException | DukeException e){
                            System.out.println("☹ OOPS!!! Please enter an index.");
                        }
                        catch (NullPointerException e){
                            System.out.println(" ☹ OOPS!!! The index you have key in dose not exist.");
                        }
                        break;
                    case "deadline":
                        try{
                            if(userInput[1].trim() == ""){
                                throw new DukeException();
                            }
                            description = userInput[1].trim().substring(0, userInput[1].trim().indexOf("/by")-1);
                            date = userInput[1].trim().substring(userInput[1].trim().indexOf("/by")+3, userInput[1].trim().length());
                            deadlineFunction(taskList, description, date, counter);
                            addTaskPrint(taskList,counter);
                        }catch(IndexOutOfBoundsException | DukeException e){
                            System.out.println("☹ OOPS!!! Please check deadline command that you have key in is in correct format.");
                        }
                        break;
                    case "event":
                        try{
                            if(userInput[1].trim() == ""){
                                throw new DukeException();
                            }
                            description = userInput[1].trim().substring(0, userInput[1].trim().indexOf("/at") - 1);
                            date = userInput[1].trim().substring(userInput[1].trim().indexOf("/at") + 3, userInput[1].trim().length());
                            eventFunction(taskList, description, date, counter);
                            addTaskPrint(taskList,counter);
                        }catch(IndexOutOfBoundsException | DukeException e){
                            System.out.println("☹ OOPS!!! Please check event command that you have key in is in correct format.");
                        }
                        break;
                    case "list":
                        printListFunction(taskList, counter);
                        break;
                    default:
                        wrongCommand();
                }
            }
        }
    }

    private static void printListFunction(Task[] taskList, int counter){
        System.out.println("Here are the tasks in your list:");
        for(int i = 1; i < counter; i++){
            System.out.println(i + "." +  taskList[i].toString());
        }
    }

    private static void doneFunction(Task[] taskList, int listLocation){
        Task t = taskList[listLocation];
        t.markAsDone();
        System.out.println("    " + taskList[listLocation].toString()) ;
    }

    private static Task[] todoFunction(Task[] taskList, String description, int counter){
        Task newTask = new Todo(description);
        //newTask.description = description;
        taskList[counter] = newTask;
        counter++;
        return taskList;
    }

    private static Task[] eventFunction(Task[] taskList, String description, String date, int counter){
        Task newTask = new Event(description, date);
        //newTask.description = description;
        taskList[counter] = newTask;
        counter++;
        return taskList;
    }

    private static Task[] deadlineFunction(Task[] taskList, String description, String date, int counter){
        Task newTask = new Deadline(description, date);
        //newTask.description = description;
        taskList[counter] = newTask;
        counter++;
        return taskList;
    }

    private static void wrongCommand(){
        System.out.print("You have enter an invalid command!!!");
    }

    private static void donePrint(){
        System.out.println("Nice! I've marked this task as done:");
    }

    private static void addTaskPrint(Task[] taskList, int counter){
        System.out.println("Got it. I've added this task:");
        System.out.println("    " + taskList[counter].toString());
        System.out.println("Now you have " + counter + " tasks in the list.\n");
    }
}

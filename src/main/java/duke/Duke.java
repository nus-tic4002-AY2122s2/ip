import duke.dukeTask.*;
import duke.dukeException.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static ArrayList<Task> taskList = new ArrayList<Task>(100);
    private static int counter = 0;
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
                            saveFunction(new Todo(userInput[1].trim()));
                        }catch(IndexOutOfBoundsException | DukeException e){
                             System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                        }
                        break;
                    case "done":
                        try{
                            if(userInput[1].trim() == ""){
                                throw new DukeException();
                            }
                            doneFunction(Integer.valueOf(userInput[1].trim())-1);
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
                            saveFunction(new Deadline(description, date));
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
                            saveFunction(new Event(description, date));
                        }catch(IndexOutOfBoundsException | DukeException e){
                            System.out.println("☹ OOPS!!! Please check event command that you have key in is in correct format.");
                        }
                        break;
                    case "list":
                        printListFunction();
                        break;
                    case "delete":
                        try{
                            if(userInput[1].trim() == ""){
                                throw new DukeException();
                            }
                            deleteFunction(Integer.valueOf(userInput[1].trim())-1);
                        }
                        catch(IndexOutOfBoundsException | DukeException e){
                            System.out.println("☹ OOPS!!! The description of a delete cannot be empty.");
                        }
                    default:
                        wrongCommand();
                }
            }
        }
    }

    private static void printListFunction(){
        System.out.println("Here are the tasks in your list:");
        for(int i = 1; i < counter; i++){
            System.out.println((i+1) + "." +  taskList.get(i).toString());
        }
    }

    private static void doneFunction(int listLocation){
        Task t = taskList.get(listLocation);
        t.markAsDone();
        System.out.println("    " + t.toString()) ;
    }

    private static void saveFunction(Task description){
        taskList.add(description);
        System.out.println("Got it. I've added this task:");
        System.out.println("   " + taskList.get(counter).toString());
        counter++;
        System.out.println("Now you have " + counter + " tasks in the list.");
    }

    private static void wrongCommand(){
        System.out.print("You have enter an invalid command!!!");
    }

    private static void donePrint(){
        System.out.println("Nice! I've marked this task as done:");
    }

    private static void deleteFunction(int listLocation){
        System.out.println("Noted. I've removed this task:");
        System.out.println("   " + taskList.get(listLocation).toString());
        counter--;
        System.out.println("Now you have " + counter + " tasks in the list.");
        taskList.remove(listLocation);
    }
}

import task.DeadLines;
import task.Events;
import task.Task;
import task.ToDo;

import java.util.ArrayList;
import java.util.Scanner;


public class Duke {
    private static String line = "_______________________________________\n"; // To shift to UI class
    private static ArrayList<Task> list = new ArrayList<Task>();
    public static void main(String[] args){
        greet();
        while (process(read()));
        exit();
    }
    private static void greet(){                                          // To shift to UI class
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String greet = " Hello! I'm Duke \n What can I do for you?\n";
        dukeReply(logo + greet);
    }

    private static void exit(){                                                 // To shift to UI class
        String bye = "Bye. Hope to see you again soon!\n";
        dukeReply(bye);
    }

    private static String parse(String userInput){                              // To shift to parser class
        String command = userInput.toLowerCase().trim();
        return command;
    }

    private static String read(){                                           // To shift to read class
            Scanner in = new Scanner(System.in);
            String userInput = parse(in.nextLine());
            return userInput;
    }

    private static void addToList (String userInput){
        String[] splitString = userInput.trim().split(" ", 2);
        if (splitString[1] == "" || splitString[1] == " "){
            throw new ArrayIndexOutOfBoundsException();
        }
        switch (splitString[0]) {
            case "todo":
                ToDo newTodo = new ToDo(splitString[1]);
                list.add(newTodo);
                break;
            case "event":
                String[] eventDescription = splitString[1].split("/at ", 2);
                Events newEvent = new Events(eventDescription[0], eventDescription[1]);
                list.add(newEvent);
                break;
            case "deadline":
                String[] deadlineDescription = splitString[1].split("/by ", 2);
                DeadLines newDeadline = new DeadLines(deadlineDescription[0], deadlineDescription[1]);
                list.add(newDeadline);
                break;
            default:
                return;
        }
        dukeReply("Got it. I've added this task:\n" + list.get(list.size()-1).getFullStatus() + "Now you have " + list.size() + " tasks in the list.\n");
    }


    private static void showList() throws DukeException {
        String taskList = new String();
        if (list.size() == 0){
            throw new DukeException();
        }
        int counter = 1;
        for (Task task : list){
            taskList = taskList.concat(counter + "." + task.getFullStatus());
            counter++;
        }
        dukeReply(taskList);
    }

    private static void markDone(String userInput) throws DukeExceptionInvalidTaskNumberDone, DukeException {
        if (userInput.length() < 5 || userInput.charAt(4) != ' ' || userInput.charAt(5) == ' ') { // Handling errors: When user types done1 done2 or done   2
            throw new DukeExceptionInvalidTaskNumberDone();
        }
        String taskNumber = userInput.substring(userInput.indexOf("done")+5);
        try {
            list.get(Integer.parseInt(taskNumber) - 1).isDone = true;
        }
        catch (IndexOutOfBoundsException e){
            throw new DukeException();
        }
        dukeReply("Nice! I've marked this task as done: \n" + list.get(Integer.parseInt(taskNumber) - 1).getFullStatus());
    }

    private static void dukeReply(String reply){
        System.out.println(line + reply + line);
    }

    private static String commandIdentifier(String userInput){
        if (userInput.contains("done"))  //priority 1
            return "done";
        else if (userInput.contains("list")) // priority 2
            return "list";
        else if (userInput.contains("bye"))
            return "bye";
        else if (userInput.contains("todo") || userInput.contains("event") || userInput.contains("deadline"))
            return "addToList";
        return "unknown";
    }

    private static boolean process(String userInput){
            String command = commandIdentifier(userInput);
        switch(command) {
            case "list":
                try{
                 showList();
                }
                catch (DukeException e){
                    dukeReply("There's nothing in your task list.\n");
            }
                return true;
            case "addToList":
                try {
                    addToList(userInput);
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    dukeReply("☹ OOPS!!! The description of a task cannot be empty. \n  " +
                            "If you're adding a todo task, please include the description. \n " +
                            "If you're adding an event task, please include /at in the description.\n " +
                            "If you're adding a deadline task, please include /by in the description.\n");
                }
                return true;
            case "done":
                try {
                    markDone(userInput);
                }
                catch (DukeExceptionInvalidTaskNumberDone | DukeException e){
                    dukeReply("You've entered an invalid task number, please enter a valid task number again.\n");
                }
                return true;
            case "unknown":
                dukeReply("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(\n");
                return true;
            default:
                return false;
        }
    }
}

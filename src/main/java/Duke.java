import java.util.ArrayList;
import java.util.Scanner;


public class Duke {
    private static String line = "_______________________________________\n"; // To shift to UI class
    private static ArrayList<Task> list = new ArrayList<Task>();
    public static void main(String[] args) {
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
        Task newTask = new Task(userInput);
        list.add(newTask);
        dukeReply("added: " + userInput + "\n");
    }

    private static void showList(){
        String taskList = new String();
        int counter = 1;
        for (Task task : list){
            taskList = taskList.concat(counter + "." + task.getFullStatus());
            counter++;
        }
        dukeReply(taskList);
    }

    private static void markDone(String userInput){
        String taskNumber = userInput.substring(userInput.indexOf("done")+5);
        list.get(Integer.parseInt(taskNumber) - 1).isDone = true;
        dukeReply("Nice! I've marked this task as done: \n" + list.get(Integer.parseInt(taskNumber) - 1).getFullStatus());
    }

    private static void dukeReply (String reply){
        System.out.println(line + reply + line);
    }

    private static String commandIdentifier(String userInput){
        if (userInput.contains("done"))  //priority 1
            return "done";
        else if (userInput.contains("list")) // priority 2
            return "list";
        else if (userInput.contains("bye"))
            return "bye";
        else
            return "addToList";

    }

    private static boolean process(String userInput){
        String command = commandIdentifier(userInput);
        switch(command) {
            case "list":
                showList();
                return true;
            case "addToList":
                addToList(userInput);
                return true;
            case "done":
                markDone(userInput);
                return true;
            default:
                return false;
        }
    }
}

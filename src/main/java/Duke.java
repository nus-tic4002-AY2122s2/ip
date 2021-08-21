import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
	
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        printWithLine(List.of("Hello from\n" + logo));
        printWithLine(List.of("Hello! I'm Duke", "What can I do for you?"));

        String line;
        Scanner in = new Scanner(System.in);
        List<Task> item = new ArrayList<>();

        do{
            line = in.nextLine();
            if(line.toLowerCase().equals("list")){
                printWithLine(List.of());
                List<String>messages = new ArrayList<>();
                System.out.println("   Here are the tasks in your list: ");
                for (int i = 0; i < item.size(); i++){
                    messages.add(i + 1 + "." + item.get(i));
                }
                printWithLine(messages);

            } else if(line.split(" ")[0].toLowerCase().equals("done")){
                printWithLine(List.of());
                Task markItem = item.get(Integer.parseInt(line.substring(5)) - 1);
                markItem.markAsDone();
                printWithLine(List.of("Nice! I've marked this task as done: ", " " + markItem));

            } else if(line.split(" ")[0].toLowerCase().equals("todo")){
                printWithLine(List.of());
                Task todoTask = new Todo(line.replace(line.split(" ")[0] + " ", ""));
                item.add(todoTask);
                printWithLine((List.of("Got it. I've added this task: ", todoTask.toString(), "Now you have " + item.size() + " task in the list. ")));

            } else if(line.split(" ")[0].toLowerCase().equals("deadline")){
                printWithLine(List.of());
                int position = line.indexOf("/");
                String time = line.split("/")[1].replace("by ", "");
                Task deadlineTask = new Deadline(line.substring(9, position - 1), time);
                item.add(deadlineTask);
                printWithLine((List.of("Got it. I've added this task: ", deadlineTask.toString(), "Now you have " + item.size() + " task in the list. ")));

            } else if(line.split(" ")[0].toLowerCase().equals("event")){
                printWithLine(List.of());
                int position = line.indexOf("/");
                String time = line.split("/")[1].replace("at ", "");
                Task eventTask = new Event(line.substring(6, position - 1), time);
                item.add(eventTask);
                printWithLine((List.of("Got it. I've added this task: ", eventTask.toString(), "Now you have " + item.size() + " task in the list. ")));

            } else if(line.toLowerCase().equals("bye")){
                printWithLine(List.of());
                printWithLine(List.of("Bye. Hope to see you again soon!"));

            } else{
                Task task = new Task(line);
                item.add(task);
                printWithLine(List.of());
                printWithLine(List.of("added: " + task));

            }
        }while(!line.equals("bye"));
    }

    private static void printWithLine(List<String> messages){
		
        for (String message : messages){
            System.out.println("   " + message);
        }
        System.out.println("   _____________________________________");
    }
}

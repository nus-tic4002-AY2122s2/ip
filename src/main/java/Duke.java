import java.util.*;
import tasks.*;

public class Duke {
    public static void main(String[] args) {
        String greeting = " Hello! I'm Duke\n" + " What can I do for you?";
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(greeting);

        boolean running = true;
        String input;
        Scanner sc = new Scanner(System.in);
        List<Task> list = new ArrayList<>();
        while(running){
            input = sc.nextLine();
            if(input.matches("bye")){
                break;
            }else{
                controller(input,list);
            }

        }

        System.out.println(bye);

    }

    //Will be refactored and in better components
    public static void controller(String input, List<Task> list ){
        int index = 0;
        String secPart;
        String description;
        if(input.matches("list")){
            for(int i = 0; i < list.size(); i++){
                System.out.println(i + 1 + ". " + list.get(i).toString());
            }
        }else if(input.contains("done")){
            int option = Integer.parseInt(input.replaceAll("done","").trim());
            if(option > 0 && option <= list.size()){
                list.get(option - 1).changeDoneTo(true);
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(" " + list.get(option-1).toString());
            }


        }else if(input.contains("todo")){
            description = input.replaceFirst("todo","").trim();
            list.add(new ToDo(description));
            System.out.println("Got it. I've added this task:");
            System.out.println(list.get(list.size()-1).toString() );
            System.out.println("Now you have " + list.get(0).getCumulatedTasksAdded() + " tasks in the list.");

        }else if(input.contains("deadline")){
            index = input.indexOf("/by");
            secPart = input.substring(index).replaceFirst("/by","").trim();
            description = input.substring(0, index).replaceFirst("deadline","").trim();

            list.add(new Deadline(description,secPart));
            System.out.println("Got it. I've added this task:");
            System.out.println(list.get(list.size()-1).toString() );
            System.out.println("Now you have " + list.get(0).getCumulatedTasksAdded() + " tasks in the list.");

        }else if(input.contains("event")){
            index = input.indexOf("/at");
            secPart = input.substring(index).replaceFirst("/at","").trim();
            description = input.substring(0, index).replaceFirst("event","").trim();

            list.add(new Event(description,secPart));

            System.out.println("Got it. I've added this task:");
            System.out.println(list.get(list.size()-1).toString() );
            System.out.println("Now you have " + list.get(0).getCumulatedTasksAdded() + " tasks in the list.");

        }else{
            list.add(new Task(input));
            System.out.println("Got it. I've added this task:");
            System.out.println(list.get(list.size()-1).toString() );
            System.out.println("Now you have " + list.get(0).getCumulatedTasksAdded() + " tasks in the list.");
        }
    }


}


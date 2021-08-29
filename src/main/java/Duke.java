import java.util.ArrayList;
import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        new Duke().run();


    }

    public boolean readCommand(String line, ArrayList<Task> tasks){
        try{
            int spaceIndex = line.indexOf(" ");
            String instruction;
            switch(line.split(" ")[0].toLowerCase()){
                case ("list"):
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i).toString());
                    }
                    System.out.println("____________________________________________________________");
                    break;
                case ("done"):
                    int i = Integer.parseInt(line.split(" ")[1]);
                    tasks.get(i - 1).markAsDone();
                    System.out.println("Nice! I've marked this task as done: \n" +
                            "[" + tasks.get(i - 1).getStatusIcon() + "] " + tasks.get(i - 1).getTask());
                    break;

                case ("deadline"):
                    instruction = line.substring(spaceIndex);
                    if(instruction.contains("/by")){
                        String description = instruction.split("/by")[0];
                        String time = instruction.split("/by")[1];
                        tasks.add(new Deadline(description,time));
                        System.out.println("I have added the deadline task");
                    }
                    else {
                        throw new DukeException("You forgot to include a date using /by");
                    }
                    break;

                case("event"):
                    instruction = line.substring(spaceIndex);
                    if(instruction.contains("/at")){
                        String description = instruction.split("/at")[0];
                        String time = instruction.split("/at")[1];
                        tasks.add(new Event(description,time));
                        System.out.println("I have added the event task");
                    }
                    else{
                        throw new DukeException("You forgot to include a date using /at");
                    }
                    break;

                case("todo"):
                    instruction = line.substring(spaceIndex);
                    tasks.add(new ToDo(instruction));
                    System.out.println("I have added the todo task");
                    break;

                case ("bye"):
                    System.out.println("See you!");
                    System.out.println("____________________________________________________________");
                    return true;

                default:
                    Task task = new Task(line);
                    tasks.add(task);
                    System.out.println("line added");
                    System.out.println("____________________________________________________________");


            }
        }catch (DukeException e){
            System.out.println("error:" + e.getMessage() + ". Please type again");
        }catch (Exception e){
            System.out.println("error:" + e.getMessage() + ". Please type again");
        }
        return false;
    }

    public void run() {
        System.out.println("Hello! I'm Duke \n  " +
                "What can I do for you?");
        System.out.println("____________________________________________________________");
        ArrayList<Task> tasks = new ArrayList<>();
        boolean isExit = false;
        while (!isExit) {
            String line;
            Scanner in = new Scanner(System.in);
            System.out.println("Type something: ");
            line = in.nextLine();
            System.out.println("____________________________________________________________");
            isExit = readCommand(line, tasks);


        }
    }
}

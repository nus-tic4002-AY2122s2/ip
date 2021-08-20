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
            try{
                switch(line.split(" ")[0].toLowerCase()){
                    case ("list"):

                        for(int i = 0; i< tasks.size(); i++){
                            System.out.println((i+1) + ". [" + tasks.get(i).getStatusIcon() + "]"+ tasks.get(i).getDescription());
                        }
                        System.out.println("____________________________________________________________");
                        break;
                    case ("done"):
                        int i = Integer.parseInt(line.split(" ")[1]);
                        tasks.get(i-1).markAsDone();
                        System.out.println("Nice! I've marked this task as done: \n" +
                                "[" +  tasks.get(i-1).getStatusIcon() + "] return book");
                        break;
                    case("bye"):
                        isExit = true;
                        System.out.println("See you!");
                        System.out.println("____________________________________________________________");
                        break;

                    default:
                        Task task = new Task(line);
                        tasks.add(task);
                        System.out.println("line added");
                        System.out.println("____________________________________________________________");


                }
            }catch (Exception e){
                System.out.println("error:" + e.toString() + ". Please type again");
            }



        }
    }
}

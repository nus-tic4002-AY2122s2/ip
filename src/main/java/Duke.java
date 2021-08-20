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
        ArrayList<String> tasks = new ArrayList<>();
        boolean isExit = false;
        while (!isExit) {

            String line;

            Scanner in = new Scanner(System.in);
            System.out.println("Type something: ");
            line = in.nextLine();
            System.out.println("____________________________________________________________");

            switch(line.toLowerCase()){
                case ("list"):
                    System.out.println(tasks.size());
                    for(int i = 0; i< tasks.size(); i++){
                        System.out.println(tasks.get(i));
                    }
                    System.out.println("____________________________________________________________");
                    break;
                case("bye"):
                    isExit = true;
                    System.out.println("See you!");
                    System.out.println("____________________________________________________________");
                    break;

                default:

                    System.out.println("line added");
                    tasks.add(line);
                    System.out.println("____________________________________________________________");


            }


        }
    }
}

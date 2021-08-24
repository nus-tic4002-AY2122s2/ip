import java.util.*;

public class Duke {
    public static void main(String[] args) {
        String greeting = " Hello! I'm Duke\n" + " What can I do for you?";
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(greeting);

        boolean running = true;
        String input;
        Scanner sc = new Scanner(System.in);
        while(running){
            input = sc.nextLine();
            if(input.matches("bye")){
                break;
            }
            System.out.println(input);
        }

        System.out.println(bye);

    }
}

import java.util.*;

public class Duke {
    public static void main(String[] args) {
        String greeting = " Hello! I'm Duke\n" + " What can I do for you?";
        String bye = "Bye. Hope to see you again soon!";
        System.out.println(greeting);

        boolean running = true;
        String input;
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while(running){
            input = sc.nextLine();
            if(input.matches("bye")){
                break;
            }

            if(input.matches("list")){
                for(int i = 0; i < list.size(); i++){
                    System.out.println(i + 1 + ". " + list.get(i));
                }
            }else{
                list.add(input);
                System.out.println("Added: " + input);

            }


        }

        System.out.println(bye);

    }
}

import java.util.Scanner;


/**
    Duke version 2.0 for TIC4001
 */
public class Duke {

    public static void main(String[] args) {
        String logo =   "  .\" \".    ____        _        \n"
                +       " / o o \\   |  _ \\ _   _| | _____ \n"
                +       " |/\\v/\\|   | | | | | | | |/ / _ \\\n"
                +       "/|     |\\  | |_| | |_| |   <  __/\n"
                +       "\\|_^_^_|/  |____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

	// TODO: Refactor variable out of class
	boolean isActive = true;

        // Level 0 - Greet
	System.out.println("Hello! I'm Duke \nWhat can I do for you?");

	// TODO: Customise Display Output of Duke
	while(isActive) {
	// Level 1 - Greet, Echo, Exit		
		Scanner in = new  Scanner(System.in);
		String input = in.nextLine();
		command_action(input,isActive);
	}
    }

   public static void command_action(String input, boolean isActive){
	
	switch(input.toUpperCase()) {
		
		case "BYE":
			System.out.println("Bye. Hope to see you again soon!");
			isActive = false;
			break;
		default:
			System.out.println(input);
	}

   }
}

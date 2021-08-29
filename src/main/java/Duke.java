import java.util.*;


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

	// TODO: Refactor below
	boolean isActive = true;
	ArrayList<String> itemLists =new ArrayList<String>(); // to re-create into a persistant class

        // Level 0 - Greet
	System.out.println("Hello! I'm Duke \nWhat can I do for you?");

	// TODO: Customise Display Output of Duke
	while(isActive) {
	// Level 1 - Greet, Echo, Exit		
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();

		if (!input.toUpperCase().equals("LIST") && !input.equals("")) {
			itemLists.add(input); // Quick fix solution - to refactor
			System.out.println("added: " + input);
		}
			
		

		command_action(input,isActive, itemLists);

		}
    }

   public static void command_action(String input, boolean isActive, ArrayList<String> itemLists){
	
	switch(input.toUpperCase()) {
		
		case "BYE":
			System.out.println("Bye. Hope to see you again soon!");
			isActive = false;
			break;
		case "LIST":
			list_items(itemLists);
			break;
		default:
			
	}

   }

   public static void list_items (ArrayList<String> itemLists) {
	   int i = 1;
	   for (String s : itemLists) {
		   System.out.println( i + ". " + s);
		   i++;
	   }
   }
}

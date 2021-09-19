import java.util.*;

// Addtional Classes to refactor
class ParserText {

  public static boolean isTrue;
  ArrayList<TaskList> taskList;

  public ParserText() {
    this.isTrue = true;
    // TaskList taskList = new TaskList();
    taskList = new ArrayList<TaskList>();
  }

  public void parse(String input) {
    String command[] = input.split(" ");

    switch (command[0].toUpperCase()) {
      case "BYE":
        System.out.println("Bye. Hope to see you again soon!");
        this.isTrue = false;
        break;
      case "LIST":
        System.out.println("Here are the Tasks in your List:");

        // TODO: TO refactor
        int i = 1;
        for (TaskList task : this.taskList) {
          task.printTask(i++);
        }

        break;
      case "DONE":
        System.out.println("Nice! I have marked this as Done:");

        // TODO: TO refactor
        int index = Integer.parseInt(command[1]) - 1;
        this.taskList.get(index).markDone();

        // TODO: TO refactor
        int j = 1;
        for (TaskList task : this.taskList) {
          task.printTask(j++);
        }

        break;
      default:
        this.taskList.add(new TaskList(input));
    }
  }
}

// Custom Data type
class TaskList {
  protected String description;
  protected boolean isDone;

  public TaskList(String description) {
    this.description = description;
    this.isDone = false;
  }

  public void printTask(int i) {
    System.out.println(i + "." + "[" + ((this.isDone) ? "X" : " ") + "] " + this.description);
  }

  public void markDone() {
    this.isDone = true;
  }
}

/** Duke version 2.0 for TIC4001 */
public class Duke {

  public static void main(String[] args) {
    String logo =
        "  .\" \".    ____        _        \n"
            + " / o o \\   |  _ \\ _   _| | _____ \n"
            + " |/\\v/\\|   | | | | | | | |/ / _ \\\n"
            + "/|     |\\  | |_| | |_| |   <  __/\n"
            + "\\|_^_^_|/  |____/ \\__,_|_|\\_\\___|\n";
    System.out.println("Hello from\n" + logo);

    // TODO: Refactor below
    ArrayList<String> itemLists = new ArrayList<String>(); // to re-create into a persistant class

    // Custom Classes Declare
    ParserText response = new ParserText();

    // Level 0 - Greet
    System.out.println("Hello! I'm Duke \nWhat can I do for you?");

    // TODO: Customise Display Output of Duke
    while (response.isTrue) {
      // Level 1 - Greet, Echo, Exit
      Scanner in = new Scanner(System.in);
      String input = in.nextLine();

      response.parse(input);
    }
  }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static ArrayList<String> taskList = new ArrayList<>(100);

    public static void main(String[] args) {
        UI.printDuke();
        String line;
        Scanner in = new Scanner(System.in);

        while (true) {
            line = in.nextLine();
            if (line.equals("bye")) {
                UI.bye();
                break;
            } else if (line.equals("list")){
                list();
            } else {
                todoTask(line);
            }
        }
    }

    static void todoTask(String line) {
        taskList.add(line);
        UI.printTask(taskList);
    }

    static void list() {
        if (taskList.size() != 0) {
            UI.printOutput(taskList);
        } else {
            UI.printListEmpty();
        }
    }
}
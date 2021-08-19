import tasklist.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static ArrayList<Task> taskList = new ArrayList<>(100);

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
            } else if (line.contains("done")) {
                done(line);
            } else {
                todoTask(line);
            }
        }
    }

    static void todoTask(String line) {
        Task t = new Task(line);
        taskList.add(t);
        UI.printTask(taskList);
    }

    static void list() {
        if (taskList.size() != 0) {
            UI.printOutput(taskList);
        } else {
            UI.printListEmpty();
        }
    }

    static void done(String line){
        if (taskList.size() != 0) {
            String theStr = line.substring(5);
            String[] strArr = theStr.split(",");
            int[] intArr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                String num = strArr[i];
                intArr[i] = Integer.parseInt(num);
            }

            if (intArr.length > 0) {
                for (int i = 0; i < intArr.length; i++) {
                    Task t = taskList.get(intArr[i] - 1);
                    t.markAsDone();
                    UI.printMarkedAsDone(t);
                }
            }
        } else {
            UI.printListEmpty();
        }
    }
}
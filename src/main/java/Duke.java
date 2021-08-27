import tasklist.Deadline;
import tasklist.Event;
import tasklist.Task;
import tasklist.ToDo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

            } else if (line.contains("done") && line.charAt(0) == 'd') {
                done(line);

            } else if (line.contains("event") && line.charAt(0) == 'e') {
                event(line);

            } else if (line.contains("deadline") && line.charAt(0) == 'd') {
                deadline(line);

            } else if (line.contains("todo") && line.charAt(0) == 't') {
                todo(line);
            }
        }
    }

    static void todo(String line) {
        String taskDescription = line.substring(5);
        Task t = new ToDo(taskDescription);
        taskList.add(t);
        UI.printTask(taskList);
    }

    static void event(String line) {
        //e.g event dinner /at 12 oct 2019
        if (line.contains("/at")) {
            //str[1] to get date - 12 oct 2019
            String[] str = line.split(" /at ", 2);
            //description[1] to get description - dinner
            String[] taskDescription = str[0].split(" ", 2);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
            try {
                //Format date 12 Oct 2019, to string "12 Oct 2019"
                Date date = dateFormat.parse(str[1]);
                String strDate = dateFormat.format(date);
                Task t = new Event(taskDescription[1], strDate);
                taskList.add(t);

            } catch (ParseException e) {
                UI.printParseException();
            }

        } else {
            //e.g event dinner
            String taskDescription = line.substring(6);
            Task t = new Event(taskDescription, "Date not specified");
            taskList.add(t);
        }
        UI.printTask(taskList);
    }

    static void deadline(String line) {
        if (line.contains("/by")) {
            //str[1] to get date - 12 oct 2019
            String[] str = line.split(" /by ", 2);
            //description[1] to get description - duke
            String[] taskDescription = str[0].split(" ", 2);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
            try {
                //Format date 12 Oct 2019, to string "12 Oct 2019"
                Date date = dateFormat.parse(str[1]);
                String strDate = dateFormat.format(date);
                Task t = new Deadline(taskDescription[1], strDate);
                taskList.add(t);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }else {
            //e.g deadline duke
            String taskDescription = line.substring(9);
            Task t = new Deadline(taskDescription, "Date not specified");
            taskList.add(t);
        }
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
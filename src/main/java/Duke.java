import exceptions.*;
import tasklist.Deadline;
import tasklist.Event;
import tasklist.Task;
import tasklist.ToDo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Duke {
    public static ArrayList<Task> taskList = new ArrayList<>(100);

    public static void main(String[] args) throws IOException {
        Storage.loadFile();
        UI.printDuke();
        String line;
        Scanner in = new Scanner(System.in);

        while (true) {
            line = in.nextLine();
            if (line.equals("bye")) {
                UI.bye();
                break;
            } else if (line.equals("list")) {
                list();

            } else if (line.equals("save")) {
                save();

            } else if (line.startsWith("done")) {
                markedAsDone(line);

            } else if (line.startsWith("delete")) {
                deleteTask(line);
            }
            else if (line.startsWith("event")) {
                event(line);

            } else if (line.startsWith("deadline")) {
                deadline(line);

            } else if (line.startsWith("todo")) {
                todo(line);
            } else {
                processInvalidTask(line);
            }
        }
    }

    static void todo(String line) {
        try {
            checkEmptyToDoDescription(line.trim());
            String taskDescription = line.substring(5);
            Task t = new ToDo(taskDescription);
            taskList.add(t);
            UI.printTask(taskList);
        } catch (EmptyToDoDescriptionException e){
            UI.printEmptyToDoDescriptionException();
        }
    }

    static void event(String line) {
        try {
            checkEmptyEventDescription(line.trim());
            //e.g event dinner /at 12 oct 2019
            if (line.contains("/at")) {
                //str[1] to get date - 12 oct 2019
                String[] str = line.split(" /at ", 2);
                //description[1] to get description - dinner
                String[] taskDescription = str[0].split(" ", 2);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                //Format date 12 Oct 2019, to string "12 Oct 2019"
                Date date = dateFormat.parse(str[1]);
                String strDate = dateFormat.format(date);
                Task t = new Event(taskDescription[1], strDate);
                taskList.add(t);
            } else {
                //e.g event dinner
                String taskDescription = line.substring(6);
                Task t = new Event(taskDescription, "Date not specified");
                taskList.add(t);
            }
            UI.printTask(taskList);
        } catch (EmptyEventDescriptionException e) {
            UI.printEmptyEventDescriptionException();
        } catch (ParseException e) {
            UI.printParseException();
        }
    }

    static void deadline(String line) {
        try {
            checkEmptyDeadlineDescription(line.trim());
            if (line.contains("/by")) {
                //str[1] to get date - 12 oct 2019
                String[] str = line.split(" /by ", 2);
                //description[1] to get description - duke
                String[] taskDescription = str[0].split(" ", 2);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                //Format date 12 Oct 2019, to string "12 Oct 2019"
                Date date = dateFormat.parse(str[1]);
                String strDate = dateFormat.format(date);
                Task t = new Deadline(taskDescription[1], strDate);
                taskList.add(t);
            } else {
                //e.g deadline duke
                String taskDescription = line.substring(9);
                Task t = new Deadline(taskDescription, "Date not specified");
                taskList.add(t);
            }
            UI.printTask(taskList);
        } catch (EmptyDeadlineDescriptionException e) {
            UI.printEmptyDeadlineDescriptionException();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static void save() throws FileNotFoundException {
        String list = "";
        try {
            checkListEmpty(taskList);
            for (int i = 0; i < taskList.size(); i++) {
                list += taskList.get(i).saveFormat() + "\n";
            }
            Storage.writeToFile(list);
            UI.printTaskSaved();
        }catch  (ListEmptyException e) {
            UI.printListEmpty();
        }
    }

    static void list() {
        try {
            checkListEmpty(taskList);
            UI.printOutput((taskList));
        } catch (ListEmptyException e) {
            UI.printListEmpty();
        }
    }

    static void markedAsDone(String line) {
        try {
            checkListEmpty(taskList);
            String theStrIndex = line.substring(5);
            String[] theStrIndexArr = theStrIndex.split(",");
            int[] intArr = new int[theStrIndexArr.length];
            for (int i = 0; i < theStrIndexArr.length; i++) {
                String num = theStrIndexArr[i];
                intArr[i] = Integer.parseInt(num);
                checkIndexOutOfRange(taskList.size(), intArr[i]);
            }

            UI.printLine();
            UI.printMarkedAsDone();

            for (int i = 0; i < intArr.length; i++) {
                Task t = taskList.get(intArr[i] - 1);
                t.markAsDone();
                UI.addSpaces("%s" + t.toString(),6);
            }

            UI.printLine();

        } catch (NumberFormatException e) {
            UI.printNumberFormatException();
        }
        catch (IndexOutOfRangeException e) {
            UI.printIndexOutOfRangeException();
        }
        catch  (ListEmptyException e) {
            UI.printListEmpty();
        }
    }

    static void deleteTask(String line) {
        try {
            checkListEmpty(taskList);
            String theStrIndex = line.substring(7);
            String[] theStrIndexArr = theStrIndex.split(",");
            int[] intArr = new int[theStrIndexArr.length];

            for (int i = 0; i < theStrIndexArr.length; i++) {
                String num = theStrIndexArr[i];
                intArr[i] = Integer.parseInt(num);
                checkIndexOutOfRange(taskList.size(), intArr[i]);
            }

            UI.printLine();
            UI.printRemoveTask();

            for (int i = 0; i < intArr.length; i++) {
                Task t = taskList.get(intArr[i]-(i+1));
                UI.addSpaces("%s" + t.toString(),6);
                taskList.remove(intArr[i]-(i+1));
            }

            UI.printNumberOfTasks(taskList);
            UI.printLine();

        } catch (NumberFormatException e) {
            UI.printNumberFormatException();
        } catch (IndexOutOfRangeException e) {
            UI.printIndexOutOfRangeException();
        } catch  (ListEmptyException e) {
            UI.printListEmpty();
        }
    }

    static void processInvalidTask(String line) {
        try {
            checkEmpty(line);
            checkInvalidWord(line);
        } catch (EmptyException e) {
            UI.printEmptyException();
        } catch (StringFormatException e){
            UI.printStringFormatException();
        }
    }

    static void checkEmpty(String description) throws EmptyException {
        if (description.isEmpty()){
            throw new EmptyException ();
        }
    }

    static void checkInvalidWord(String description) throws StringFormatException {
        if ( !( description.equals("bye") || description.equals("list")
                || description.equals("todo") || description.equals("event")
                || description.equals("deadline"))) {
            throw new StringFormatException ();
        }
    }

    static void checkEmptyToDoDescription (String description) throws EmptyToDoDescriptionException {
        if (description.equals("todo")) {
            throw new EmptyToDoDescriptionException();
        }
    }

    static void checkEmptyEventDescription (String description) throws EmptyEventDescriptionException {
        if (description.equals("event")) {
            throw new EmptyEventDescriptionException();
        }
    }

    static void checkEmptyDeadlineDescription (String description) throws EmptyDeadlineDescriptionException {
        if (description.equals("deadline")) {
            throw new EmptyDeadlineDescriptionException();
        }
    }

    static void checkIndexOutOfRange(int size,  int number) throws IndexOutOfRangeException {
        if (number > size || number < 0) {
            throw new IndexOutOfRangeException();
        }
    }

    static void checkListEmpty( ArrayList<Task> taskList) throws ListEmptyException {
        if (taskList.isEmpty()) {
            throw new ListEmptyException ();
        }
    }
}
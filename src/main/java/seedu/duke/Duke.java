package seedu.duke;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the AirRec application.
     */

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        Message.getVal("GREETING",logo);

        run();
    }


    public static void run() {
        try {
            TaskList taskList = new TaskList();
            String userInput;
            boolean online = true;
            Storage storage = new Storage(taskList);
            storage.readFile();

            while (online) {
                Scanner scan = new Scanner(System.in);
                userInput = scan.nextLine().trim();
                String command = new Parser().parseInput(userInput);
                switch (command) {
                case "bye":
                    Message.getVal("BYE_MESSAGE");
                    online = false;
                    break;
                case "todo":
                    taskList.addToDo(userInput);
                    storage.saveToDB(userInput);
                    Message.getVal("ADDED_SUCCESSFULLY",Integer.toString(taskList.getSize()));
                    break;
                case "deadline":
                    taskList.addDeadline(userInput);
                    storage.saveToDB(userInput);
                    Message.getVal("ADDED_SUCCESSFULLY",Integer.toString(taskList.getSize()));
                    break;
                case "event":
                    taskList.addEvent(userInput);
                    storage.saveToDB(userInput);
                    Message.getVal("ADDED_SUCCESSFULLY",Integer.toString(taskList.getSize()));
                    break;
                case "list":
                    for (int i = 0; i < taskList.getSize(); i++) {
                        System.out.println("Task " + (i + 1) + ": "
                               + taskList.getList().get(i).getTaskDetails());
                    }
                    break;
                case "find":
                    if (userInput.equals("search")) {
                        Message.getVal("SEARCH_EMPTY");
                    } else {
                        ArrayList<Task> tempList = taskList.searchTask(userInput);

                        if (tempList.size() > 0) {
                            Message.getVal("SEARCH_MATCHING_START_MESSAGE");
                            //System.out.println("Here are the matching flights in your list:");
                            for (Task task : tempList) {
                                System.out.println(task.getTaskDetails());
                            }
                        } else {
                            Message.getVal("NO_MATCH");
                            //System.out.println("There is no matching task in your list.");
                        }
                    }
                    break;
                case "done":
                    taskList.markTask(userInput);
                    storage.markTaskDB(userInput);
                    Message.getVal("MARK_SUCCESSFULLY",Integer.toString(taskList.getSize()));
                    break;
                case "delete":
                    taskList.deleteTask(userInput);
                    storage.deleteFromDB(userInput);
                    Message.getVal("DELETE_SUCCESSFULLY",Integer.toString(taskList.getSize()));
                    break;
                case "help":
                    Message.getVal("HELP_MESSAGE");
                    break;

                default:
                    Message.getVal("ERROR_UNKNOWN");
                }
            }
        } catch (Exception e) {
            Message.getVal("ERROR_UNKNOWN");
        }
    }

}
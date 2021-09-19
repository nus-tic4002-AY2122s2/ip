import duke.dukeException.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Duke {

    /**
     * Main function to start
     * @param args
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        new Duke().run();
    }


    public boolean readCommand(String line, ArrayList<Task> tasks){
        try{
            int spaceIndex = line.indexOf(" ");
            String instruction;
            switch(line.split(" ")[0].toLowerCase()){
                case ("list"):
                    if(tasks.isEmpty()){
                        throw new DukeException("Empty task list");
                    }
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i).toString());
                    }
                    System.out.println("____________________________________________________________");
                    break;

                case ("done"):
                    int i = Integer.parseInt(line.split(" ")[1]);
                    tasks.get(i - 1).editDone(Boolean.TRUE);
                    System.out.println("Nice! I've marked this task as done: \n" +
                            "[" + tasks.get(i - 1).getStatusIcon() + "] " + tasks.get(i - 1).getTaskDescription());
                    break;

                case ("deadline"):
                    instruction = line.substring(spaceIndex);
                    if(instruction.contains("/by")){
                        String description = instruction.split("/by")[0];
                        String time = instruction.split("/by")[1];
                        tasks.add(new Deadline(description,time));
                        System.out.println("I have added the deadline task");
                    }
                    else {
                        throw new DukeException("You forgot to include a date using /by");
                    }
                    break;

                case("event"):
                    instruction = line.substring(spaceIndex);
                    if(instruction.contains("/at")){
                        String description = instruction.split("/at")[0];
                        String time = instruction.split("/at")[1];
                        tasks.add(new Event(description,time));
                        System.out.println("I have added the event task");
                    }
                    else{
                        throw new DukeException("You forgot to include a date using /at");
                    }
                    break;

                case("todo"):
                    instruction = line.substring(spaceIndex);
                    tasks.add(new ToDo(instruction));
                    System.out.println("I have added the todo task: " + instruction);
                    break;

                case ("bye"):
                    System.out.println("See you!");
                    System.out.println("____________________________________________________________");
                    return true;

                case ("delete"):
                    if(tasks.isEmpty()){
                        throw new DukeException("Empty task list");
                    }
                    try{
                        i = Integer.parseInt(line.split(" ")[1]);
                        String deletedTask = tasks.get(i - 1).getTaskDescription();
                        tasks.remove(i-1);

                        System.out.println("I've deleted this task: \n" + deletedTask);
                    }catch (NumberFormatException e){
                        throw new DukeException("Empty task list");
                    }

                    break;

                default:
                    throw new DukeException("Please key in a valid command");

            }
        }catch (DukeException e){
            System.out.println("error:" + e.getMessage() + ". Please type again");
            System.out.println("____________________________________________________________");
        }catch (Exception e){
            System.out.println("error:" + e.getMessage() + ". Please type again");
        }
        return false;
    }

    public static void save(ArrayList<Task> lists){
        try {
            java.nio.file.Path folderDir = java.nio.file.Paths.get("data");
            boolean directoryExists = java.nio.file.Files.exists(folderDir);
            if(!directoryExists){
                java.nio.file.Files.createDirectories(folderDir);
            }
            java.nio.file.Path filePath = java.nio.file.Paths.get("data", "duke.txt");
            FileWriter fileWrite = new FileWriter(filePath.toString());
            for (int i = 0; i < lists.size(); i++) {
                String storingTask = convertTaskStoring(lists.get(i), i);
                fileWrite.write(storingTask);
            }
            fileWrite.close();
        }catch(IOException | DukeException e){
            System.out.println("error:" + e.getMessage() + ".");
        }

    }

    private static String convertTaskStoring(Task task, int index) throws DukeException, IllegalStateException {
        String storingTask;
        switch (task.getTaskType()) {
            case EVENT:
                Event event = (Event) task;
                storingTask = (index + 1) + " | E"
                        + " | " + (event.getIsDone() ? "1" : "0")
                        + " | " + event.getTask()
                        + " | " + event.getDateTimeString()
                        + System.lineSeparator();
                break;
            case DEADLINE:
                Deadline deadlines = (Deadline) task;
                storingTask = (index + 1) + " | D"
                        + " | " + (deadlines.getIsDone() ? "1" : "0")
                        + " | " + deadlines.getTask()
                        + " | " + deadlines.getDateTimeString()
                        + System.lineSeparator();
                break;
            case TODO:
                storingTask = (index + 1) + " | T"
                        + " | " + (task.getIsDone() ? "1" : "0")
                        + " | " + task.getTask()
                        + System.lineSeparator();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + task.getTaskType());
        }
        return storingTask;
    }

    public static ArrayList<Task> load() throws DukeException {
        try {
            ArrayList<Task> tasks = getListOfTask();
            return tasks;
        }catch (FileNotFoundException e) {
            throw new DukeException("Empty list process to create new list");
        }

    }

    private static ArrayList<Task> getListOfTask() throws FileNotFoundException, DukeException {
        ArrayList<Task> tasks = new ArrayList<>();
        java.nio.file.Path filePath = java.nio.file.Paths.get( "data", "duke.txt");
        boolean directoryExists = java.nio.file.Files.exists(filePath);
        if(!directoryExists){
            throw new DukeException("No Storage file found. Proceed with a new list");
        }
        File f = new File(filePath.toString()); // create a File for the given file path
        if(f.length() == 0){
            return new ArrayList<Task>();
        }
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            Task task = convertTaskFromFile(s.nextLine());
            tasks.add(task);
        }

        return tasks;
    }

    private static Task convertTaskFromFile(String text) throws DukeException {
        Task task;
        int firstDivider = text.indexOf("| ");
        String taskType = text.substring(firstDivider + 2, firstDivider + 3);
        String taskDoneString = text.substring(firstDivider + 6, firstDivider +7);
        String taskDetails = text.substring(firstDivider + 10);
        boolean isDone = false;
        if(!(taskDoneString.contains("0")||taskDoneString.contains("1"))) {

            throw new DukeException("Unknown boolean");
        }
        if(taskDoneString.contains("1")){
            isDone = true;
        }
        if(taskDetails.contains(" | ")){
            int timeDivider = taskDetails.indexOf(" | ");
            String taskDes = taskDetails.substring(0, timeDivider);
            String taskTime = taskDetails.substring(timeDivider + 3);
            task = creatingEventOrDeadline(taskType, taskDes, taskTime);
            task.editDone(isDone);
            return task;
        }
        if(!taskType.contains("T")){
            throw new DukeException("Unknown task type");
        }
        task = new ToDo(taskDetails);
        task.editDone(isDone);

        return task;
    }

    private static Task creatingEventOrDeadline(String taskType, String taskDes, String taskDateTime) throws DukeException {
        if(taskType.contains("D")){
            return new Deadline(taskDes,taskDateTime);
        }
        if(taskType.contains("E")){
            return new Event(taskDes,taskDateTime);
        }

        throw new DukeException("Unknown task Type");
    }

    public void run() {
        System.out.println("Hello! I'm Duke \n  " +
                "What can I do for you?");
        System.out.println("____________________________________________________________");
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            tasks = load();
        }catch (DukeException e){
            System.out.println("error:" + e.getMessage() + ".");
        }
        boolean isExit = false;
        while (!isExit) {
            String line;
            Scanner in = new Scanner(System.in);
            System.out.println("Type something: ");
            line = in.nextLine();
            System.out.println("____________________________________________________________");
            save(tasks);
            isExit = readCommand(line, tasks);


        }
    }
}

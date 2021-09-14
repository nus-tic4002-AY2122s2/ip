import duke.dukeTask.*;
import duke.dukeException.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;

public class Duke {
    private static ArrayList<Task> taskList = new ArrayList<Task>(100);
    private static int counter = 0;
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("what can i do for you?\n");
        getMsg();
    }

    private static void getMsg(){
        String file_path = "/Users/joseph/Desktop/ip/src/main/java/taskList.txt";
        try {
            readFile(file_path);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        counter = taskList.size();
        String line;
        Scanner sc = new Scanner(System.in);
        // any other user input
        String[] userInput = null;
        String command;
        String input;
        String description = "";
        String date = "";
        // user input loops
        while (true) {
            line = sc.nextLine().trim();
            // exit program
            if (line.equals("bye")){
                System.out.println("Bye.Hope to see you again soon!");
                sc.close();
                break;
            }else{
                // check for user command and input
                userInput = line.split(" ",2);
                command = userInput[0].trim().toLowerCase();
                switch(command){
                    case "todo":
                        try{
                            if(userInput[1].trim() == ""){
                                throw new DukeException();
                            }
                            description = userInput[1].trim();
                            saveFunction(new Todo(description));
                            saveToFile(file_path,"T",description,"");
                        }catch(IndexOutOfBoundsException | DukeException e){
                             System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                        }catch(IOException e1){
                             e1.printStackTrace();
                        }
                        break;
                    case "done":
                        try{
                            if(userInput[1].trim() == ""){
                                throw new DukeException();
                            }
                            doneFunction(Integer.valueOf(userInput[1].trim())-1);
                            donePrint();
                            changeIsDone(file_path,Integer.valueOf(userInput[1].trim())-1);
                        }catch (IndexOutOfBoundsException | DukeException e){
                            System.out.println("☹ OOPS!!! Please enter an index.");
                        }
                        catch (NullPointerException e){
                            System.out.println(" ☹ OOPS!!! The index you have key in dose not exist.");
                        }catch(IOException e1){
                            e1.printStackTrace();
                        }
                        break;
                    case "deadline":
                        try{
                            if(userInput[1].trim() == ""){
                                throw new DukeException();
                            }
                            description = userInput[1].trim().substring(0, userInput[1].trim().indexOf("/by")-1);
                            date = userInput[1].trim().substring(userInput[1].trim().indexOf("/by")+4, userInput[1].trim().length());
                            saveFunction(new Deadline(description, date));
                            saveToFile(file_path,"D",description,date);
                        }catch(IndexOutOfBoundsException | DukeException e){
                            System.out.println("☹ OOPS!!! Please check deadline command that you have key in is in correct format.");
                        }catch(IOException e1){
                            e1.printStackTrace();
                        }
                        break;
                    case "event":
                        try{
                            if(userInput[1].trim() == ""){
                                throw new DukeException();
                            }
                            description = userInput[1].trim().substring(0, userInput[1].trim().indexOf("/at") - 1);
                            date = userInput[1].trim().substring(userInput[1].trim().indexOf("/at") + 4, userInput[1].trim().length());
                            saveFunction(new Event(description, date));
                            saveToFile(file_path,"E",description,date);
                        }catch(IndexOutOfBoundsException | DukeException e){
                            System.out.println("☹ OOPS!!! Please check event command that you have key in is in correct format.");
                        }catch(IOException e1){
                            e1.printStackTrace();
                        }
                        break;
                    case "list":
                        printListFunction();
                        break;
                    case "delete":
                        try{
                            if(userInput[1].trim() == ""){
                                throw new DukeException();
                            }
                            deleteFunction(Integer.valueOf(userInput[1].trim())-1);
                            deleteFromFile(file_path, Integer.valueOf(userInput[1].trim())-1);
                        }catch(IndexOutOfBoundsException | DukeException e){
                            System.out.println("☹ OOPS!!! The description of a delete cannot be empty.");
                        }catch(IOException e1){
                            e1.printStackTrace();
                        }
                        break;
                    default:
                        wrongCommand();
                }
            }
        }
    }

    private static void printListFunction(){
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; i < counter; i++){
            System.out.println((i+1) + "." +  taskList.get(i).toString());
        }
    }

    private static void doneFunction(int listLocation){
        Task t = taskList.get(listLocation);
        t.markAsDone();
        System.out.println("    " + t.toString()) ;
    }

    private static void changeIsDone(String file_path, int taskIndex) throws IOException {
        FileWriter fileWriter = new FileWriter(file_path, true);
        BufferedReader fileRead = new BufferedReader(new FileReader(file_path));
        PrintWriter printWriter = new PrintWriter(fileWriter);
        StringBuffer inputBuffer = new StringBuffer();
        String line = "";
        for(int i = 0; i < taskList.size(); i++ ){
            line = fileRead.readLine();
            if(i == taskIndex){
                // change task to done in txt file
                String[] splitLine = line.split(" \\| ");
                String changeToDone = "";
                for(int k = 0; k < splitLine.length; k++){
                    if(k == splitLine.length-1){
                        changeToDone += splitLine[k];
                    }else if (k == 1){
                        changeToDone += "1" + " | ";
                    }else{
                        changeToDone += splitLine[k] + " | ";
                    }

                }
                inputBuffer.append(changeToDone);
            }else{
                inputBuffer.append(line);
            }
            inputBuffer.append('\n');
        }
        FileOutputStream fileOut = new FileOutputStream(file_path);
        fileOut.write(inputBuffer.toString().getBytes());
        fileWriter.close();
        fileRead.close();
        printWriter.close();
        fileOut.close();
    }

    private static void saveFunction(Task description){
        taskList.add(description);
        System.out.println("Got it. I've added this task:");
        System.out.println("   " + taskList.get(counter).toString());
        counter++;
        System.out.println("Now you have " + counter + " tasks in the list.");
    }

    private static void saveToFile(String file_path, String taskClass, String description, String date) throws IOException {
        FileWriter fileWriter = new FileWriter(file_path, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String taskData = taskClass + " | " + "0" + " | " + description;
        if (date == ""){
            printWriter.println(taskData);  //New line
        }else{
            taskData = taskData + " | " + date;
            printWriter.println(taskData);  //New line
        }
        System.out.println(taskData);
        fileWriter.close();
        printWriter.close();
    }

    private static void wrongCommand(){
        System.out.print("You have enter an invalid command!!!");
    }

    private static void donePrint(){
        System.out.println("Nice! I've marked this task as done:");
    }

    private static void deleteFunction(int listLocation){
        System.out.println("Noted. I've removed this task:");
        System.out.println("   " + taskList.get(listLocation).toString());
        counter--;
        System.out.println("Now you have " + counter + " tasks in the list.");
        taskList.remove(listLocation);
    }

    private static void deleteFromFile(String file_path, int taskIndex) throws IOException {
        FileWriter fileWriter = new FileWriter(file_path, true);
        BufferedReader fileRead = new BufferedReader(new FileReader(file_path));
        PrintWriter printWriter = new PrintWriter(fileWriter);
        StringBuffer inputBuffer = new StringBuffer();
        String line = "";
        for(int i = 0; i < taskList.size(); i++ ){
            line = fileRead.readLine();
            if(i != taskIndex){
                // keep all other task other than deleted task
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
        }
        FileOutputStream fileOut = new FileOutputStream(file_path);
        fileOut.write(inputBuffer.toString().getBytes());
        fileWriter.close();
        fileRead.close();
        printWriter.close();
        fileOut.close();
    }


    private static void readFile(String file_path) throws IOException {
        BufferedReader fileRead = new BufferedReader(new FileReader(file_path));
        String line = fileRead.readLine();
        while(line != null){
            String[] splitLine = line.split(" \\| ");
            switch(splitLine[0]){
                case "E":
                    Event newEvent = new Event(splitLine[2], splitLine[3]);
                    if(splitLine[1].equals("1")){
                        newEvent.markAsDone();
                    }
                    taskList.add(newEvent);
                    break;
                case "D":
                    Deadline newDeadline = new Deadline(splitLine[2], splitLine[3]);
                    if(splitLine[1].equals("1")){
                        newDeadline.markAsDone();
                    }
                    taskList.add(newDeadline);
                    break;
                case "T":
                    Todo newTodo = new Todo(splitLine[2]);
                    if(splitLine[1].equals("1")){
                        newTodo.markAsDone();
                    }
                    taskList.add(newTodo);
            }
            line = fileRead.readLine();
        }
        fileRead.close();
    }
}

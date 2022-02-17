package seedu.duke;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.io.FileOutputStream;

public class Storage {
    public static TaskList taskList;

    public Storage(TaskList taskList) {
        this.taskList = taskList;
    }

    /**
     * Read all task details from DB file and store them to taskList.
     */
    public void readFile() throws FileNotFoundException, IOException {
        BufferedReader fileRead = new BufferedReader(new FileReader("TaskDB.txt"));
        String line = fileRead.readLine();
        while (line != null) {

            if (line.contains("todo")) {
                Main.taskList.addToDo(line);
                line = fileRead.readLine();
                continue;
            }
            if (line.contains("deadline")) {
                Main.taskList.addDeadline(line);
                line = fileRead.readLine();
                continue;
            }

            if (line.contains("event")) {
                Main.taskList.addDeadline(line);
                line = fileRead.readLine();
                continue;
            }

            line = fileRead.readLine();
        }
        System.out.println("You have " + taskList.getSize() + " tasks in your record.");
        fileRead.close();

    }

    /**
     * Save task details into taskDB file.
     */
    public static void saveToDB(String taskData) throws IOException {
        FileWriter fileWriter = new FileWriter("TaskDB.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(taskData);
        fileWriter.close();
        printWriter.close();
    }

    /**
     * deleted task details from taskDB file.
     */
    public static void deleteFromDB(String message) throws IOException {
        BufferedReader fileRead = new BufferedReader(new FileReader("taskDB.txt"));
        StringBuffer inputBuffer = new StringBuffer();
        String line = "";
        String number = message.substring(7).trim();
        int index = Integer.parseInt(number);
        for (int i = 0; i < taskList.getSize(); i++) {
            line = fileRead.readLine();
            if (i != index) {
                // keep all other task other than deleted task
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
        }
        FileOutputStream fileOut = new FileOutputStream("TaskDB.txt");
        fileOut.write(inputBuffer.toString().getBytes());
        fileRead.close();
        fileOut.close();
    }

    /**
     * mark task in taskDB.
     */
    //can try to add /mark true/false as the record, need to check /mark before checking/assign
    public static void markTaskDB(String message) throws IOException {
        BufferedReader fileRead = new BufferedReader(new FileReader("TaskDB.txt"));
        StringBuffer inputBuffer = new StringBuffer();
        String desc = "";
        String line = "";
        String number = message.substring(5).trim();
        int index = Integer.parseInt(number);
        index = index - 1;
        int markIndex = message.indexOf("/mark");
        for (int i = 0; i < taskList.getSize(); i++) {
            line = fileRead.readLine();
            if (i == index) {
                int fileMarkIndex = line.indexOf("/mark");
                if (fileMarkIndex != -1) {
                    desc = message.substring(0, fileMarkIndex - 1);
                } else {
                    desc = message;
                }
                String newDetail = desc + " /mark true";
                inputBuffer.append(newDetail);
            } else {
                inputBuffer.append(line);
            }
            inputBuffer.append('\n');
        }
        FileOutputStream fileOut = new FileOutputStream("TaskDB.txt");
        fileOut.write(inputBuffer.toString().getBytes());
        fileRead.close();
        fileOut.close();
    }

    /**
     * edit task details in taskDB.
     */
    //can try to add /mark true/false as the record, need to check /mark before checking/assign
    /*public static void editFlightDB(String message) throws IOException {
        BufferedReader fileRead = new BufferedReader(new FileReader("TaskDB.txt"));
        StringBuffer inputBuffer = new StringBuffer();
        String from = "";
        String to = "";
        String date = "";
        String price = "";
        String line = "";
        String number = message.substring(5,message.indexOf('/')).trim();
        int index = Integer.parseInt(number);
        index = index - 1;
        int fromIndex = message.indexOf("/from");
        int toIndex = message.indexOf("/to");
        int dateIndex = message.indexOf("/date");
        int priceIndex = message.indexOf("/price");
        for (int i = 0; i < taskList.getSize(); i++) {
            line = fileRead.readLine();
            if (i == index) {
                int fileFromIndex = line.indexOf("/from");
                int fileToIndex = line.indexOf("/to");
                int fileDateIndex = line.indexOf("/date");
                int filePriceIndex = line.indexOf("/price");
                from = line.substring(fileFromIndex + 6, fileToIndex);
                to = line.substring(fileToIndex + 4, fileDateIndex);
                date = line.substring(fileDateIndex + 6, filePriceIndex);
                price = line.substring(filePriceIndex + 7);
                if (fromIndex != -1) {
                    from = message.substring(fromIndex + 6) + " ";
                }
                if (toIndex != -1) {
                    to = message.substring(toIndex + 4) + " ";
                }
                if (dateIndex != -1) {
                    date = message.substring(dateIndex + 6) + " ";
                }
                if (priceIndex != -1) {
                    price = message.substring(priceIndex + 7);
                }
                String newDetail = "add /from " + from + "/to " + to + "/date " + date + "/price " + price;
                inputBuffer.append(newDetail);
            } else {
                inputBuffer.append(line);
            }
            inputBuffer.append('\n');
        }
        FileOutputStream fileOut = new FileOutputStream("TaskDB.txt");
        fileOut.write(inputBuffer.toString().getBytes());
        fileRead.close();
        fileOut.close();
    }*/
}
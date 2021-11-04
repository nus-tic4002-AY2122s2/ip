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
    public static FlightList flightList;

    public Storage(FlightList flightList) {
        this.flightList = flightList;
    }

    /**
     * Read all flight details from DB file and store them to fightList.
     */
    public void readFile() throws FileNotFoundException, IOException {
        BufferedReader fileRead = new BufferedReader(new FileReader("FlightDB.txt"));
        String line = fileRead.readLine();
        while (line != null) {
            flightList.addFlight(line);
            line = fileRead.readLine();
        }
        System.out.println("You have " + flightList.getSize()
                                        + " flights in your record");
        fileRead.close();

    }

    /**
     * Save fight details into flightDB file.
     */
    public static void saveToDB(String flightData) throws IOException {
        FileWriter fileWriter = new FileWriter("FlightDB.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(flightData);
        fileWriter.close();
        printWriter.close();
    }

    /**
     * deleted flight details from flightDB file.
     */
    public static void deleteFromDB(String message) throws IOException {
        BufferedReader fileRead = new BufferedReader(new FileReader("FlightDB.txt"));
        StringBuffer inputBuffer = new StringBuffer();
        String line = "";
        String number = message.substring(7).trim();
        int index = Integer.parseInt(number);
        for (int i = 0; i < flightList.getSize(); i++) {
            line = fileRead.readLine();
            if (i != index) {
                // keep all other task other than deleted task
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
        }
        FileOutputStream fileOut = new FileOutputStream("FlightDB.txt");
        fileOut.write(inputBuffer.toString().getBytes());
        fileRead.close();
        fileOut.close();
    }

    /**
     * edit flight details in flightDB.
     */
    public static void editFlightDB(String message) throws IOException {
        FileWriter fileWriter = new FileWriter("FlightDB.txt", true);
        BufferedReader fileRead = new BufferedReader(new FileReader("FlightDB.txt"));
        PrintWriter printWriter = new PrintWriter(fileWriter);
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
        for (int i = 0; i < flightList.getSize(); i++) {
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
        FileOutputStream fileOut = new FileOutputStream("FlightDB.txt");
        fileOut.write(inputBuffer.toString().getBytes());
        fileWriter.close();
        fileRead.close();
        printWriter.close();
        fileOut.close();
    }
}
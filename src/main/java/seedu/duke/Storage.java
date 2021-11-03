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
}
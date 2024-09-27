package Storage;
import java.io.*;
import java.util.ArrayList;

import Tasks.Task;

import java.util.Scanner;

public class Storage {

    /**
     * Default path of file.
     */
//    C:\Users\lmkan\Desktop\NUS\TIC 4001\ip\data
    public static final String DEFAULT_PATH = "C:/Users/lmkan/Desktop/NUS/TIC 4001/ip/data/dukeTaskOutput.txt";
    public String file_path = "data/dukeTaskOuput.txt";
    private  String filename;

    /**
     * Storage class Constructor
     */
    public Storage(String filename){
        this.filename = filename;
    }

    public ArrayList<String> load() throws FileNotFoundException {
        ArrayList<String> output = new ArrayList<>();
        File f = new File(file_path);
        Scanner scan = new Scanner(f);
        while (scan.hasNextLine()) {
            output.add(scan.nextLine());
        }
        scan.close();
        return output;
    }


    public void saveFile(ArrayList<Task> list) throws IOException {
        FileWriter file = new FileWriter("data/dukeTaskOuput.txt");
        String tmp = "";
        try {
            for (int i = 0; i < list.size(); i++){
                tmp = tmp + list.get(i).toString() + System.lineSeparator();

                tmp = tmp.replace("(by:", "|").replace("(at:", "|").
                        replace(")", "").replaceAll("\\[", "").
                        replaceAll("]", "|").replace("Y", "1").
                        replace("N", "0").replace("after", "|");
            }
            file.write(tmp);
            file.close();
        }

        catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }



    }




}
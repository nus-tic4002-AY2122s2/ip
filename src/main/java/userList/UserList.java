package userList;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import exception.ErrorHandler;
import parser.DataParser;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

public class UserList {
    private ArrayList<Task> list = new ArrayList<>();

    public UserList () throws ErrorHandler {
        this.loadData();
    }

    public void addItem (Task task) throws ErrorHandler {
        this.list.add(task);
        this.saveData();
    }

    public ArrayList<Task> getList() { return this.list; }

    public ArrayList<String> getSerializedList () {
        ArrayList<String> taskList = new ArrayList<>();

        for (Task task : this.list) {
            taskList.add(task.toString());
        }

        return taskList;
    }

    private void loadData () throws ErrorHandler  {
        try {
            Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
            File file=new File(root + "/data/duke.txt");    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            String line;

            while((line=br.readLine())!=null) {
                DataParser parser = new DataParser(line);
                String taskType = parser.getTaskType().toUpperCase();
                boolean status = parser.getStatus();

                if(taskType.equals("T")) {
                    this.list.add(new Todo(parser.getContent(), status));
                }

                if(taskType.equals("D")) {
                    this.list.add(new Deadline(parser.getContent(), parser.getBy(), status));
                }

                if(taskType.equals("E")){
                    this.list.add(new Event(parser.getContent(), parser.getAt(), status));
                }
            }

            fr.close();    //closes the stream and release the resources
        } catch(FileNotFoundException e) {
            throw new ErrorHandler("Loading data");
        } catch (IOException e) {
            throw new ErrorHandler("reading data");
        }
    }

    public void saveData() throws ErrorHandler {
        try {
            Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
            FileWriter fileWriter = new FileWriter(root + "/data/duke.txt");

            for(Task task: this.list) {
                String line = task.toDataFormat();
                fileWriter.write(line);
                fileWriter.write("\n");
            }

            fileWriter.close();
        } catch (IOException e) {
            throw new ErrorHandler("writing data");
        }
    }
}


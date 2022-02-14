package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Todo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Stores method to deal with loading and saving from file.
 * */
public class Storage {
    protected String filePath;

    /**
     * Create new Storage.
     * @param filePath file address.
     * */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Load file to new Duke task list.
     * @param taskList task list to be loaded.
     * */
    public void loadFile(TaskList taskList) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String s;
            while ((s = br.readLine()) != null) {
                String[] command = s.split("\\|", 0);

                switch (command[0].trim()) {
                case "T":
                    taskList.tasks.add(new Todo(command[2].trim()));
                    taskList.size++;
                    if (command[1].trim().equals("Y")) {
                        taskList.tasks.get(taskList.size - 1).markAsDone();
                    }
                    break;
                case "E":
                    taskList.tasks.add(new Event(command[2].trim(), command[3].trim(),
                            Parser.convertDate(command[3].trim())));
                    if (command[1].trim().equals("Y")) {
                        taskList.tasks.get(taskList.size - 1).markAsDone();
                    }
                    taskList.size++;
                    break;
                case "D":
                    taskList.tasks.add(new Deadline(command[2].trim(), command[3].trim(),
                            Parser.convertDate(command[3].trim())));
                    if (command[1].trim().equals("Y")) {
                        taskList.tasks.get(taskList.size - 1).markAsDone();
                    }
                    taskList.size++;
                    break;
                default:
                    System.out.println("Data format is not correct.");
                }
            }
        } catch (IOException e) {
            UI.splitLine();
            System.out.println("Oops!! Cannot load file!");
            UI.splitLine();
        }
    }

    /**
     * Save updates to file.
     * @param taskList task list to be saved.
     * */
    public void saveFile(TaskList taskList) {
        try {
            FileWriter fw = new FileWriter(filePath);

            for (int i = 0; i < taskList.tasks.size(); i++) {
                fw.write(taskList.tasks.get(i).save_toString() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Oops!! Cannot save file!");
        }
    }
}

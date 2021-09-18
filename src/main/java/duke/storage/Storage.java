package duke.storage;

import duke.parse.StringParser;
import duke.task.Task;
import duke.ui.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Storage implements PropertyChangeListener {
    private static final Path DEFAULT_PATH = Paths.get("./data");
    private static final Path FILE = Paths.get("./data/duke.txt");

    public Storage () {
        try {
            Files.createDirectories(DEFAULT_PATH);
        } catch (IOException e) {
            Message.echo("Failed to create directory"
                        + e.getMessage());
        }
        try {
            Files.createFile(FILE);

        } catch (FileAlreadyExistsException e) {
            // Do nothing
        } catch(IOException e) {
            Message.echo("Failed to create file"
                    + e.getMessage());
        }
    }

    public Path getFile() {
        return FILE;
    }

    public void listInit(TempTaskList tasks) {
        try {
            Stream<String> lines = Files.lines(FILE);

            lines.map(StringParser::stringToTask)
                    .forEach(tasks::add);

            lines.close();

        } catch (IOException e) {
            Message.echo("Unable to read data: "
                    + e.getMessage());
        }
    }

    public void writeFromTaskList(ArrayList<Task> list) {
        String lines = new String();
        for (Task task : list) {
            String line = task.toString();
            lines += line + System.lineSeparator();
        }
        try {
            Files.write(FILE,
                    lines.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            Message.echo("Unable to write data: "
                    + e.getMessage());
        }
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        var list = (ArrayList) evt.getNewValue();
        this.writeFromTaskList(list);
    }
}

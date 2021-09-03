package duke.command;

import duke.exception.UnknownCommandException;
import duke.storage.TempTaskList;

import java.io.File;
import java.util.HashMap;

public class CommandFactory {
    private HashMap<String, Command> commands = new HashMap<>();

    private TempTaskList list;
    private File file;

    public CommandFactory(TempTaskList list, File file) {
        this.list = list;
        this.file = file;

        config();
    }


    private void config() {
        add("todo", new TodoCreationCmd(list));
        add("event", new EventCreationCmd(list));
        add("deadline", new DLCreationCmd(list));
        add("done", new TaskMarkDoneCmd(list));
    }


    public Command get(String key)  {
        return commands.get(key);
    }

    public void add(String key, Command value) {
        commands.put(key, value);
    }

    public boolean containsKey(String key) {
        return commands.containsKey(key);
    }

}

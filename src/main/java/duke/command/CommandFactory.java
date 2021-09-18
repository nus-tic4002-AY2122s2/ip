package duke.command;

import duke.storage.TempTaskList;
import duke.ui.Message;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public class CommandFactory implements Iterable {
    private HashMap<String, Command> commands = new HashMap<>();

    private TempTaskList list;
    private File file;

    public CommandFactory(TempTaskList list) {
        this.list = list;

        config();
    }

    // add new keyword - command pair to the Map
    private void config() {
        add("todo", new TodoCreationCmd(list));
        add("event", new EventCreationCmd(list));
        add("deadline", new DLCreationCmd(list));
        add("done", new TaskMarkDoneCmd(list));
        add("cmd", new AllCommandCmd(this));
        add("delete", new TaskDeleteCmd(list));
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

    public void print() {
        for (String key : commands.keySet()) {
            Message.echo(key);
        }
    }

    @Override
    public Iterator iterator() {
        return commands.keySet().iterator();
    }
}

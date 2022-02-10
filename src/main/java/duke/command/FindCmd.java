package duke.command;

import java.util.concurrent.atomic.AtomicInteger;

import duke.parse.StringParser;
import duke.storage.TempTaskList;
import duke.ui.Message;

public class FindCmd implements Command {
    protected TempTaskList list;

    public FindCmd(TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
        String key = StringParser.join(args);
        AtomicInteger i = new AtomicInteger(1);
        list.stream()
                .filter(t -> t.getTitle().contains(key.strip()))
                .forEach(t ->
                        Message.appendBuffer(
                                        i.getAndIncrement()
                                             + ". "
                                             + t.toString()
                                             + System.lineSeparator()));
    }
}

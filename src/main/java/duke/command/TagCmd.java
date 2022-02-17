package duke.command;

import duke.storage.TempTaskList;

public class TagCmd implements Command {
    private TempTaskList list;

    public TagCmd (TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
        assert true;
    }
}

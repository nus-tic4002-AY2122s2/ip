package duke.task;

import duke.exception.DukeMissingDescException;

public class ToDo extends Task {

    public ToDo(String description) throws DukeMissingDescException {
        super(description);
    }

    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }
}

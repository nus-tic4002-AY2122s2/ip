package duke.exception;

import duke.ui.Message;

public class NoDateException extends DukeException {
    public NoDateException() {super();}

    @Override
    public String getMessage() {
        return Message.exceptionNoDate();
    }
}

package duke.exception;

import duke.ui.Message;

public class NumArgsException extends DukeException {
    public NumArgsException() {super();}

    @Override
    public String getMessage() {
        return Message.exceptionNumArgs();
    }
}

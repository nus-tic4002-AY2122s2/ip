package duke.exception;

public class DukeUnknownException extends DukeException {
    public DukeUnknownException() {
        super();
    }

    public DukeUnknownException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "OOPS!!! I'm sorry, but I don't know what that means :-(";
    }
}

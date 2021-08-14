package exception;

public class DukeMissingParamException extends DukeException {
    private String message;
    public DukeMissingParamException(String command) {
        this.message = String.format("OOPS!!! The description of %s cannot be empty.", command);
    }
    @Override
    public String getMessage() {
        return message;
    }
}

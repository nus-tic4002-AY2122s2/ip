package exceptions;

public class DukeDateTimeError extends Throwable {
    private String errorType;

    public DukeDateTimeError(String errorType) {
        this.errorType = errorType;
    }

    public static void inputDateTimeFormatWrong() {
        System.out.println("     Oops! The dateTime input format wrong. Please try again.");
    }
}

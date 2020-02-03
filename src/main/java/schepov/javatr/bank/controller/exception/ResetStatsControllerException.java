package schepov.javatr.bank.controller.exception;

public class ResetStatsControllerException extends Exception {
    public ResetStatsControllerException() {
        super();
    }

    public ResetStatsControllerException(Throwable cause) {
        super(cause);
    }

    public ResetStatsControllerException(String message){
        super(message);
    }

    public ResetStatsControllerException(String message, Throwable cause){
        super(message, cause);
    }
}

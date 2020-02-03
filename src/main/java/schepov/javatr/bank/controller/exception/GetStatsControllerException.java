package schepov.javatr.bank.controller.exception;

public class GetStatsControllerException extends Exception {
    public GetStatsControllerException() {
        super();
    }

    public GetStatsControllerException(Throwable cause) {
        super(cause);
    }

    public GetStatsControllerException(String message){
        super(message);
    }

    public GetStatsControllerException(String message, Throwable cause){
        super(message, cause);
    }
}

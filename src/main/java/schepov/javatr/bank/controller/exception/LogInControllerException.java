package schepov.javatr.bank.controller.exception;

public class LogInControllerException extends Exception {
    public LogInControllerException() {
        super();
    }

    public LogInControllerException(Throwable cause) {
        super(cause);
    }

    public LogInControllerException(String message){
        super(message);
    }

    public LogInControllerException(String message, Throwable cause){
        super(message, cause);
    }
}
